import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                    frame.setTitle("Login");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public Login(){
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 224, 380);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        Border blueline = BorderFactory.createLineBorder(Color.blue);
        contentPane.setBorder(blueline);

        JLabel label = new JLabel("");
        Image img=new ImageIcon(this.getClass().getResource("/Login.png")).getImage();
        label.setIcon(new ImageIcon(img));
        label.setBounds(39, 22, 128, 118);
        contentPane.add(label);

        JLabel lblUserName = new JLabel("User Name");
        lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblUserName.setBounds(10, 179, 82, 29);
        contentPane.add(lblUserName);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblPassword.setBounds(10, 219, 82, 29);
        contentPane.add(lblPassword);

        textField = new JTextField();
        textField.setBounds(102, 184, 89, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(102, 224, 89, 20);
        contentPane.add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = textField.getText();
                String pass = new String(passwordField.getPassword());
                if(user.equals("admin") && pass.equals("admin")){
                    SecondWindow scnd = new SecondWindow();
                    scnd.setVisible(true);
                    scnd.setTitle("Database manager");
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        });
        btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnLogin.setBounds(63, 259, 91, 23);
        contentPane.add(btnLogin);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnExit.setBounds(63, 290, 91, 23);
        contentPane.add(btnExit);
    }
}
