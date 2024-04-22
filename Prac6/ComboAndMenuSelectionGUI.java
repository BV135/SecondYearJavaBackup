package Prac6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ComboAndMenuSelectionGUI extends JFrame implements ItemListener {
  private JMenuBar jmMBar;
  private JMenu fileMenu, ToolsMenu;
  private JMenuItem exitMenu;

  private JPanel pnlTop;
  private JPanel pnlBottom;

  @SuppressWarnings("rawtypes")
  private JComboBox cboTeams;
  private JLabel lblTeam, lblSelect;
  Font ft2;

  @SuppressWarnings("unchecked")
  public ComboAndMenuSelectionGUI() {
    super("Combo Selection");
    jmMBar = new JMenuBar();
    fileMenu = new JMenu("File");
    ToolsMenu = new JMenu("Tools");
    exitMenu = new JMenuItem("EXIT");

    pnlTop = new JPanel();
    pnlBottom = new JPanel();
    ft2 = new Font("Plain", Font.ITALIC, 18);

    lblSelect = new JLabel("Select your favourite Team: ");
    cboTeams = new JComboBox<>();
    cboTeams.addItem("None");
    cboTeams.addItem("Manchester United");
    cboTeams.addItem("Manchester City");
    cboTeams.addItem("Liverpool");
    cboTeams.addItem("Arsenal");

    lblTeam = new JLabel(" ");
    cboTeams.setSelectedIndex(0);
    cboTeams.addItemListener(this);

    setLayout(new BorderLayout());
    pnlTop.add(lblSelect);
    pnlTop.add(cboTeams);
    lblTeam.setFont(ft2);
    lblTeam.setForeground(Color.red);

    pnlBottom.setLayout(new FlowLayout());
    pnlBottom.add(lblTeam, JLabel.CENTER);

    jmMBar.add(fileMenu);
    jmMBar.add(ToolsMenu);
    fileMenu.add(exitMenu);
    this.setJMenuBar(jmMBar);
    add(pnlTop, BorderLayout.NORTH);
    add(pnlBottom, BorderLayout.SOUTH);

    exitMenu.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitMenu) {
          System.exit(0);
        }
      }
    });

  }

  public void itemStateChanged(ItemEvent e) {
    // Used to change the state of a combobox
    if (e.getStateChange() == ItemEvent.SELECTED) {
      lblTeam.setText((String) cboTeams.getSelectedItem());
    }
  }

}