package FileReader1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UseDamages {

  public static void main(String[] args) {
    try {
      BufferedReader reader = new BufferedReader(
          new FileReader("/Users/bongavelem/Documents/Temp/SecondYearJavaBackup-1/FileReader1/Tsunami.txt"));

      String line;

      while ((line = reader.readLine()) != null) {
        String[] parts = line.split("#");

        String date = parts[0];
        int heightf = Integer.parseInt(parts[1]);
        String location = parts[2];
        String causeOfTsunami = parts[3];

        // convert it from string to date first, and then converted date into what
        // format you want

        // Converts from string to date
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMMM d, yyyy"));
        // Formats the
        String formattedDate = localDate.format(DateTimeFormatter.ofPattern("yyyy MMMM d"));

        double heightm = heightf * 0.38048;

        Disasters disaster = new Disasters(formattedDate, heightf, heightm,
            location, causeOfTsunami);
        System.out.println(disaster.toString());
      }

      reader.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } catch (DateTimeParseException e) {
      System.out.println(e.getMessage());
    }
  }
}
