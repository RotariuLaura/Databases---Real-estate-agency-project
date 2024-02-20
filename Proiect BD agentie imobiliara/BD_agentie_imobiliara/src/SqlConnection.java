import java.sql.*;
import java.util.*;

public class SqlConnection {
    private Connection con;

    public SqlConnection() throws Exception {
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proiect_agentie_imobiliara?serverTimezone=UTC&user=root&password=12345678");
    }
    public List<Client> getAllClient() throws Exception {
        List <Client> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("select * from client");
            while(myRs.next()){
                Client tempClient = convertRowToCustomer(myRs);
                list.add(tempClient);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }

    private Client convertRowToCustomer(ResultSet myRs) throws SQLException {
        int id = myRs.getInt("client_id");
        String nume = myRs.getString("nume");
        String prenume = myRs.getString("prenume");
        String tip_client = myRs.getString("tip_client");
        String nr_telefon = myRs.getString("nr_telefon");
        String email = myRs.getString("email");

        Client tempClient = new Client(id, nume, prenume, tip_client, nr_telefon, email);
        return tempClient;
    }
    public List<Client> getAllClientAlphabetical() throws Exception
    {
        List <Client> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("select * from client order by nume");
            while(myRs.next()){
                Client tempClient = convertRowToCustomer(myRs);
                list.add(tempClient);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public List<Client> getAllClientInverseAlphabetical() throws Exception
    {
        List <Client> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("select * from client order by nume desc");
            while(myRs.next()){
                Client tempClient = convertRowToCustomer(myRs);
                list.add(tempClient);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public List<Client> getCustomerByType1() throws Exception
    {
        List<Client> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("select * from client where tip_client like '%persoana fizica'");

            while (myRs.next()) {
                Client tempCustomer = convertRowToCustomer(myRs);
                list.add(tempCustomer);
            }

            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public List<Client> getCustomerByType2() throws Exception
    {
        List<Client> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("select * from client where tip_client like '%firma'");

            while (myRs.next()) {
                Client tempCustomer = convertRowToCustomer(myRs);
                list.add(tempCustomer);
            }

            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public List<Client> searchClient(String nume) throws Exception {
        List<Client> list = new ArrayList<>();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            nume = "%" + nume + "%";
            myStmt = con.prepareStatement("select * from client where nume like ?");
            myStmt.setString(1, nume);
            myRs = myStmt.executeQuery();
            while (myRs.next()) {
                Client tempClient = convertRowToCustomer(myRs);
                list.add(tempClient);
            }
            return list;
        } finally {
            close(myStmt, myRs);
        }
    }
    public void addClient(Client clientul) throws Exception{
        PreparedStatement myStmt = null;
        try{
            myStmt = con.prepareStatement("insert into client" + " (client_id, nume, prenume, tip_client, nr_telefon, email)" + " values(?,?,?,?,?,?)");
            myStmt.setInt(1, clientul.getId());
            myStmt.setString(2, clientul.getNume());
            myStmt.setString(3, clientul.getPrenume());
            myStmt.setString(4, clientul.getTip_client());
            myStmt.setString(5, clientul.getNr_telefon());
            myStmt.setString(6, clientul.getEmail());
            myStmt.executeUpdate();
        }
        finally {
            close(null, myStmt, null);
        }
    }
    public void updateClient(Client clientul) throws Exception{
        PreparedStatement myStmt = null;
        try{
            myStmt = con.prepareStatement("update client" + " set nume=?, prenume=?, tip_client=?, nr_telefon=?, email=? where client_id=?");
            myStmt.setString(1, clientul.getNume());
            myStmt.setString(2, clientul.getPrenume());
            myStmt.setString(3, clientul.getTip_client());
            myStmt.setString(4, clientul.getNr_telefon());
            myStmt.setString(5, clientul.getEmail());
            myStmt.setInt(6, clientul.getId());
            myStmt.executeUpdate();
        }
        finally {
            close(null, myStmt, null);
        }
    }
    public void deleteClient(int idclient) throws Exception{
        PreparedStatement myStmt = null;
        try{
            myStmt = con.prepareStatement("delete from client where client_id=?");
            myStmt.setInt(1, idclient);
            myStmt.executeUpdate();
        }
        finally {
            close(null, myStmt, null);
        }
    }
    private static void close(Connection con, Statement myStmt, ResultSet myRs) throws SQLException
    {
        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {

        }

        if (con != null) {
            con.close();
        }
    }
    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }
    private Proprietate convertRowToCustomer1(ResultSet myRs) throws SQLException {
        int id = myRs.getInt("proprietate_id");
        float pret = myRs.getFloat("pret");
        String descriere = myRs.getString("descriere");
        String status_proprietate = myRs.getString("status_proprietate");
        int agent_id = myRs.getInt("agent_id");
        int proprietar_id = myRs.getInt("proprietar_id");
        int tip_proprietate_id = myRs.getInt("tip_proprietate_id");
        int adresa_adresa_id = myRs.getInt("adresa_adresa_id");
        int oferta_oferta_id = myRs.getInt("oferta_oferta_id");
        Proprietate tempProprietate = new Proprietate(id, pret, descriere, status_proprietate, agent_id, proprietar_id, tip_proprietate_id,
                adresa_adresa_id, oferta_oferta_id);
        return tempProprietate;
    }

    public List<Proprietate> getAllProprietati() throws Exception {
        List <Proprietate> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("select * from proprietate");
            while(myRs.next()){
                Proprietate tempProprietate = convertRowToCustomer1(myRs);
                list.add(tempProprietate);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public void addProprietate(Proprietate proprietate) throws Exception{
        PreparedStatement myStmt = null;
        try{
            myStmt = con.prepareStatement("insert into proprietate" + " (proprietate_id, pret, descriere, status_proprietate, agent_id, proprietar_id, tip_proprietate_id, adresa_adresa_id, oferta_oferta_id)" + " values(?,?,?,?,?,?,?,?,?)");
            myStmt.setInt(1, proprietate.getId());
            myStmt.setFloat(2, proprietate.getPret());
            myStmt.setString(3, proprietate.getDescriere());
            myStmt.setString(4, proprietate.getStatus_proprietate());
            myStmt.setInt(5, proprietate.getAgent_id());
            myStmt.setInt(6, proprietate.getProprietar_id());
            myStmt.setInt(7, proprietate.getTip_proprietate_id());
            myStmt.setInt(8, proprietate.getAdresa_adresa_id());
            myStmt.setInt(9, proprietate.getOferta_oferta_id());
            myStmt.executeUpdate();
        }
        finally {
            close(null, myStmt, null);
        }
    }
    private Adresa convertRowToCustomer2(ResultSet myRs) throws SQLException {
        int id = myRs.getInt("adresa_id");
        String oras = myRs.getString("oras");
        String strada = myRs.getString("strada");
        int numar = myRs.getInt("numar");
        String scara = myRs.getString("scara");
        String etaj = myRs.getString("etaj");
        int nr_apartament = myRs.getInt("nr_apartament");
        Adresa tempAdresa = new Adresa(id, oras, strada, numar, scara, etaj, nr_apartament);
        return tempAdresa;
    }

    public List<Adresa> getAllAdrese() throws Exception {
        List <Adresa> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("select * from adresa");
            while(myRs.next()){
                Adresa tempAdresa = convertRowToCustomer2(myRs);
                list.add(tempAdresa);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public void addAdresa(Adresa adresa) throws Exception{
        PreparedStatement myStmt = null;
        try{
            myStmt = con.prepareStatement("insert into adresa" + " (adresa_id, oras, strada, numar, scara, etaj, nr_apartament)"  + " values(?,?,?,?,?,?,?)");
            myStmt.setInt(1, adresa.getId());
            myStmt.setString(2, adresa.getOras());
            myStmt.setString(3, adresa.getStrada());
            myStmt.setInt(4, adresa.getNumar());
            myStmt.setString(5, adresa.getScara());
            myStmt.setString(6, adresa.getEtaj());
            myStmt.setInt(7, adresa.getNr_apartament());
            myStmt.executeUpdate();
        }
        finally {
            close(null, myStmt, null);
        }
    }

    private TipProprietate convertRowToCustomer3(ResultSet myRs) throws SQLException {
        int id = myRs.getInt("tip_proprietate_id");
        String decomandata = myRs.getString("decomandata");
        String nume = myRs.getString("nume_proprietate");
        int nr_camere = myRs.getInt("nr_camere");
        int suprafata = myRs.getInt("suprafata");
        TipProprietate tempTip = new TipProprietate(id, decomandata, nume, nr_camere, suprafata);
        return tempTip;
    }

    public List<TipProprietate> getAllTipProp() throws Exception {
        List <TipProprietate> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("select * from tipproprietate");
            while(myRs.next()){
                TipProprietate tempTipProp = convertRowToCustomer3(myRs);
                list.add(tempTipProp);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }

    private Agent convertRowToCustomer4(ResultSet myRs) throws SQLException {
        int id = myRs.getInt("agent_id");
        String nume = myRs.getString("nume");
        String prenume = myRs.getString("prenume");
        String nr_telefon = myRs.getString("nr_telefon");
        String email = myRs.getString("email");
        Agent tempAgent = new Agent(id, nume, prenume, nr_telefon, email);
        return tempAgent;
    }

    public List<Agent> getAllAgents() throws Exception {
        List <Agent> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("select * from agent");
            while(myRs.next()){
                Agent tempAgent = convertRowToCustomer4(myRs);
                list.add(tempAgent);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    private Proprietar convertRowToCustomer5(ResultSet myRs) throws SQLException {
        int id = myRs.getInt("proprietar_id");
        String nume = myRs.getString("nume");
        String prenume = myRs.getString("prenume");
        String nr_telefon = myRs.getString("nr_telefon");
        String email = myRs.getString("email");
        Proprietar tempProprietar = new Proprietar(id, nume, prenume, nr_telefon, email);
        return tempProprietar;
    }

    public List<Proprietar> getAllProprietari() throws Exception {
        List <Proprietar> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("select * from proprietar");
            while(myRs.next()){
                Proprietar tempProprietar = convertRowToCustomer5(myRs);
                list.add(tempProprietar);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    private Oferta convertRowToCustomer6(ResultSet myRs) throws SQLException {
        int id = myRs.getInt("oferta_id");
        String status = myRs.getString("status_oferta");
        Oferta tempOferta = new Oferta(id, status);
        return tempOferta;
    }

    public List<Oferta> getAllOferte() throws Exception {
        List <Oferta> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("select * from oferta");
            while(myRs.next()){
                Oferta tempOferta = convertRowToCustomer6(myRs);
                list.add(tempOferta);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public void addOferta(Oferta oferta) throws Exception{
        PreparedStatement myStmt = null;
        try{
            myStmt = con.prepareStatement("insert into oferta" + " (oferta_id, status_oferta)"  + " values(?,?)");
            myStmt.setInt(1, oferta.getId());
            myStmt.setString(2, oferta.getStatus());
            myStmt.executeUpdate();
        }
        finally {
            close(null, myStmt, null);
        }
    }
    private Vizionare convertRowToCustomer7(ResultSet myRs) throws SQLException {
        int id = myRs.getInt("vizionare_id");
        String data = String.valueOf(myRs.getDate("data_vizionarii"));
        int ora = myRs.getInt("ora_vizionarii");
        int proprietate_id = myRs.getInt("proprietate_id");
        int client_id = myRs.getInt("client_id");
        String vizionare = myRs.getString("inchiriere");
        Vizionare tempVizionare = new Vizionare(id, data, ora, proprietate_id, client_id, vizionare);
        return tempVizionare;
    }

    public List<Vizionare> getAllVizionari() throws Exception {
        List <Vizionare> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("select * from vizionare");
            while(myRs.next()){
                Vizionare tempVizionare = convertRowToCustomer7(myRs);
                list.add(tempVizionare);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    private Inchiriere convertRowToCustomer8(ResultSet myRs) throws SQLException {
        int id = myRs.getInt("inchiriere_id");
        String data_inchirierii = String.valueOf(myRs.getDate("data_inchirierii"));
        String data_eliberarii = String.valueOf(myRs.getDate("data_eliberarii"));
        int proprietate_id = myRs.getInt("proprietate_id");
        int client_id = myRs.getInt("client_id");
        Inchiriere tempInchiriere = new Inchiriere(id, data_inchirierii, data_eliberarii, proprietate_id, client_id);
        return tempInchiriere;
    }

    public List<Inchiriere> getAllInchirieri() throws Exception {
        List <Inchiriere> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("select * from inchiriere");
            while(myRs.next()){
                Inchiriere tempInchiriere = convertRowToCustomer8(myRs);
                list.add(tempInchiriere);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public List<Client> Query1() throws Exception// clientii care au vizionat proprietati de tipul 1(garsoniera)
    {
        List <Client> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM client" + " INNER JOIN vizionare" +
                    " ON vizionare.client_id = client.client_id" +
                    " INNER JOIN proprietate " +
                    " ON vizionare.proprietate_id = proprietate.proprietate_id" +
                    " WHERE proprietate.tip_proprietate_id = 1;");
            while(myRs.next()){
                Client tempClient = convertRowToCustomer(myRs);
                list.add(tempClient);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public List<Proprietar> Query2() throws Exception// Ce proprietari au proprietati in orasele Cluj si Bucuresti?
    {
        List <Proprietar> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM proprietar" + " JOIN proprietate" +
                    " ON proprietate.proprietar_id = proprietar.proprietar_id" +
                    " JOIN adresa" + " ON adresa.adresa_id=proprietate.adresa_adresa_id" +
                    " WHERE adresa.oras in ('Cluj','Bucuresti')" + "GROUP BY nume, prenume;");
            while(myRs.next()){
                Proprietar tempProprietar = convertRowToCustomer5(myRs);
                list.add(tempProprietar);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public List<Client> Query3() throws Exception//clientii care au inchiriat proprietatile pe care le-au vizionat?
    {
        List <Client> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM client" + " JOIN vizionare" +
                    " ON vizionare.client_id = client.client_id" +
                    " WHERE vizionare.inchiriere = 'DA'"+ "GROUP BY nume, prenume;");
            while(myRs.next()){
                Client tempClient = convertRowToCustomer(myRs);
                list.add(tempClient);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public List<Client> Query4() throws Exception//clientii care au inchiriat proprietati in 2022
    {
        List <Client> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM client" + " JOIN inchiriere" +
                    " ON inchiriere.client_id = client.client_id" +
                    " WHERE year(inchiriere.data_inchirierii)='2022'"+
                    " ORDER BY client.client_id ASC;");
            while(myRs.next()){
                Client tempClient = convertRowToCustomer(myRs);
                list.add(tempClient);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public List<Proprietar> Query6() throws Exception// proprietarii care au proprietati de tipul 1?
    {
        List <Proprietar> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM proprietar" + " INNER JOIN proprietate" +
                    " ON proprietate.proprietar_id = proprietar.proprietar_id" +
                    " WHERE proprietate.tip_proprietate_id = 1;");
            while(myRs.next()){
                Proprietar tempProprietar = convertRowToCustomer5(myRs);
                list.add(tempProprietar);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public List<Agent> Query5() throws Exception //ce agent se ocupa de proprietatea de pe strada Dorobantilor?
    {
        List<Agent> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM agent" + " JOIN proprietate" +
                    " ON proprietate.agent_id=agent.agent_id" + " JOIN adresa" +
                    " ON adresa.adresa_id=proprietate.adresa_adresa_id" +
                    " WHERE adresa.strada = 'Dorobantilor';");
            while (myRs.next()) {
                Agent tempAgent = convertRowToCustomer4(myRs);
                list.add(tempAgent);
            }
            return list;
        } finally {
            close(myStmt, myRs);
        }
    }
        public List<Client> Query7() throws Exception //Ce clienti au vizionat in data x proprietati?
        {
            List <Client> list = new ArrayList<>();
            Statement myStmt = null;
            ResultSet myRs = null;
            try{
                myStmt = con.createStatement();
                myRs = myStmt.executeQuery("SELECT * FROM client" + " JOIN vizionare" +
                        " ON vizionare.client_id=client.client_id" +
                        " WHERE vizionare.data_vizionarii='2022-04-20'" + " GROUP BY nume, prenume" +
                        " ORDER BY client.client_id ASC;");
                while(myRs.next()){
                    Client tempClient = convertRowToCustomer(myRs);
                    list.add(tempClient);
                }
                return list;
            }
            finally {
                close(myStmt, myRs);
            }
    }
    public List<Client> Query8() throws Exception //Clientii care au vizionat proprietatea x
    {
        List <Client> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM client" + " JOIN vizionare" +
                    " ON vizionare.client_id=client.client_id" +
                    " WHERE vizionare.proprietate_id = 2;");
            while(myRs.next()){
                Client tempClient = convertRowToCustomer(myRs);
                list.add(tempClient);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public List<Proprietar> Query9() throws Exception //Proprietarul proprietatii vizionate de clientul x in data y
    {
        List <Proprietar> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM proprietar" + " JOIN proprietate" +
                    " on proprietar.proprietar_id=proprietate.proprietar_id" +
                    " JOIN vizionare" + " on vizionare.proprietate_id=proprietate.proprietate_id" + " JOIN client "
                    + " on client.client_id=vizionare.client_id" + " WHERE client.client_id=4" +
                            " AND vizionare.data_vizionarii='2022-10-08';");
            while(myRs.next()){
                Proprietar tempProprietar = convertRowToCustomer5(myRs);
                list.add(tempProprietar);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public List<Proprietate> Query10() throws Exception //De care proprietati se ocupa agentul cu numele Rusu Ionut?
    {
        List <Proprietate> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM proprietate" + " LEFT JOIN agent" +
                    " ON agent.agent_id = proprietate.agent_id" +
                    " WHERE agent.nume = 'Rusu'" + " AND agent.prenume = 'Ionut';");
            while(myRs.next()){
                Proprietate tempProprietate = convertRowToCustomer1(myRs);
                list.add(tempProprietate);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
    public List<Client> Query11() throws Exception //Ce clienti au vizionat mai multe proprietati?
    {
        List <Client> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try{
            myStmt = con.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM client" + " JOIN vizionare" +
                    " ON vizionare.client_id = client.client_id" +
                    " GROUP BY vizionare.client_id HAVING COUNT(*)>1;");
            while(myRs.next()){
                Client tempClient = convertRowToCustomer(myRs);
                list.add(tempClient);
            }
            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }
}
