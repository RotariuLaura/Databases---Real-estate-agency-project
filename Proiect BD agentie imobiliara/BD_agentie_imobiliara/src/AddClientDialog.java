import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClientDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField idTextField;
    private JTextField numeTextField;
    private JTextField prenumeTextField;
    private JTextField tipClientTextField;
    private JTextField nrTelefonTextField;
    private JTextField emailTextField;
    private SqlConnection sqlConnection;
    private SecondWindow secondWindow;
    public static void main(String[] args){
        try{
            AddClientDialog dialog = new AddClientDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public AddClientDialog(SecondWindow theSecondWindow, SqlConnection theSqlConnection)
    {
        this();
        secondWindow = theSecondWindow;
        sqlConnection = theSqlConnection;
    }
    public AddClientDialog(){
        setTitle("Insert data");
        setBounds(100, 100, 347, 339);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        JLabel lblId = new JLabel("Nr client");
        lblId.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblId.setBounds(28, 23, 66, 28);
        contentPanel.add(lblId);

        JLabel lblNume = new JLabel("Nume");
        lblNume.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNume.setBounds(28, 62, 66, 28);
        contentPanel.add(lblNume);

        JLabel lblPrenume = new JLabel("Prenume");
        lblPrenume.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblPrenume.setBounds(28, 101, 66, 28);
        contentPanel.add(lblPrenume);

        JLabel lblTipClient = new JLabel("Tip client");
        lblTipClient.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblTipClient.setBounds(28, 140, 66, 28);
        contentPanel.add(lblTipClient);

        JLabel lblNrTelefon = new JLabel("Nr telefon");
        lblNrTelefon.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNrTelefon.setBounds(28, 182, 66, 28);
        contentPanel.add(lblNrTelefon);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblEmail.setBounds(28, 218, 66, 28);
        contentPanel.add(lblEmail);

        idTextField = new JTextField();
        idTextField.setBounds(115, 23, 200, 28);
        contentPanel.add(idTextField);
        idTextField.setColumns(10);

        numeTextField = new JTextField();
        numeTextField.setBounds(115, 62, 200, 28);
        contentPanel.add(numeTextField);
        numeTextField.setColumns(10);

        prenumeTextField = new JTextField();
        prenumeTextField.setBounds(115, 101, 200, 28);
        contentPanel.add(prenumeTextField);
        prenumeTextField.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "persoana fizica", "firma"}));
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        comboBox.setBounds(115, 140, 200, 28);
        contentPanel.add(comboBox);

        nrTelefonTextField = new JTextField();
        nrTelefonTextField.setBounds(115, 182, 200, 28);
        contentPanel.add(nrTelefonTextField);
        nrTelefonTextField.setColumns(10);

        emailTextField = new JTextField();
        emailTextField.setBounds(115, 218, 200, 28);
        contentPanel.add(emailTextField);
        emailTextField.setColumns(10);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        JButton okButton = new JButton("Save");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idtxt = idTextField.getText();
                int id = Integer.parseInt(idtxt);
                String nume = numeTextField.getText();
                String prenume = prenumeTextField.getText();
                String tip_persoana = (String) comboBox.getSelectedItem();
                String nr_telefon = nrTelefonTextField.getText();
                String email = emailTextField.getText();

                Client tempClient = new Client(id, nume, prenume, tip_persoana, nr_telefon, email);
                int ok=0;

                if (ok==0) {
                    try {
                        sqlConnection.addClient(tempClient);
                        setVisible(true);
                        dispose();
                        JOptionPane.showMessageDialog(secondWindow, "Client added", "Client added", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(secondWindow, "Error saving client", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        okButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                dispose();
            }
        });
        cancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }
}
