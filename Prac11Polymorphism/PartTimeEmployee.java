package Prac11Polymorphism;

public class PartTimeEmployee extends Employee implements Payable {
  private Double hoursWorked;
  private Double hourlyRate;

  public PartTimeEmployee(String name, Double hoursWorked, Double hourlyRate) {
    super(name);
    this.hoursWorked = hoursWorked;
    this.hourlyRate = hourlyRate;

  }

  public Double getHoursWorked() {
    return hoursWorked;
  }

  public Double getHourlyRate() {
    return hourlyRate;
  }

  public void setHoursWorked(Double hoursWorked) {
    this.hoursWorked = hoursWorked;
  }

  public void setHourlyRate(Double hourlyRate) {
    this.hourlyRate = hourlyRate;
  }

  // public void calculatePay(int hoursWorked, Double hourlyRate) {
  // }

  @Override
  public Double calculatePay() {
    return getHoursWorked() * getHourlyRate();

  }

  public String toString() {
    return "Employee Name: " + super.getName() + " " + "Hours Worked: " + this.getHoursWorked() + " " + "Hourly rate: R"
        + this.getHourlyRate() + " " + "Total Salary: R" + this.calculatePay();
  }

}
