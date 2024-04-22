package Prac6;

import javax.swing.JFrame;

public class RunGUI {

  public static void main(String[] args) {
    ComboAndMenuSelectionGUI guiObject = new ComboAndMenuSelectionGUI();

    guiObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    guiObject.setResizable(true);
    guiObject.setVisible(true);
    guiObject.setSize(450, 400);

  }

}
