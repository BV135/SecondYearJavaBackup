package Prac9;

public class Employee {
  private String title;
  private String firstName;
  private String lastName;
  private String empType;

  public Employee() {

  }

  public Employee(String title, String firstName, String lastName, String empType) {
    this.title = title;
    this.firstName = firstName;
    this.lastName = lastName;
    this.empType = empType;
  }

  public String getTitle() {
    return title;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmpType() {
    return empType;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmployee(String empType) {
    this.empType = empType;
  }

  public String toString() {
    return this.getTitle() + this.getFirstName() + this.getLastName() + this.getEmpType();
  }

}
