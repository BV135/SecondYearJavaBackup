package FileReader1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UseTsunamis extends JFrame {
  private JPanel pnlCentre;
  private DefaultTableModel tableModel;
  private JTable table;

  public UseTsunamis() {
    super("Tsunami");
    pnlCentre = new JPanel();
    tableModel = new DefaultTableModel();
    table = new JTable(tableModel);

    setLayout(new BorderLayout());
    pnlCentre.setLayout(new GridLayout());

    tableModel.addColumn("Location");
    tableModel.addColumn("No Damage");
    tableModel.addColumn("Damage");
    tableModel.addColumn("Years");
    pnlCentre.add(new JScrollPane(table));

  }

  public static void main(String[] args) {
    Tsunamis[] tsunamisArray = new Tsunamis[8];

    try {
      Scanner scanner = new Scanner(
          new File("/Users/bongavelem/Documents/Temp/SecondYearJavaBackup-1/FileReader1/data2006Eng.txt"));
      int index = 0;
      while (scanner.hasNextLine() && index < tsunamisArray.length) {
        String line = scanner.nextLine();
        String[] parts = line.split("\\*");
        String location = parts[0];
        int NoDamage = Integer.parseInt(parts[1]);
        int damage = Integer.parseInt(parts[2]);
        String[] YearsStr = parts[3].split(";");
        int[] Years = new int[YearsStr.length];
        for (int i = 0; i < YearsStr.length; i++) {
          Years[i] = Integer.parseInt(YearsStr[i]);
        }
        tsunamisArray[index] = new Tsunamis(location, NoDamage, damage, Years);
        index++;
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.err.println("File not found: " + e.getMessage());
      return;
    }

    for (Tsunamis tsunami : tsunamisArray) {
      System.out.println(tsunami.toString());

    }
  }

}
