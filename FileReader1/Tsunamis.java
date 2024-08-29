package FileReader1;

import java.util.Arrays;

public class Tsunamis {
  private String cityStruck;
  private int noDamage;
  private int damage;
  private int[] years;

  public Tsunamis(String cityStruck, int noDamage, int damage, int[] years) {
    this.cityStruck = cityStruck;
    this.noDamage = noDamage;
    this.damage = damage;
    this.years = years;

  }

  public void setCityStruck(String cityStruck) {
    this.cityStruck = cityStruck;
  }

  public void setNoDamage(int noDamage) {
    this.noDamage = noDamage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public void setYears(int[] years) {
    this.years = years;
  }

  public String getCityStruck() {
    return cityStruck;
  }

  public int getNoDamage() {
    return noDamage;
  }

  public int getDamage() {
    return damage;
  }

  public int[] getYears() {
    return years;
  }

  public String toString() {
    return "Location: " + this.getCityStruck() +
        "\n No damage: " + this.getNoDamage() +
        "\n Damage: " + this.getDamage() +
        "\n Years: " + Arrays.toString(years);

  }

}
