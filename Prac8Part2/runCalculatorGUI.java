package Prac8Part2;

import javax.swing.JFrame;

public class runCalculatorGUI {

  public static void main(String[] args) {
    CalculatorGUI guiObject = new CalculatorGUI();
    guiObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    guiObject.setSize(350, 150);
    guiObject.setVisible(true);
    guiObject.setResizable(true);
  }

}
