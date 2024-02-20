public class Adresa {
    private int id;
    private String oras;
    private String strada;
    private int numar;
    private String scara;
    private String etaj;
    private int nr_apartament;
    public Adresa(int id, String oras, String strada, int numar, String scara, String etaj, int nr_apartament){
        this.id  = id;
        this.oras = oras;
        this.strada = strada;
        this.numar = numar;
        this.scara = scara;
        this.etaj = etaj;
        this.nr_apartament = nr_apartament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public String getScara() {
        return scara;
    }

    public void setScara(String scara) {
        this.scara = scara;
    }

    public String getEtaj() {
        return etaj;
    }

    public void setEtaj(String etaj) {
        this.etaj = etaj;
    }

    public int getNr_apartament() {
        return nr_apartament;
    }

    public void setNr_apartament(int nr_apartament) {
        this.nr_apartament = nr_apartament;
    }
}
