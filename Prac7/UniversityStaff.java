package Prac7;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class UniversityStaff extends JFrame implements ActionListener {
  private JPanel pnlNorth;
  private JPanel pnlCentre;
  private JPanel pnlSouth;
  private JPanel pnlRB1;
  private JPanel pnlRB2;

  private JLabel lblDepartment;
  @SuppressWarnings("rawtypes")
  private JComboBox cboFalcuty;

  private JLabel lblFirstName;
  private JTextField txtFirstName;

  private JLabel lblLastName;
  private JTextField txtLastName;

  private JLabel lblEmploymentType;
  private JRadioButton radPermanent;
  private JRadioButton radTemporary;
  private ButtonGroup TypeGroup;

  private DefaultTableModel tableModel;
  private JTable table;

  private JButton btnAdd;
  private JButton btnExit;

  public UniversityStaff() {
    super("University Staff Application");
    pnlNorth = new JPanel();
    pnlCentre = new JPanel();
    pnlSouth = new JPanel();
    pnlRB1 = new JPanel();
    pnlRB2 = new JPanel();

    lblDepartment = new JLabel("Department");
    String s1[] = { "Select", "Civil Engineering", "Architecture", "Computer Science", "Information Technology",
        "Mathematics", "Art & Culture" };
    cboFalcuty = new JComboBox<>(s1);

    lblFirstName = new JLabel("First Name: ");
    txtFirstName = new JTextField(15);

    lblLastName = new JLabel("Last Name: ");
    txtLastName = new JTextField(15);

    lblEmploymentType = new JLabel("Employment Type: ");
    radPermanent = new JRadioButton("Permanent");
    radTemporary = new JRadioButton("Temporary");
    TypeGroup = new ButtonGroup();

    tableModel = new DefaultTableModel();
    table = new JTable(tableModel);

    btnAdd = new JButton("Add to Table");
    btnExit = new JButton("EXIT");

    setLayout(new BorderLayout());
    pnlNorth.setLayout(new GridLayout(5, 2));
    pnlCentre.setLayout(new GridLayout());
    pnlSouth.setLayout(new GridLayout(1, 2));
    pnlRB1.setLayout(new GridLayout(2, 2));
    pnlRB2.setLayout(new GridLayout(1, 2));

    pnlNorth.add(lblDepartment);
    lblDepartment.setHorizontalAlignment(JLabel.LEFT);
    pnlNorth.add(cboFalcuty);

    pnlNorth.add(lblFirstName);
    lblFirstName.setHorizontalAlignment(JLabel.LEFT);
    pnlNorth.add(txtFirstName);
    txtFirstName.setHorizontalAlignment(JTextField.RIGHT);

    pnlNorth.add(lblLastName);
    lblLastName.setHorizontalAlignment(JLabel.LEFT);
    pnlNorth.add(txtLastName);
    txtLastName.setHorizontalAlignment(JLabel.RIGHT);

    pnlNorth.add(lblEmploymentType);
    lblEmploymentType.setHorizontalAlignment(JLabel.LEFT);
    pnlNorth.add(radPermanent);
    pnlNorth.add(radTemporary);
    pnlNorth.add(pnlRB1);
    pnlNorth.add(pnlRB2);
    pnlRB1.add(radPermanent);
    pnlRB1.add(radTemporary);

    TypeGroup.add(radPermanent);
    TypeGroup.add(radTemporary);
    radPermanent.setHorizontalAlignment(JLabel.LEFT);
    radTemporary.setHorizontalAlignment(JLabel.LEFT);

    tableModel.addColumn("Department");
    tableModel.addColumn("First Name");
    tableModel.addColumn("Last Name");
    tableModel.addColumn("Employment Type");
    pnlCentre.add(new JScrollPane(table));

    pnlSouth.add(btnAdd);
    pnlSouth.add(btnExit);

    this.add(pnlNorth, BorderLayout.NORTH);
    this.add(pnlCentre, BorderLayout.CENTER);
    this.add(pnlSouth, BorderLayout.SOUTH);

    btnAdd.addActionListener(this);
    btnExit.addActionListener(this);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnAdd) {
      String department = (String) cboFalcuty.getSelectedItem();
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
      cboFalcuty.setSelectedItem(false);
      txtFirstName.setText(" ");
      txtLastName.setText(" ");
      TypeGroup.clearSelection();

    } else if (e.getSource() == btnExit) {
      System.exit(0);
    }

  }

}
