package WritingToSerializedFile2024;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BookingGUI extends JFrame implements ActionListener {
  private JPanel pnlNorth = new JPanel();
  private JPanel pnlCentre = new JPanel();
  private JPanel pnlSouth = new JPanel();
  private JPanel pnlRB = new JPanel();

  private JLabel lblHeading = new JLabel("CPUT RESTAURANT");

  private JLabel lblTitle = new JLabel("Title");
  String s1[] = { "Adv", "Dr.", "Miss", "Mr", "Prof" };
  private JComboBox cboTitle = new JComboBox<>(s1);

  private JLabel lblFirstName = new JLabel("First Name: ");
  private JTextField txtFirstName = new JTextField();

  private JLabel lblLastName = new JLabel("Last Name: ");
  private JTextField txtLastName = new JTextField();

  private JRadioButton radSmoking = new JRadioButton("Smoking");
  private JRadioButton radNonSmoking = new JRadioButton("Non-Smoking");
  private ButtonGroup SmokingGroup = new ButtonGroup();

  private JCheckBox chkStaff = new JCheckBox("Staff Member");

  private JButton btnSaveToFile = new JButton("Save To File");
  private JButton btnCloseFile = new JButton("Close File");
  private JButton btnExit = new JButton("Exit");

  private Font ft1 = new Font("Arial", Font.BOLD, 24);
  private Font ft2 = new Font("Arial", Font.ITALIC, 20);

  SerFileHandler serFileHandlerObject;
  Customer customer;
  private String strOutput;

  public BookingGUI() {
    super("Assignment 6 - Restaurant Booking");
    pnlNorth.setLayout(new FlowLayout());
    pnlCentre.setLayout(new GridLayout(4, 2));
    pnlSouth.setLayout(new GridLayout(1, 3));
    pnlRB.setLayout(new GridLayout(2, 2));

    pnlNorth.add(lblHeading);
    lblHeading.setFont(ft1);
    lblHeading.setForeground(Color.YELLOW);
    pnlNorth.setBackground(Color.MAGENTA);

    pnlCentre.setBackground(Color.PINK);

    pnlCentre.add(lblTitle);
    lblTitle.setFont(ft2);
    lblTitle.setHorizontalAlignment(JLabel.LEFT);
    pnlCentre.add(cboTitle);

    pnlCentre.add(lblFirstName);
    lblFirstName.setFont(ft2);
    lblFirstName.setHorizontalAlignment(JLabel.LEFT);
    pnlCentre.add(txtFirstName);

    pnlCentre.add(lblLastName);
    lblLastName.setFont(ft2);
    lblLastName.setHorizontalAlignment(JLabel.LEFT);
    pnlCentre.add(txtLastName);

    pnlCentre.add(radSmoking);
    pnlCentre.add(radNonSmoking);
    pnlCentre.add(pnlRB);
    pnlRB.setBackground(Color.MAGENTA);
    pnlRB.add(radSmoking);
    pnlRB.add(radNonSmoking);
    SmokingGroup.add(radSmoking);
    SmokingGroup.add(radNonSmoking);
    pnlRB.add(chkStaff);

    pnlSouth.add(btnSaveToFile);
    pnlSouth.add(btnCloseFile);
    pnlSouth.add(btnExit);

    cboTitle.addActionListener(this);
    btnSaveToFile.addActionListener(this);
    btnCloseFile.addActionListener(this);
    btnExit.addActionListener(this);

    this.add(pnlNorth, BorderLayout.NORTH);
    this.add(pnlCentre, BorderLayout.CENTER);
    this.add(pnlSouth, BorderLayout.SOUTH);

    serFileHandlerObject = new SerFileHandler();
    serFileHandlerObject.openFile();

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnSaveToFile) {
      String title = (String) cboTitle.getSelectedItem();
      String firstName = txtFirstName.getText();
      String lastName = txtLastName.getText();
      String smoker = "";
      if (radSmoking.isSelected()) {
        smoker = "Smoking";
      } else if (radNonSmoking.isSelected()) {
        smoker = "Non-Smoking";
      }
      boolean staffMember = false;
      if (chkStaff.isSelected()) {
        staffMember = true;
      }
      if (!(title.isEmpty()) && !(firstName.isEmpty()) && !(lastName.isEmpty()) && !(smoker.isEmpty())) {
        customer = new Customer(title, firstName, lastName, smoker, staffMember);
        try {
          serFileHandlerObject.writeSerObject(customer);
        } catch (ClassNotFoundException e1) {
          e1.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Customer saved to file successfully!");
      } // end If
    } else if (e.getSource() == btnCloseFile) {
      serFileHandlerObject.closeFile();

    } else if (e.getSource() == btnExit) {
      System.exit(0);

    }
  }

}
// strOutput = customer.getTitle() + "#" + customer.getFirstName() + "#" +
// customer.getLastName() + "#"
// + customer.getSmoker() + "#" + customer.isStaff();

// fh.processFile(strOutput);