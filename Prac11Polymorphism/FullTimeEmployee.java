package Prac11Polymorphism;

public class FullTimeEmployee extends Employee implements Payable {
  private Double bonus;

  public FullTimeEmployee(String name, Double salary, Double bonus) {
    super(name, salary);
    this.bonus = bonus;

  }

  public Double getBonus() {
    return bonus;
  }

  public void setBonus(Double bonus) {
    this.bonus = bonus;
  }

  @Override
  public Double calculatePay() {
    return getSalary() + getBonus();

  }

  public String toString() {
    return "Employee Name: " + this.getName() + " " + "Emp Salary: R" + super.getSalary() + " " + "Emp Bonus: R"
        + this.getBonus() + " " + "Total Salary: R" + this.calculatePay();
  }

}
