package Prac8Part1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
  private JPanel pnlWest = new JPanel();
  private JPanel pnlEast = new JPanel();
  private JPanel pnlSouth = new JPanel();

  private JLabel lblInput = new JLabel("Input Text: ");
  private String[] array = new String[10];
  private JLabel lblOutput = new JLabel("Output : ");

  private JTextField txtInput = new JTextField(10);
  private JTextField txtOutput = new JTextField(10);

  private JButton btnShow = new JButton("Show");
  private JButton btnExit = new JButton("Exit");

  public GUI() {
    super("Arrays");
    setLayout(new FlowLayout());
    pnlWest.setLayout(new GridLayout(2, 1));
    pnlEast.setLayout(new GridLayout(2, 1));
    pnlSouth.setLayout(new GridLayout(1, 2));

    pnlWest.add(lblInput);
    pnlWest.add(txtInput);

    pnlEast.add(lblOutput);
    pnlEast.add(txtOutput);

    pnlSouth.add(btnShow);
    pnlSouth.add(btnExit);

    btnShow.addActionListener(this);
    btnExit.addActionListener(this);

    add(pnlWest, BorderLayout.WEST);
    add(pnlEast, BorderLayout.EAST);
    add(pnlSouth, BorderLayout.SOUTH);
    initializeArray();

  }

  private void initializeArray() {
    for (int i = 0; i < array.length; i++) {
      array[0] = "Tracy ";
      array[1] = "Bonga";
      array[2] = "Barcalona";
      array[3] = "Liverpool";
      array[4] = "Real Madrid";
      array[5] = "Arsenal";
      array[6] = "Mbappe";
      array[7] = "Modric";
      array[8] = "Jude";
      array[9] = "Sancho";
    }
  }

  private String getElement(int index) {
    return array[index];
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnShow) {
      try {
        int index = Integer.parseInt(txtInput.getText());
        String element = getElement(index);
        txtOutput.setText(element);
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Please enter a valid index (0-9).", "Error", JOptionPane.ERROR_MESSAGE);
      } catch (ArrayIndexOutOfBoundsException ex) {
        JOptionPane.showMessageDialog(null, "Index is out of bounds.", "Error", JOptionPane.ERROR_MESSAGE);
      }

    } else if (e.getSource() == btnExit) {
      System.exit(0);

    }

  }

}
