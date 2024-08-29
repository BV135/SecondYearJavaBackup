package Prac9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class fileWritingGUI extends JFrame implements ActionListener {
  private JPanel pnlNorth = new JPanel();
  private JPanel pnlCentre = new JPanel();
  private JPanel pnlSouth = new JPanel();
  private JPanel pnlRB1 = new JPanel();
  private JPanel pnlRB2 = new JPanel();

  private JLabel lblDept = new JLabel("Department: ");
  String s1[] = { "Select", "Civil Engineering", "Architecture", "Computer Science", "Information Technology",
      "Mathematics", "Art & Culture" };
  @SuppressWarnings("rawtypes")
  private JComboBox cboDept = new JComboBox<>(s1);

  private JLabel lblFirstName = new JLabel("First Name: ");
  private JTextField txtFirstName = new JTextField();

  private JLabel lblLastName = new JLabel("Last Name");
  private JTextField txtLastName = new JTextField();

  private JLabel lblEmploymentType = new JLabel("Employment Type: ");
  private JRadioButton radPermanent = new JRadioButton("Permanent");
  private JRadioButton radTemporary = new JRadioButton("Temporary");
  private ButtonGroup TypeGroup = new ButtonGroup();

  private JLabel lblDummy = new JLabel("");

  private DefaultTableModel tableModel;
  private JTable table;

  private JButton btnSaveToFile = new JButton("Save to File");
  private JButton btnExit = new JButton("Exit ");

  Prac9FileHandler p;
  private String strOutput;

  public fileWritingGUI() {
    super("University Staff Application");

    tableModel = new DefaultTableModel();
    table = new JTable(tableModel);

    setLayout(new BorderLayout());
    pnlNorth.setLayout(new GridLayout(2, 2));
    pnlCentre.setLayout(new GridLayout());
    pnlSouth.setLayout(new GridLayout(1, 2));
    pnlRB1.setLayout(new GridLayout(2, 1));
    pnlRB2.setLayout(new GridLayout(2, 1));

    pnlNorth.add(lblDept);
    lblDept.setHorizontalAlignment(JLabel.LEFT);
    pnlNorth.add(cboDept);
    pnlNorth.add(lblFirstName);
    lblFirstName.setHorizontalAlignment(JLabel.LEFT);
    pnlNorth.add(txtFirstName);
    txtFirstName.setHorizontalAlignment(JTextField.RIGHT);

    pnlNorth.add(lblLastName);
    lblLastName.setHorizontalAlignment(JLabel.LEFT);
    pnlNorth.add(txtLastName);
    txtLastName.setHorizontalAlignment(JLabel.RIGHT);

    pnlNorth.add(lblEmploymentType);
    pnlNorth.add(radPermanent);
    pnlNorth.add(lblDummy);
    pnlNorth.add(radTemporary);
    lblEmploymentType.setHorizontalAlignment(JLabel.LEFT);
    lblDummy.setHorizontalAlignment(JLabel.LEFT);
    pnlNorth.add(pnlRB1);
    pnlNorth.add(pnlRB2);
    pnlRB1.add(radPermanent);
    pnlRB2.add(radTemporary);
    TypeGroup.add(radPermanent);
    TypeGroup.add(radTemporary);

    tableModel.addColumn("Department");
    tableModel.addColumn("First Name");
    tableModel.addColumn("Last Name");
    tableModel.addColumn("Employment Type");
    pnlCentre.add(new JScrollPane(table));

    pnlSouth.add(btnSaveToFile);
    pnlSouth.add(btnExit);

    this.add(pnlNorth, BorderLayout.NORTH);
    this.add(pnlCentre, BorderLayout.CENTER);
    this.add(pnlSouth, BorderLayout.SOUTH);

    btnSaveToFile.addActionListener(this);
    btnExit.addActionListener(this);

    p = new Prac9FileHandler();

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnSaveToFile) {

      p.openFile();
      try {
        p.openFileSimple();
      } catch (IOException e1) {
        e1.printStackTrace();
      }

      String department = (String) cboDept.getSelectedItem();
      String name = txtFirstName.getText();
      String surname = txtLastName.getText();
      String employment = " ";
      if (radPermanent.isSelected()) {
        employment = "Permanent";
      } else if (radTemporary.isSelected()) {
        employment = "Temporary";
      }

      DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
      tblModel.addRow(new Object[] { department, name, surname, employment });
      strOutput = (String) cboDept.getSelectedItem() + "#" + txtFirstName.getText() + "#" + txtLastName.getText() + "#"
          + employment + "\n";

      p.processFile(strOutput);
      p.closeFile();
      cboDept.setSelectedItem(-1);
      txtFirstName.setText(" ");
      txtLastName.setText(" ");
      TypeGroup.clearSelection();

    } else if (e.getSource() == btnExit) {
      System.exit(0);
    }

  }

}
