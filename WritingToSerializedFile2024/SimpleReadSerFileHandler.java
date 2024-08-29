package WritingToSerializedFile2024;

import java.util.ArrayList;

/**
 * 
 */
import java.io.*;

public class SimpleReadSerFileHandler {

  private ObjectInputStream ois;
  String fileName = "Bonga.ser";

  public void openInputSerFile(String fileName) throws IOException {
    ois = new ObjectInputStream(new FileInputStream(fileName));
  }

  public ArrayList<Customer> readSerFile() throws IOException,
      ClassNotFoundException {
    ArrayList<Customer> customerList = new ArrayList<>();

    try {

      while (true) {
        Customer customer = (Customer) ois.readObject();

        customerList.add(customer);
      }
    } catch (EOFException e) {
      System.out.println(e.getMessage());
    }

    return customerList;
  }

  public void closeInputSerFile() throws IOException {
    if (ois != null) {
      ois.close();
    }
  }
}
