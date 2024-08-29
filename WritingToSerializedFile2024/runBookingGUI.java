package WritingToSerializedFile2024;

import javax.swing.JFrame;

public class runBookingGUI {
  public static void main(String[] args) {
    BookingGUI guiObject = new BookingGUI();
    guiObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    guiObject.setSize(500, 450);
    guiObject.setVisible(true);
    guiObject.setResizable(true);

  }

}
