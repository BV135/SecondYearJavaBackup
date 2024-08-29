package Prac9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Prac9FileHandler {
  FileWriter fw;
  BufferedWriter bw;

  private String strOutput;

  public void openFileSimple() throws IOException {
    fw = new FileWriter("OutputEmployees.txt", true);
    bw = new BufferedWriter(fw);
  }

  public void openFile() {

    try {
      fw = new FileWriter("OutputEmployees.txt", true);
      bw = new BufferedWriter(fw);
      System.out.println("File is now open for writing");

    } catch (IOException ie) {

      String strError = ie.toString();
      JOptionPane.showMessageDialog(null, strError);
      System.out.println("My Error " + ie.toString());
    }
  }

  public void processFile(String strOutput) {
    try {
      bw.write(strOutput);
    } catch (IOException ie) {

      String strError = ie.toString();
      JOptionPane.showMessageDialog(null, strError);
      System.out.println("My Error " + ie.toString());
    }
  }

  public void closeFile() {
    try {
      bw.close();
      System.out.println("File is now closed");
    } catch (IOException ie) {

      String strError = ie.toString();
      JOptionPane.showMessageDialog(null, strError);
      System.out.println("My Error " + ie.toString());
    }
  }

}
