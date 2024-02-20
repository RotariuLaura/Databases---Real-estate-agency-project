import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SecondWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private SqlConnection cnct;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    SecondWindow frame = new SecondWindow();
                    frame.setVisible(true);
                    frame.setTitle("Database Manager");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SecondWindow() {
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 695, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        contentPane.setBorder(blackline);
        try {
            cnct = new SqlConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR!" + e);
        }

        JButton btnShowTable = new JButton("Show Clients");
        btnShowTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Client> clients = null;
                    clients = cnct.getAllClient();
                    ClientTableModel model = new ClientTableModel(clients);
                    table.setModel(model);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + ex);
                }
            }
        });
        btnShowTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnShowTable.setBounds(10, 11, 125, 33);
        contentPane.add(btnShowTable);

        JButton btnSearch = new JButton("Search Client");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume;
                nume = JOptionPane.showInputDialog(null, "Insert the name of the client", JOptionPane.PLAIN_MESSAGE);
                try {
                    List<Client> clients = null;
                    if (nume != null && nume.trim().length() > 0) {
                        clients = cnct.searchClient(nume);
                    }
                    ClientTableModel model = new ClientTableModel(clients);
                    table.setModel(model);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + ex);
                }
            }
        });
        btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnSearch.setBounds(188, 11, 125, 33);
        contentPane.add(btnSearch);

        JButton btnInsertData = new JButton("Insert Client");
        btnInsertData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AddClientDialog dialog = new AddClientDialog(SecondWindow.this, cnct);
                dialog.setVisible(true);
            }
        });

        btnInsertData.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnInsertData.setBounds(374, 11, 125, 33);
        contentPane.add(btnInsertData);

        JButton btnUpdateData = new JButton("Update Client");
        btnUpdateData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(SecondWindow.this, "You must select a client", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Client tempClient = (Client) (table.getValueAt(row, ClientTableModel.OBJECT_COL));
                UpdateClientDialog dialog1 = new UpdateClientDialog(SecondWindow.this, cnct, tempClient);
                dialog1.setVisible(true);
            }
        });
        btnUpdateData.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnUpdateData.setBounds(550, 11, 125, 33);
        contentPane.add(btnUpdateData);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 270, 700, 300);
        contentPane.add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 665, 208);
        panel.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String selectedItem = (String) comboBox.getSelectedItem();
                if (selectedItem.equals("A - Z Order")) {
                    try {
                        List<Client> customers = null;
                        customers = cnct.getAllClientAlphabetical();
                        ClientTableModel model = new ClientTableModel(customers);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }

                if (selectedItem.equals("Z - A Order")) {
                    try {
                        List<Client> clients = null;
                        clients = cnct.getAllClientInverseAlphabetical();
                        ClientTableModel model = new ClientTableModel(clients);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }

                if (selectedItem.equals("By Type 1 Order")) {
                    try {
                        List<Client> clients = null;
                        clients = cnct.getCustomerByType1();
                        ClientTableModel model = new ClientTableModel(clients);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }
                if (selectedItem.equals("By Type 2 Order")) {
                    try {
                        List<Client> clients = null;
                        clients = cnct.getCustomerByType2();
                        ClientTableModel model = new ClientTableModel(clients);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }
            }
        });
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[]{"Filter Clients", "A - Z Order", "Z - A Order", "By Type 1 Order", "By Type 2 Order"}));
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        comboBox.setBounds(10, 65, 125, 33);
        contentPane.add(comboBox);

        JButton btnShowTable1 = new JButton("Show Properties");
        btnShowTable1.addActionListener(new ActionListener() {
           @Override
         public void actionPerformed(ActionEvent e) {
                try{
                   List<Proprietate> proprietati = null;
                   proprietati = cnct.getAllProprietati();
                   ProprietateTabelModel model = new ProprietateTabelModel(proprietati);
                   table.setModel(model);
               } catch (Exception ex) {
                   JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + ex);
                }
           }
       });
        btnShowTable1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnShowTable1.setBounds(10, 175, 125, 33);
        contentPane.add(btnShowTable1);

        JButton btnShowTable2 = new JButton("Show Addresses");
        btnShowTable2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    List<Adresa> adrese = null;
                    adrese = cnct.getAllAdrese();
                    AdresaTabelModel model = new AdresaTabelModel(adrese);
                    table.setModel(model);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + ex);
                }
            }
        });
        btnShowTable2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnShowTable2.setBounds(10, 120, 125, 33);
        contentPane.add(btnShowTable2);

        JButton btnShowTable3 = new JButton("Show Types");
        btnShowTable3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    List<TipProprietate> tipProp = null;
                    tipProp = cnct.getAllTipProp();
                    TipPropTabelModel model = new TipPropTabelModel(tipProp);
                    table.setModel(model);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + ex);
                }
            }
        });
        btnShowTable3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnShowTable3.setBounds(550, 65, 125, 33);
        contentPane.add(btnShowTable3);

        JButton btnShowTable4 = new JButton("Show Agents");
        btnShowTable4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    List<Agent> agents = null;
                    agents = cnct.getAllAgents();
                    AgentTableModel model1 = new AgentTableModel(agents);
                    table.setModel(model1);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + ex);
                }
            }
        });
        btnShowTable4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnShowTable4.setBounds(188, 65, 125, 33);
        contentPane.add(btnShowTable4);

        JButton btnShowTable5 = new JButton("Show Owners");
        btnShowTable5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    List<Proprietar> proprietari = null;
                    proprietari = cnct.getAllProprietari();
                    ProprietarTableModel model = new ProprietarTableModel(proprietari);
                    table.setModel(model);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + ex);
                }
            }
        });
        btnShowTable5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnShowTable5.setBounds(376, 65, 125, 33);
        contentPane.add(btnShowTable5);

        JButton btnShowTable6 = new JButton("Show Offers");
        btnShowTable6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    List<Oferta> oferte = null;
                    oferte = cnct.getAllOferte();
                    OfertaTabelModel model = new OfertaTabelModel(oferte);
                    table.setModel(model);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + ex);
                }
            }
        });
        btnShowTable6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnShowTable6.setBounds(188, 120, 125, 33);
        contentPane.add(btnShowTable6);

        JButton btnInsertData2 = new JButton("Insert Property");
        btnInsertData2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AddProprietateDialog dialog = new AddProprietateDialog(SecondWindow.this, cnct);
                dialog.setVisible(true);
            }
        });

        btnInsertData2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnInsertData2.setBounds(188, 175, 125, 33);
        contentPane.add(btnInsertData2);

        JButton btnInsertData3 = new JButton("Insert Address");
        btnInsertData3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AddAdresaDialog dialog= new AddAdresaDialog(SecondWindow.this, cnct);
                dialog.setVisible(true);
            }
        });

        btnInsertData3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnInsertData3.setBounds(376, 120, 125, 33);
        contentPane.add(btnInsertData3);

        JButton btnInsertData4 = new JButton("Insert Offer");
        btnInsertData4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AddOfertaDialog dialog= new AddOfertaDialog(SecondWindow.this, cnct);
                dialog.setVisible(true);
            }
        });

        btnInsertData4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnInsertData4.setBounds(550, 120, 125, 33);
        contentPane.add(btnInsertData4);

        JButton btnShowTable7 = new JButton("Show Views");
        btnShowTable7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    List<Vizionare> vizionari = null;
                    vizionari = cnct.getAllVizionari();
                    VizionareTableModel model = new VizionareTableModel(vizionari);
                    table.setModel(model);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + ex);
                }
            }
        });
        btnShowTable7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnShowTable7.setBounds(376, 175, 125, 33);
        contentPane.add(btnShowTable7);

        JButton btnShowTable8 = new JButton("Show Rentals");
        btnShowTable8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    List<Inchiriere> inchirieri = null;
                    inchirieri = cnct.getAllInchirieri();
                    InchiriereTableModel model = new InchiriereTableModel(inchirieri);
                    table.setModel(model);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + ex);
                }
            }
        });
        btnShowTable8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnShowTable8.setBounds(550, 175, 125, 33);
        contentPane.add(btnShowTable8);

        JComboBox<String> comboBox1 = new JComboBox<String>();
        comboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String selectedItem = (String) comboBox1.getSelectedItem();
                if (selectedItem.equals("1) Clientii care au vizionat proprietati de tipul 1?")) {
                    try {
                        List<Client> clients = null;
                        clients = cnct.Query1();
                        ClientTableModel model = new ClientTableModel(clients);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }

                if (selectedItem.equals("2) Proprietarii care detin proprietati de tipul 1?")) {
                    try {
                        List<Proprietar> proprietari = null;
                        proprietari = cnct.Query6();
                        ProprietarTableModel model = new ProprietarTableModel(proprietari);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }

                if (selectedItem.equals("3) Proprietarii care detin proprietati in orasele Cluj si Bucuresti?")) {
                    try {
                        List<Proprietar> proprietari = null;
                        proprietari = cnct.Query2();
                        ProprietarTableModel model = new ProprietarTableModel(proprietari);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }
                if (selectedItem.equals("4) Ce clienti au inchiriat proprietatile pe care le-au vizionat?")) {
                    try {
                        List<Client> clients = null;
                        clients = cnct.Query3();
                        ClientTableModel model = new ClientTableModel(clients);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }
                if (selectedItem.equals("5) Ce clienti au inchiriat proprietati in anul 2022?")) {
                    try {
                        List<Client> clients = null;
                        clients = cnct.Query4();
                        ClientTableModel model = new ClientTableModel(clients);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }
                if (selectedItem.equals("6) Ce agent se ocupa de proprietatea de pe strada Dorobantilor?")) {
                    try {
                        List<Agent> agenti = null;
                        agenti = cnct.Query5();
                        AgentTableModel model = new AgentTableModel(agenti);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }
                if (selectedItem.equals("7) Ce clienti au vizionat in data de 20.04.2022 proprietati?")) {
                    try {
                        List<Client> clienti = null;
                        clienti = cnct.Query7();
                        ClientTableModel model = new ClientTableModel(clienti);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }
                if (selectedItem.equals("8) Clientii care au vizionat proprietatea cu numarul 2?")) {
                    try {
                        List<Client> clienti = null;
                        clienti = cnct.Query8();
                        ClientTableModel model = new ClientTableModel(clienti);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }
                if (selectedItem.equals("9) Proprietarul proprietatii vizionate de clientul 4 in data de 10.08.2022?")) {
                    try {
                        List<Proprietar> prop = null;
                        prop = cnct.Query9();
                        ProprietarTableModel model = new ProprietarTableModel(prop);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }
                if (selectedItem.equals("10) De care proprietati se ocupa agentul cu numele Rusu Ionut?")) {
                    try {
                        List<Proprietate> prop = null;
                        prop = cnct.Query10();
                        ProprietateTabelModel model = new ProprietateTabelModel(prop);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }
                if (selectedItem.equals("11) Ce clienti au vizionat mai multe proprietati?")) {
                    try {
                        List<Client> clienti = null;
                        clienti = cnct.Query11();
                        ClientTableModel model = new ClientTableModel(clienti);
                        table.setModel(model);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(SecondWindow.this, "ERROR!" + exc);
                    }
                }
            }
        });
        comboBox1.setModel(new DefaultComboBoxModel<String>(new String[]{"Queries", "1) Clientii care au vizionat proprietati de tipul 1?", "2) Proprietarii care detin proprietati de tipul 1?",
                "3) Proprietarii care detin proprietati in orasele Cluj si Bucuresti?", "4) Ce clienti au inchiriat proprietatile pe care le-au vizionat?",
                "5) Ce clienti au inchiriat proprietati in anul 2022?", "6) Ce agent se ocupa de proprietatea de pe strada Dorobantilor?",
                "7) Ce clienti au vizionat in data de 20.04.2022 proprietati?", "8) Clientii care au vizionat proprietatea cu numarul 2?",
                "9) Proprietarul proprietatii vizionate de clientul 4 in data de 10.08.2022?",
                "10) De care proprietati se ocupa agentul cu numele Rusu Ionut?", "11) Ce clienti au vizionat mai multe proprietati?"}));
        comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        comboBox1.setBounds(10, 220, 665, 33);
        contentPane.add(comboBox1);
      }
    }
