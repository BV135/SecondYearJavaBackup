package Prac7;

import javax.swing.JFrame;

public class runUniversityStaff {

  public static void main(String[] args) {
    UniversityStaff guiObject = new UniversityStaff();
    guiObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    guiObject.setSize(550, 350);
    guiObject.setResizable(true);
    guiObject.setVisible(true);

  }

}
