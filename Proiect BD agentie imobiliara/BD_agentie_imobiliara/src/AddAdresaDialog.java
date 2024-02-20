import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAdresaDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField idTextField;
    private JTextField orasTextField;
    private JTextField stradaTextField;
    private JTextField numarTextField;
    private JTextField scaraTextField;
    private JTextField etajTextField;
    private JTextField nrApTextField;
    private SqlConnection sqlConnection;
    private SecondWindow secondWindow;
    public static void main(String[] args){
        try{
            AddAdresaDialog dialog = new AddAdresaDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public AddAdresaDialog(SecondWindow theSecondWindow, SqlConnection theSqlConnection)
    {
        this();
        secondWindow = theSecondWindow;
        sqlConnection = theSqlConnection;
    }
    public AddAdresaDialog(){
        setTitle("Insert data");
        setBounds(100, 100, 347, 360);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        JLabel lblId = new JLabel("Nr adresa");
        lblId.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblId.setBounds(28, 23, 66, 28);
        contentPanel.add(lblId);

        JLabel lblOras = new JLabel("Oras");
        lblOras.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblOras.setBounds(28, 62, 66, 28);
        contentPanel.add(lblOras);

        JLabel lblStrada = new JLabel("Strada");
        lblStrada.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblStrada.setBounds(28, 101, 66, 28);
        contentPanel.add(lblStrada);

        JLabel lblNr = new JLabel("Numar");
        lblNr.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNr.setBounds(28, 140, 66, 28);
        contentPanel.add(lblNr);

        JLabel lblScara = new JLabel("Scara");
        lblScara.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblScara.setBounds(28, 182, 66, 28);
        contentPanel.add(lblScara);

        JLabel lblEtaj = new JLabel("Etaj");
        lblEtaj.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblEtaj.setBounds(28, 218, 66, 28);
        contentPanel.add(lblEtaj);

        JLabel lblNrAp = new JLabel("Nr apt");
        lblNrAp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNrAp.setBounds(28, 254, 66, 28);
        contentPanel.add(lblNrAp);

        idTextField = new JTextField();
        idTextField.setBounds(115, 23, 200, 28);
        contentPanel.add(idTextField);
        idTextField.setColumns(10);

        orasTextField = new JTextField();
        orasTextField.setBounds(115, 62, 200, 28);
        contentPanel.add(orasTextField);
        orasTextField.setColumns(10);

        stradaTextField = new JTextField();
        stradaTextField.setBounds(115, 101, 200, 28);
        contentPanel.add(stradaTextField);
        stradaTextField.setColumns(10);

        numarTextField = new JTextField();
        numarTextField.setBounds(115, 140, 200, 28);
        contentPanel.add(numarTextField);
        numarTextField.setColumns(10);

        scaraTextField = new JTextField();
        scaraTextField.setBounds(115, 182, 200, 28);
        contentPanel.add(scaraTextField);
        scaraTextField.setColumns(10);

        etajTextField = new JTextField();
        etajTextField.setBounds(115, 218, 200, 28);
        contentPanel.add(etajTextField);
        etajTextField.setColumns(10);

        nrApTextField = new JTextField();
        nrApTextField.setBounds(115, 254, 200, 28);
        contentPanel.add(nrApTextField);
        nrApTextField.setColumns(10);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        JButton okButton = new JButton("Save");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idtxt = idTextField.getText();
                int id = Integer.parseInt(idtxt);
                String oras = orasTextField.getText();
                String strada = stradaTextField.getText();
                String numar = numarTextField.getText();
                int nr = Integer.parseInt(numar);
                String scara = scaraTextField.getText();
                String etaj = etajTextField.getText();
                String nr_ap = nrApTextField.getText();
                int nrAp = Integer.parseInt(nr_ap);
                Adresa tempAdresa = new Adresa(id, oras, strada, nr, scara, etaj, nrAp);
                int ok=0;

                if (ok==0) {
                    try {
                        sqlConnection.addAdresa(tempAdresa);
                        setVisible(true);
                        dispose();
                        JOptionPane.showMessageDialog(secondWindow, "Address added", "Address added", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(secondWindow, "Error saving address", "Error", JOptionPane.ERROR_MESSAGE);
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
