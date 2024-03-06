package Prac4;

import java.util.ArrayList;

import java.util.Collections;

import javax.swing.JOptionPane;

public class ProductArrayListManipulator {

  public ArrayList<Product> createProductArrayList() {
    ArrayList<Product> productList = new ArrayList<>();
    productList.add(new Product("Playstation 5", 234, (double) 14000));
    productList.add(new Product("Xbox Series X", 351, (double) 12500));
    productList.add(new Product("Nintendo Wii", 555, (double) 8300));
    productList.add(new Product("Apple Vision Pro", 123, (double) 66000));

    return productList;

  }

  public void printProductArrayList(ArrayList<Product> ProductArrayList) {
    for (Product product : ProductArrayList) {
      JOptionPane.showMessageDialog(null, product.toString());
    }

  }

  public int findProductByID(ArrayList<Product> ProductArrayList, int id) {
    for (int i = 0; i < ProductArrayList.size(); i++) {
      Product product = ProductArrayList.get(i);
      if (product.getId() == id) {
        return i;
      }
    }
    return -1;
  }

  public int removeProductByID(ArrayList<Product> ProductArrayList, int id) {
    for (int i = 0; i < ProductArrayList.size(); i++) {
      Product product = ProductArrayList.get(i);
      if (product.getId() == id) {
        ProductArrayList.remove(i);

      }

    }
    return id;

  }

  public void sortProductsByPrice(ArrayList<Product> ProductArrayList) {
    Collections.sort(ProductArrayList, new Product());

  }

  public void sortProductsByName(ArrayList<Product> ProductArrayList) {
    Collections.sort(ProductArrayList, Collections.reverseOrder());

  }

}
