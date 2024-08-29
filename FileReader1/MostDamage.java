package FileReader1;

public class MostDamage extends Disasters {
  private int numOfDeaths;

  public MostDamage(int numOfDeaths) {
    this.numOfDeaths = numOfDeaths;
  }

  public void setNumOfDeaths(int numOfDeaths) {
    this.numOfDeaths = numOfDeaths;
  }

  public int getNumOfDeaths() {
    return numOfDeaths;
  }

  public String toString() {
    return this.getDate() + this.getHeightf() + this.getHeightm() +
        this.getLocation() + this.getCauseOfTsunami()
        + this.getNumOfDeaths();
  }

}
