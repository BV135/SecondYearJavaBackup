package Prac8Part1;

import javax.swing.JFrame;

public class runGUI {

  public static void main(String args[]) {
    GUI objectGui = new GUI();
    objectGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    objectGui.setSize(400, 450);
    objectGui.setResizable(true);
    objectGui.setVisible(true);

  }

}
