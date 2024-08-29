package WritingToSerializedFile2024;

import java.io.Serializable;

public class Customer implements Serializable {
  private String title;
  private String firstName;
  private String lastName;
  private String smoker;
  private boolean staff;

  public Customer(String title, String firstName, String lastName, String smoker, boolean staff) {
    this.title = title;
    this.firstName = firstName;
    this.lastName = lastName;
    this.smoker = smoker;
    this.staff = staff;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getSmoker() {
    return smoker;
  }

  public void setSmoker(String smoker) {
    this.smoker = smoker;
  }

  public boolean isStaff() {
    return staff;
  }

  public void setStaff(boolean staff) {
    this.staff = staff;
  }

  public String toString() {
    return "";
  }

}
