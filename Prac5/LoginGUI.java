import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginGUI extends JFrame implements ActionListener {
  private JFrame mainFrame;
  private JPanel panelNorth;
  private JPanel panelWest;
  private JPanel panelEast;
  private JPanel panelSouth;

  private JMenuBar menuBar;
  private JMenu fileMenu;
  private JMenuItem loginMenu;
  private JMenuItem clearMenu;
  private JMenuItem exitMenu;

  private JLabel lblUsername;
  private JLabel lblPassword;

  private JTextField txtUsername;
  private JTextField txtPassword;

  private JButton btnLogin;
  private JButton btnClear;
  private JButton btnExit;
  private Font f1, f2;
  User user;

  public LoginGUI() {
    mainFrame = new JFrame("User Authentication");
    menuBar = new JMenuBar();
    fileMenu = new JMenu("File");
    loginMenu = new JMenuItem("Login");
    clearMenu = new JMenuItem("Clear");
    exitMenu = new JMenuItem("Exit");

    panelNorth = new JPanel();
    panelWest = new JPanel();
    panelEast = new JPanel();
    panelSouth = new JPanel();

    lblUsername = new JLabel("Username: ");
    txtUsername = new JTextField();
    lblPassword = new JLabel("Password: ");
    txtPassword = new JTextField();

    btnLogin = new JButton("Login");
    btnClear = new JButton("Clear");
    btnExit = new JButton("Exit");

    f1 = new Font("Italic", Font.ITALIC, 20);
    f2 = new Font("Plain", Font.BOLD, 22);

    mainFrame.setLayout(new BorderLayout());
    mainFrame.setSize(300, 200);
    panelNorth.setLayout(new GridLayout(1, 1));
    panelWest.setLayout(new GridLayout(2, 1));
    panelEast.setLayout(new GridLayout(2, 1));
    panelSouth.setLayout(new GridLayout(1, 3));
    mainFrame.add(panelNorth);
    mainFrame.add(panelWest);
    mainFrame.add(panelEast);
    mainFrame.add(panelSouth);

    panelNorth.add(menuBar);
    menuBar.add(fileMenu);
    fileMenu.add(loginMenu);
    fileMenu.add(clearMenu);
    fileMenu.add(exitMenu);

    panelWest.add(lblUsername);
    txtUsername.setPreferredSize(new Dimension(150, 30));
    panelEast.add(txtUsername);
    panelWest.add(lblPassword);
    panelEast.add(txtPassword);
    txtPassword.setPreferredSize(new Dimension(150, 30));
    lblUsername.setHorizontalAlignment(JLabel.LEFT);
    lblUsername.setFont(f1);

    lblPassword.setHorizontalAlignment(JLabel.LEFT);
    lblPassword.setFont(f1);

    panelSouth.add(btnLogin);
    panelSouth.add(btnClear);
    panelSouth.add(btnExit);
    btnLogin.setFont(f2);
    btnClear.setFont(f2);
    btnExit.setFont(f2);

    fileMenu.addActionListener(this);
    loginMenu.addActionListener(this);
    clearMenu.addActionListener(this);
    exitMenu.addActionListener(this);

    btnLogin.addActionListener((ActionListener) this);
    btnClear.addActionListener((ActionListener) this);
    btnExit.addActionListener((ActionListener) this);
    btnLogin.setForeground(Color.GREEN);

    btnLogin.setBackground(Color.GREEN);
    btnClear.setBackground(Color.BLUE);
    btnExit.setBackground(Color.RED);
    mainFrame.setVisible(true);
    mainFrame.add(panelNorth, BorderLayout.NORTH);
    mainFrame.add(panelWest, BorderLayout.WEST);
    mainFrame.add(panelEast, BorderLayout.EAST);
    mainFrame.add(panelSouth, BorderLayout.SOUTH);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    mainFrame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
      }
    });

  }

  private void clearData() {

    txtUsername.setText(" ");
    txtPassword.setText(" ");

    JOptionPane.showMessageDialog(null, "Data Cleared.");
    txtUsername.hasFocus();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnLogin) {
      String Username = txtUsername.getText();
      String Password = txtPassword.getText();

      User u = new User(Username, Password);
      if (u.isValidLogin(Username, Password)) {
        JOptionPane.showMessageDialog(this, "Welcome " + u.getUsername() + "\nYou have logged in.");
      } else {
        JOptionPane.showMessageDialog(this, "Invalid username or password.");
        txtUsername.requestFocus();
      }
    } else if (e.getSource() == btnClear) {
      clearData();
    } else if (e.getSource() == btnExit) {
      System.exit(0);

    }

    if (e.getSource() == loginMenu) {
      String Username = txtUsername.getText();
      String Password = txtPassword.getText();

      User u = new User(Username, Password);
      if (u.isValidLogin(Username, Password)) {
        JOptionPane.showMessageDialog(this, "Welcome " + u.getUsername() + "\nYou have logged in.");
      } else {
        JOptionPane.showMessageDialog(this, "Invalid username or password.");
        txtUsername.requestFocus();
      }
    } else if (e.getSource() == clearMenu) {
      clearData();
    } else if (e.getSource() == exitMenu) {
      System.exit(0);

    }
  }
}