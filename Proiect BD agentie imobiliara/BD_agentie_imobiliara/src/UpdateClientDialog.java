import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateClientDialog extends JDialog {

        private static final long serialVersionUID = 1L;
        private final JPanel contentPanel = new JPanel();
        private JTextField numeTextField;
        private JTextField prenumeTextField;
        private JTextField nrTelefonTextField;
        private JTextField emailTextField;
        private SqlConnection sqlconnection;
        private SecondWindow secondwindow;
        private Client previousClient = null;
        public UpdateClientDialog(SecondWindow theSecondWindow, SqlConnection theSqlConnection, Client thePreviousClient)
        {
            secondwindow = theSecondWindow;
            sqlconnection = theSqlConnection;
            previousClient = thePreviousClient;
            int i = previousClient.getId();

            String idtext = Integer.toString(i);
            setTitle("Update Client");
            setBounds(100, 100, 347, 339);
            getContentPane().setLayout(new BorderLayout());
            contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            getContentPane().add(contentPanel, BorderLayout.CENTER);
            contentPanel.setLayout(null);

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
            lblTipClient.setBounds(28, 179, 66, 28);
            contentPanel.add(lblTipClient);

            JLabel lblNrTelefon = new JLabel("Nr telefon");
            lblNrTelefon.setFont(new Font("Times New Roman", Font.PLAIN, 12));
            lblNrTelefon.setBounds(28, 140, 66, 28);
            contentPanel.add(lblNrTelefon);

            JLabel lblEmail = new JLabel("Email");
            lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
            lblEmail.setBounds(28, 218, 66, 28);
            contentPanel.add(lblEmail);

            numeTextField = new JTextField();
            numeTextField.setBounds(115, 62, 200, 28);
            contentPanel.add(numeTextField);
            numeTextField.setColumns(10);

            prenumeTextField = new JTextField();
            prenumeTextField.setBounds(115, 101, 200, 28);
            contentPanel.add(prenumeTextField);
            prenumeTextField.setColumns(10);

            nrTelefonTextField = new JTextField();
            nrTelefonTextField.setBounds(115, 140, 200, 28);
            contentPanel.add(nrTelefonTextField);
            nrTelefonTextField.setColumns(10);

            emailTextField = new JTextField();
            emailTextField.setBounds(115, 218, 200, 28);
            contentPanel.add(emailTextField);
            emailTextField.setColumns(10);
            {
                numeTextField.setText(previousClient.getNume());
                prenumeTextField.setText(previousClient.getPrenume());
                nrTelefonTextField.setText(previousClient.getNr_telefon());
                emailTextField.setText(previousClient.getEmail());

                JComboBox comboBox = new JComboBox();
                comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "persoana fizica", "firma"}));
                comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                comboBox.setBounds(115, 179, 200, 28);
                contentPanel.add(comboBox);
                comboBox.setSelectedItem(previousClient.getTip_client());

                JPanel buttonPane = new JPanel();
                buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
                getContentPane().add(buttonPane, BorderLayout.SOUTH);
                {
                    JButton okButton = new JButton("Save");
                    okButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            String nume = numeTextField.getText();
                            String prenume = prenumeTextField.getText();
                            String tipClient = comboBox.getSelectedItem().toString();
                            String nr_telefon = nrTelefonTextField.getText();
                            String email = emailTextField.getText();

                            Client tempClient = new Client(i, nume, prenume, tipClient, nr_telefon, email);
                            int ok=0;

                            if(ok==0)
                            {
                                try
                                {
                                    sqlconnection.updateClient(tempClient);
                                    setVisible(false);
                                    dispose();

                                    JOptionPane.showMessageDialog(secondwindow, "Client updated", "Client updated",  JOptionPane.INFORMATION_MESSAGE);
                                }
                                catch(Exception e)
                                {
                                    JOptionPane.showMessageDialog(secondwindow, "Error updating client", "Error", JOptionPane.ERROR_MESSAGE);;
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(secondwindow, "Invalid", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    okButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                    okButton.setActionCommand("OK");
                    buttonPane.add(okButton);
                    getRootPane().setDefaultButton(okButton);
                }
                {
                    JButton cancelButton = new JButton("Cancel");
                    cancelButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            setVisible(false);
                            dispose();
                        }
                    });
                    cancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                    cancelButton.setActionCommand("Cancel");
                    buttonPane.add(cancelButton);
                }
            }
        }
    }
