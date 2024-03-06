package Prac4;

import java.util.Comparator;

public class Product implements Comparator<Product>, Comparable<Product> {
  private String Name;
  private int id;
  private Double Price;

  public Product() {

  }

  public Product(String name, int id, Double price) {
    this.Name = name;
    this.id = id;
    this.Price = price;

  }

  public void setName(String name) {
    this.Name = name;

  }

  public void setId(int id) {
    this.id = id;

  }

  public void setPrice(Double price) {
    this.Price = price;

  }

  public String getName() {
    return Name;
  }

  public int getId() {
    return id;
  }

  public Double getPrice() {
    return Price;
  }

  public String toString() {
    return "\nProduct name: " + this.getName() + " " + "Product id: " + this.getId() + " " + "price: R"
        + this.getPrice();

  }

  @Override
  public int compare(Product o1, Product o2) {
    return (int) (o2.getPrice() - o1.getPrice());

  }

  @Override
  public int compareTo(Product o) {
    return (this.getName().compareTo(o.getName()));
  }

}
