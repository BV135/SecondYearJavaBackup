import javax.swing.JFrame;

public class runPhoneApp {

  public static void main(String[] args) {
    PhoneAppGUI guiObject = new PhoneAppGUI();

    guiObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    guiObject.setSize(350, 400);
    guiObject.setResizable(true);
    guiObject.setVisible(true);

  }
}
