package ;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ProductArrayListManipulator pam = new ProductArrayListManipulator();
    // number 1
    ArrayList<Product> products = pam.createProductArrayList();
    System.out.println(products.toString());

    // number2
    pam.printProductArrayList(products);

    // number 3
    String idInput = JOptionPane.showInputDialog("Enter the ID of the product:");

    int id = Integer.parseInt(idInput);
    int i = pam.findProductByID(products, id);
    if (i != -1) {
      Product product = products.get(i);
      JOptionPane.showMessageDialog(null, product);
    } else {
      JOptionPane.showMessageDialog(null, "Product not found.");
    }

    // number 4
    // remove product also uses string input from number 3

    // int id = Integer.parseInt(idInput);
    // int i = pam.removeProductByID(products, id);
    // if (i == id) {
    // JOptionPane.showConfirmDialog(null, products.toString());
    // }

    // Number 5

    pam.sortProductsByPrice(products);
    JOptionPane.showMessageDialog(null, products.toString());

    // Number 6

    pam.sortProductsByName(products);
    JOptionPane.showMessageDialog(null, products.toString());

  }
}
