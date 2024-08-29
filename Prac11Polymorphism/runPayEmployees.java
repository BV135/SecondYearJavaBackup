package Prac11Polymorphism;

public class runPayEmployees {

  public static void main(String[] args) {
    Payable[] employees = new Payable[3];
    employees[0] = new FullTimeEmployee("Bonga", (double) 55000, (double) 25000);
    employees[1] = new PartTimeEmployee("Randel", (double) 9, (double) 3500);
    employees[2] = new PartTimeEmployee("Luka", (double) 40, (double) 350);

    for (Payable employee : employees) {
      System.out.println(employee.toString());
    }

  }

}
