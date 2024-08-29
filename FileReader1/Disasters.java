package FileReader1;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Disasters {
  private String date;
  private int heightf;
  private double heightm;
  private String location;
  private String causeOfTsunami;

  public Disasters() {
  }

  public Disasters(String date, int heightf, double heightm, String location, String causeOfTsunami) {
    this.date = date;
    this.heightf = heightf;
    this.heightm = heightm;
    this.location = location;
    this.causeOfTsunami = causeOfTsunami;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setHeightf(int heightf) {
    this.heightf = heightf;
  }

  public void setHeightm(int heightm) {
    this.heightm = heightm;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setCauseOfTsunami(String causeOfTsunami) {
    this.causeOfTsunami = causeOfTsunami;
  }

  public String getDate() {
    return date;
  }

  public int getHeightf() {
    return heightf;
  }

  public String getHeightm() {
    heightm = heightf * 0.38048;
    DecimalFormat df = new DecimalFormat("#.##");
    return df.format(heightm);
  }

  public String getLocation() {
    return location;
  }

  public String getCauseOfTsunami() {
    return causeOfTsunami;
  }

  public String toString() {
    return "Cause: " + this.getCauseOfTsunami();

    // return "\nDate: " + this.getDate() +
    // "\nHeight in feet:" + this.getHeightf() +
    // "\nHeight in meters: " + getHeightm() +
    // "\nLocation: " + this.getLocation() +
    // "\nCause of Tsunami: " + this.getCauseOfTsunami() + "\n ";

  }

}
