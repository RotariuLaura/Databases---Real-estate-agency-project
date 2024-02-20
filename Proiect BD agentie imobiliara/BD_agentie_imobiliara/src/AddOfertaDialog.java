import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOfertaDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField idTextField;
    private JTextField statusTextField;
    private SqlConnection sqlConnection;
    private SecondWindow secondWindow;
    public static void main(String[] args){
        try{
            AddOfertaDialog dialog = new AddOfertaDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public AddOfertaDialog(SecondWindow theSecondWindow, SqlConnection theSqlConnection)
    {
        this();
        secondWindow = theSecondWindow;
        sqlConnection = theSqlConnection;
    }
    public AddOfertaDialog(){
        setTitle("Insert data");
        setBounds(100, 100, 347, 200);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblId = new JLabel("Nr oferta");
        lblId.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblId.setBounds(28, 23, 66, 28);
        contentPanel.add(lblId);

        JLabel lblStatus = new JLabel("Status");
        lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblStatus.setBounds(28, 62, 66, 28);
        contentPanel.add(lblStatus);

        idTextField = new JTextField();
        idTextField.setBounds(115, 23, 200, 28);
        contentPanel.add(idTextField);
        idTextField.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "ACTIVA", "INACTIVA"}));
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        comboBox.setBounds(115, 62, 200, 28);
        contentPanel.add(comboBox);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        JButton okButton = new JButton("Save");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idtxt = idTextField.getText();
                int id = Integer.parseInt(idtxt);
                String status = (String) comboBox.getSelectedItem();
                Oferta tempOferta = new Oferta(id, status);
                int ok=0;

                if (ok==0) {
                    try {
                        sqlConnection.addOferta(tempOferta);
                        setVisible(true);
                        dispose();
                        JOptionPane.showMessageDialog(secondWindow, "Offer added", "Offer added", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(secondWindow, "Error saving offer", "Error", JOptionPane.ERROR_MESSAGE);
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
