package Prac11Polymorphism;

public class Employee {
  private String name;
  private Double salary;

  public Employee(String name, Double salary) {
    this.name = name;
    this.salary = salary;
  }

  public Employee(String name) {
    this.name = name;

  }

  public String getName() {
    return name;
  }

  public Double getSalary() {
    return salary;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

}
