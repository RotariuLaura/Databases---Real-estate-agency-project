import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private JFrame frame;
    public static void main(String [] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainWindow window = new MainWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public MainWindow(){
            frame = new JFrame();
            frame.setResizable(false);
            frame.setBackground(Color.WHITE);
            frame.getContentPane().setBackground(Color.WHITE);
            frame.setBounds(100, 100, 449, 288);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Database Manager");

            JMenuBar menuBar = new JMenuBar();
            frame.setJMenuBar(menuBar);

            JMenu mnMenu = new JMenu("File");
            mnMenu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            menuBar.add(mnMenu);
            Border blueline = BorderFactory.createLineBorder(Color.blue);
            mnMenu.setBorder(blueline);

            JMenuItem mntmLogin = new JMenuItem("Login");
            mntmLogin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
            mntmLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    Login lgin = new Login();
                    lgin.setVisible(true);
                    lgin.setTitle("Login");
                    frame.setVisible(false);
                }
            });
            mnMenu.add(mntmLogin);

            JMenuItem mntmExit = new JMenuItem("Exit");
            mntmExit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
            mntmExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            mnMenu.add(mntmExit);
            frame.getContentPane().setLayout(null);

            JLabel lbl = new JLabel("In order to access the database you have to log in!");
            lbl.setFont(new Font("Times New Roman", Font.BOLD, 20));
            lbl.setBounds(10, 130, 500, 50);
            frame.getContentPane().add(lbl);

            JLabel newLbl = new JLabel("");
            Image img = new ImageIcon(this.getClass().getResource("/start.png")).getImage();
            newLbl.setIcon(new ImageIcon(img));
            newLbl.setBounds(156, 11, 135, 153);
            frame.getContentPane().add(newLbl);
    }
}
