import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneAppGUI extends JFrame implements ActionListener {

  private JMenuBar menuBar;
  private JMenu fileMenu;
  private JMenuItem clearMenu;
  private JMenuItem exitMenu;

  private JPanel pnlTop;
  private JPanel pnlBottom;
  private JTextField textField;
  private JButton[] buttons;
  private JButton btnClear;
  private JButton btnCall;
  private boolean isCalling = false;

  Font f1;
  private Font f2;

  public PhoneAppGUI() {
    super("Phone App");
    menuBar = new JMenuBar();
    fileMenu = new JMenu("File");
    clearMenu = new JMenuItem("Clear");
    exitMenu = new JMenuItem("Exit");

    pnlTop = new JPanel();
    pnlBottom = new JPanel();
    f1 = new Font("Italic", Font.ITALIC, 20);
    f2 = new Font("Plain", Font.BOLD, 18);

    textField = new JTextField();
    textField.setPreferredSize(new Dimension(350, 50));
    textField.setFont(f1);
    textField.setEditable(false);

    buttons = new JButton[10];

    for (int i = 0; i < 10; i++) {
      buttons[i] = new JButton(String.valueOf(i));
      buttons[i].addActionListener(this);
      buttons[i].setFont(f2);
      buttons[i].setFocusable(false);

    }
    btnCall = new JButton("Call");
    btnClear = new JButton("Clear");

    pnlTop.add(textField);
    pnlBottom.setBounds(50, 100, 300, 300);
    pnlBottom.setLayout(new GridLayout(4, 3, 10, 10));
    pnlBottom.add(buttons[1]);
    pnlBottom.add(buttons[2]);
    pnlBottom.add(buttons[3]);

    pnlBottom.add(buttons[4]);
    pnlBottom.add(buttons[5]);
    pnlBottom.add(buttons[6]);

    pnlBottom.add(buttons[7]);
    pnlBottom.add(buttons[8]);
    pnlBottom.add(buttons[9]);

    pnlBottom.add(btnClear);
    pnlBottom.add(buttons[0]);
    pnlBottom.add(btnCall);

    menuBar.add(fileMenu);
    fileMenu.add(clearMenu);
    fileMenu.add(exitMenu);
    this.setJMenuBar(menuBar);
    add(pnlTop, BorderLayout.NORTH);
    add(pnlBottom, BorderLayout.SOUTH);
    btnCall.addActionListener(this);
    btnClear.addActionListener(this);

    fileMenu.addActionListener(this);
    clearMenu.addActionListener(this);
    exitMenu.addActionListener(this);
  }

  private void clearData() {
    textField.setText(" ");

    JOptionPane.showMessageDialog(null, "Data Cleared.");
    textField.requestFocus();
    ;

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnCall) {
      if (!isCalling) {
        call(textField.getText());
        isCalling = true;
        btnCall.setText("HANG UP");
      } else {
        hangUp();
        isCalling = false;
        btnCall.setText("CALL");
        textField.setText("");
      }
    } else {
      for (int i = 0; i < 10; i++) {
        if (e.getSource() == buttons[i]) {
          textField.setText(textField.getText().concat(String.valueOf(i)));
          break;
        } else if (e.getSource() == btnClear) {
          clearData();
        } else if (e.getSource() == clearMenu) {
          clearData();
        } else if (e.getSource() == exitMenu) {
          System.exit(0);
        }
      }
    }
  }

  private void call(String number) {
    JOptionPane.showMessageDialog(null, "Calling " + textField.getText() + "...");
  }

  private void hangUp() {
    JOptionPane.showMessageDialog(null, "Call ended.");
  }
}