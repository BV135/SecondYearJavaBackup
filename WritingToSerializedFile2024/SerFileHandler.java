package WritingToSerializedFile2024;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class SerFileHandler {
  private ObjectOutputStream outputFile;
  Customer customer;

  public void openFile() {
    try {
      outputFile = new ObjectOutputStream(new FileOutputStream("Bonga.ser"));
      JOptionPane.showMessageDialog(null, "SUCCESS! Booking ser file opened");
    }

    catch (IOException ioe) {
      System.out.println("Err opening output file");
    }
  }

  public void writeSerObject(Customer customer) throws ClassNotFoundException {
    try {
      outputFile.writeObject(customer);
      JOptionPane.showMessageDialog(null, "SUCCESS! Booking object written to ser file");
    } // end try
    catch (IOException ioe) {
      System.out.println("Err writing to file: " + ioe.toString());
    }
  }// end method

  public void closeFile() {
    try {
      outputFile.close();
      System.out.println("File closed");
      JOptionPane.showMessageDialog(null, "Booking ser file CLOSED!");

    } catch (IOException ioe) {
      System.out.println("Err closing files");
    }
  }

}
