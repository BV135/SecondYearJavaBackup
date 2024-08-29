package Prac9;

import javax.swing.JFrame;

public class runFileWritingGUI {

  public static void main(String[] args) {
    fileWritingGUI guiObject = new fileWritingGUI();
    guiObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    guiObject.setSize(400, 350);
    guiObject.setVisible(true);
    guiObject.setResizable(true);

  }

}
