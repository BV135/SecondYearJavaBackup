package FileReader1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        StringBuilder message = new StringBuilder();
        Tsunamis[] tsunamisArray = new Tsunamis[8];

        // Read data from the file and populate the array
        try (BufferedReader reader = new BufferedReader(new FileReader("FileReader1/data2006Eng.txt"))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < tsunamisArray.length) {
                String[] parts = line.split("\\*");
                String location = parts[0];
                int numNoDamage = Integer.parseInt(parts[1]);
                int numDamage = Integer.parseInt(parts[2]);
                String[] damageYearsStr = parts[3].split(";");
                int[] damageYears = new int[damageYearsStr.length];
                for (int i = 0; i < damageYearsStr.length; i++) {
                    damageYears[i] = Integer.parseInt(damageYearsStr[i]);
                }
                tsunamisArray[index] = new Tsunamis(location, numNoDamage, numDamage, damageYears);
                index++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Display the records on the screen
        for (Tsunamis tsunami : tsunamisArray) {
            System.out.println(tsunami.toString());
        }
    }

    // try {
    // File file = new File("FileReader1/data2006Eng.txt");
    // Scanner scan = new Scanner(file);
    // // String line = " ";
    // while (scan.hasNextLine()) {
    // System.out.println(scan.nextLine());

    // }
    // scan.close();

    // } catch (FileNotFoundException e) {
    // e.fillInStackTrace();

    // }

}
