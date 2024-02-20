public class Client {
    private int id;
    private String nume;
    private String prenume;
    private String tip_client;
    private String nr_telefon;
    private String email;
    public Client(int id, String nume, String prenume, String tip_client, String nr_telefon, String email){
        this.id  = id;
        this.nume = nume;
        this.prenume = prenume;
        this.tip_client = tip_client;
        this.nr_telefon = nr_telefon;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTip_client() {
        return tip_client;
    }

    public void setTip_client(String tip_client) {
        this.tip_client = tip_client;
    }

    public String getNr_telefon() {
        return nr_telefon;
    }

    public void setNr_telefon(String nr_telefon) {
        this.nr_telefon = nr_telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Client [id=%s, nume=%s, prenume=%s, tip_client=%s, nr_telefon=%s, email=%s]", id, nume, prenume, tip_client, nr_telefon, email);
    }
}
