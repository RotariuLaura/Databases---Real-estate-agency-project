import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProprietateDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField idTextField;
    private JTextField pretTextField;
    private JTextField descriereTextField;
    private JTextField statusProprietateTextField;
    private JTextField agentIdTextField;
    private JTextField proprietarIdTextField;
    private JTextField tipProprietateTextField;
    private JTextField tipChiriasTextField;
    private JTextField adresaIdTextField;
    private JTextField ofertaIdTextField;
    private SqlConnection sqlConnection;
    private SecondWindow secondWindow;
    private JTextField info;
    public static void main(String[] args){
        try{
            AddClientDialog dialog = new AddClientDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public AddProprietateDialog(SecondWindow theSecondWindow, SqlConnection theSqlConnection)
    {
        this();
        secondWindow = theSecondWindow;
        sqlConnection = theSqlConnection;
    }
    public AddProprietateDialog(){
        setTitle("Insert data");
        setBounds(100, 100, 347, 450);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JTextField info = new JTextField(" Introdu inainte o adresa si o oferta cu acelasi numar ca al proprietatii!");
        info.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        info.setBounds(5, 5, 320, 30);
        contentPanel.add(info);

        JLabel lblId = new JLabel("Nr proprietate");
        lblId.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblId.setBounds(28, 40, 66, 28);
        contentPanel.add(lblId);

        JLabel lblPret = new JLabel("Pret");
        lblPret.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblPret.setBounds(28, 70, 66, 28);
        contentPanel.add(lblPret);

        JLabel lblDescriere = new JLabel("Descriere");
        lblDescriere.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblDescriere.setBounds(28, 101, 66, 28);
        contentPanel.add(lblDescriere);

        JLabel lblStatus = new JLabel("Status");
        lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblStatus.setBounds(28, 140, 66, 28);
        contentPanel.add(lblStatus);

        JLabel lblAgent = new JLabel("Nr agent ");
        lblAgent.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblAgent.setBounds(28, 182, 66, 28);
        contentPanel.add(lblAgent);

        JLabel lblProprietar = new JLabel("Nr proprietar");
        lblProprietar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblProprietar.setBounds(28, 218, 66, 28);
        contentPanel.add(lblProprietar);

        JLabel lblTip = new JLabel("Tip");
        lblTip.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblTip.setBounds(28, 254, 66, 28);
        contentPanel.add(lblTip);

        JLabel lblAdresa = new JLabel("Nr adresa");
        lblAdresa.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblAdresa.setBounds(28, 290, 66, 28);
        contentPanel.add(lblAdresa);

        JLabel lblOferta = new JLabel("Nr oferta");
        lblOferta.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblOferta.setBounds(28, 326, 66, 28);
        contentPanel.add(lblOferta);

        idTextField = new JTextField();
        idTextField.setBounds(115, 40, 200, 28);
        contentPanel.add(idTextField);
        idTextField.setColumns(10);

        pretTextField = new JTextField();
        pretTextField.setBounds(115, 70, 200, 28);
        contentPanel.add(pretTextField);
        pretTextField.setColumns(10);

        descriereTextField = new JTextField();
        descriereTextField.setBounds(115, 101, 200, 28);
        contentPanel.add(descriereTextField);
        descriereTextField.setColumns(10);

        JComboBox comboBox1 = new JComboBox();
        comboBox1.setModel(new DefaultComboBoxModel(new String[] {"Select", "DISPONIBILA", "INDISPONIBILA"}));
        comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        comboBox1.setBounds(115, 140, 200, 28);
        contentPanel.add(comboBox1);

        agentIdTextField = new JTextField();
        agentIdTextField.setBounds(115, 182, 200, 28);
        contentPanel.add(agentIdTextField);
        agentIdTextField.setColumns(10);

        proprietarIdTextField = new JTextField();
        proprietarIdTextField.setBounds(115, 218, 200, 28);
        contentPanel.add(proprietarIdTextField);
        proprietarIdTextField.setColumns(10);

        JComboBox comboBox2 = new JComboBox();
        comboBox2.setModel(new DefaultComboBoxModel(new String[] {"Select", "1", "2", "3", "4"}));
        comboBox2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        comboBox2.setBounds(115, 254, 200, 28);
        contentPanel.add(comboBox2);

        adresaIdTextField = new JTextField();
        adresaIdTextField.setBounds(115, 290, 200, 28);
        contentPanel.add(adresaIdTextField);
        adresaIdTextField.setColumns(10);

        ofertaIdTextField = new JTextField();
        ofertaIdTextField.setBounds(115, 326, 200, 28);
        contentPanel.add(ofertaIdTextField);
        ofertaIdTextField.setColumns(10);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        JButton okButton = new JButton("Save");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idtxt = idTextField.getText();
                int id = Integer.parseInt(idtxt);
                String prett = pretTextField.getText();
                float pret = Float.parseFloat(prett);
                String descriere = descriereTextField.getText();
                String status_proprietate = (String) comboBox1.getSelectedItem();
                String agentId = agentIdTextField.getText();
                int agentid = Integer.parseInt(agentId);
                String proprietarId = agentIdTextField.getText();
                int propId = Integer.parseInt(proprietarId);
                String tipProp = (String) comboBox2.getSelectedItem();
                int tip = Integer.parseInt(tipProp);
                String adresaId = agentIdTextField.getText();
                int adrId = Integer.parseInt(adresaId);
                String ofertai = agentIdTextField.getText();
                int ofertaId = Integer.parseInt(ofertai);

                Proprietate tempProp = new Proprietate(id, pret, descriere, status_proprietate, agentid, propId, tip, adrId, ofertaId);
                int ok=0;

                if (ok==0) {
                    try {
                        sqlConnection.addProprietate(tempProp);
                        setVisible(true);
                        dispose();
                        JOptionPane.showMessageDialog(secondWindow, "Property added", "Property added", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(secondWindow, "Error saving property", "Error", JOptionPane.ERROR_MESSAGE);
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
