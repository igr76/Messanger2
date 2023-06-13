package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientWindow extends JFrame implements ActionListener {
    private static final String IP_ADRES = "89.222.249.131";
    public static final int PORT = 8189;
    public static final int WIGHT =600;
    public static final int HEIGHT = 400;
    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               new ClientWindow();
           }
       });
    }
    private final JTextArea log = new JTextArea();
    private final JTextField fieldNickname = new JTextField("igr");
    private final JTextField fieldInput = new JTextField();

    public ClientWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIGHT,HEIGHT);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        log.setEditable(false);
        log.setLineWrap(true);
        fieldInput.addActionListener(this);
        add(log, BorderLayout.CENTER);
        add(fieldInput, BorderLayout.SOUTH);
        add(fieldNickname, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

