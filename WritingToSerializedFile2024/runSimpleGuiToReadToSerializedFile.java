package WritingToSerializedFile2024;

import javax.swing.JFrame;

public class runSimpleGuiToReadToSerializedFile {
  public static void main(String[] args) {
    SimpleGuiToReadToSerializedFile guiObject = new SimpleGuiToReadToSerializedFile();
    guiObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    guiObject.setSize(700, 650);
    guiObject.setVisible(true);
    guiObject.setResizable(true);
  }

}
