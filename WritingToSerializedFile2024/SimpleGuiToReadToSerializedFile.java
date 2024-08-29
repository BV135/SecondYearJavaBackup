package WritingToSerializedFile2024;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.ClassNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SimpleGuiToReadToSerializedFile extends JFrame implements ActionListener {
    private JPanel pnlNorth = new JPanel();
    private JPanel pnlSouth = new JPanel();

    private JMenuBar jmBar = new JMenuBar();
    private JMenu toolsMenu = new JMenu("Tools");

    DefaultTableModel tableModel = new DefaultTableModel();
    private JTable table = new JTable(tableModel);

    private JButton btnRead = new JButton("READ");
    private JButton btnExit = new JButton("Exit");

    String fileName = "Booking.ser";

    SimpleReadSerFileHandler readFromFile;

    public SimpleGuiToReadToSerializedFile() {
        super("Customer Output");
        jmBar.add(toolsMenu);
        this.setJMenuBar(jmBar);

        pnlNorth.setLayout(new FlowLayout());
        pnlSouth.setLayout(new GridLayout(1, 2));

        tableModel.addColumn("Title");
        tableModel.addColumn("FirstName");
        tableModel.addColumn("LastName");
        tableModel.addColumn("Smoker");
        tableModel.addColumn("Staff Member");
        pnlNorth.add(new JScrollPane(table));

        pnlSouth.add(btnRead);
        pnlSouth.add(btnExit);

        btnRead.addActionListener(this);
        btnExit.addActionListener(this);

        this.add(pnlNorth, BorderLayout.NORTH);
        this.add(pnlSouth, BorderLayout.SOUTH);

        readFromFile = new SimpleReadSerFileHandler();

        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRead) {
            try {
                readFromFile.openInputSerFile("Bonga.ser");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {

                ArrayList<Customer> customerList = readFromFile.readSerFile();
                DefaultTableModel tblModel = (DefaultTableModel) table.getModel();

                for (Customer customer : customerList) {
                    tblModel.addRow(new Object[] {
                            customer.getTitle(),
                            customer.getFirstName(),
                            customer.getLastName(),
                            customer.getSmoker(),
                            customer.isStaff()
                    });
                }
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == btnExit) {
            try {
                readFromFile.closeInputSerFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            System.exit(0);
        }
    }
}