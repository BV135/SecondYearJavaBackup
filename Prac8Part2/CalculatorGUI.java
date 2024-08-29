package Prac8Part2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorGUI extends JFrame implements ActionListener {
  private JMenuBar jmBar = new JMenuBar();
  private JMenu jmOperation = new JMenu("Operations");
  private JMenu jmExit = new JMenu("Exit");

  private JPanel pnlCentre = new JPanel();
  private JPanel pnlSouth = new JPanel();

  private JLabel lblNumber1 = new JLabel("Number 1 ");
  private JTextField txtNumber1 = new JTextField();

  private JLabel lblNumber2 = new JLabel("Number 2 ");
  private JTextField txtNumber2 = new JTextField();

  private JLabel lblResult = new JLabel("Result ");
  private JTextField txtResult = new JTextField();

  private JButton btnAdd = new JButton("Add");
  private JButton btnSubtract = new JButton("Subtract");
  private JButton btnMultiply = new JButton("Multiply");
  private JButton btnDivide = new JButton("Divide");

  public CalculatorGUI() {
    super("Menu Demo");
    setLayout(new BorderLayout());
    pnlCentre.setLayout(new GridLayout(1, 5));
    pnlSouth.setLayout(new GridLayout(1, 4));

    pnlCentre.add(lblNumber1);
    pnlCentre.add(txtNumber1);

    pnlCentre.add(lblNumber2);
    pnlCentre.add(txtNumber2);

    pnlCentre.add(lblResult);
    pnlCentre.add(txtResult);
    txtResult.setEditable(false);

    pnlSouth.add(btnAdd);
    pnlSouth.add(btnSubtract);
    pnlSouth.add(btnMultiply);
    pnlSouth.add(btnDivide);

    btnAdd.addActionListener(this);
    btnSubtract.addActionListener(this);
    btnMultiply.addActionListener(this);
    btnDivide.addActionListener(this);

    btnAdd.setMnemonic(KeyEvent.VK_A);
    btnSubtract.setMnemonic(KeyEvent.VK_S);
    btnMultiply.setMnemonic(KeyEvent.VK_M);
    btnDivide.setMnemonic(KeyEvent.VK_D);

    this.setJMenuBar(jmBar);
    jmBar.add(jmOperation);
    jmBar.add(jmExit);
    jmOperation.addActionListener(this);
    jmExit.addActionListener(this);

    add(pnlCentre, BorderLayout.CENTER);
    add(pnlSouth, BorderLayout.SOUTH);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      if (e.getSource() == btnAdd) {
        int no1 = Integer.parseInt(txtNumber1.getText());
        int no2 = Integer.parseInt(txtNumber2.getText());
        txtResult.setText(String.valueOf(no1 + no2));
      } else if (e.getSource() == btnSubtract) {
        int no1 = Integer.parseInt(txtNumber1.getText());
        int no2 = Integer.parseInt(txtNumber2.getText());
        txtResult.setText(String.valueOf(no1 - no2));

      } else if (e.getSource() == btnMultiply) {
        int no1 = Integer.parseInt(txtNumber1.getText());
        int no2 = Integer.parseInt(txtNumber2.getText());
        txtResult.setText(String.valueOf(no1 * no2));
      } else if (e.getSource() == btnDivide) {
        int no1 = Integer.parseInt(txtNumber1.getText());
        int no2 = Integer.parseInt(txtNumber2.getText());
        txtResult.setText(String.valueOf(no1 / no2));
      }
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null, "Please enter valid integers.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (ArithmeticException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

      if (e.getSource() == jmExit) {
        System.exit(0);
      }
    }
  }
}
