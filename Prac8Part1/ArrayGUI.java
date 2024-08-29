package Prac8Part1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ArrayGUI extends JFrame {
  private String[] array = new String[10];
  private JTextField indexField;
  private JTextField valueField;

  public ArrayGUI() {
    this.setTitle("Array GUI");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(300, 150);
    this.setLocationRelativeTo(null);

    initializeArray();

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2));

    JLabel indexLabel = new JLabel("Enter index:");
    indexField = new JTextField();
    JLabel valueLabel = new JLabel("Array element value:");
    valueField = new JTextField();
    valueField.setEditable(false);
    JButton showButton = new JButton("Show Element");
    showButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        try {
          int index = Integer.parseInt(indexField.getText());
          String element = getElement(index);
          valueField.setText(element);
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(null, "Please enter a valid index (0-9).", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException ex) {
          JOptionPane.showMessageDialog(null, "Index is out of bounds.", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }

    });

    panel.add(indexLabel);
    panel.add(indexField);
    panel.add(valueLabel);
    panel.add(valueField);
    panel.add(showButton);

    this.add(panel);
    setVisible(true);
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

  public static void main(String[] args) {
    new ArrayGUI();
  }

}
