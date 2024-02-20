public class TipProprietate {
    private int id;
    private String decomandata;
    private String nume;
    private int nrCamere;
    private int suprafata;

    public TipProprietate(int id, String decomandata, String nume, int nrCamere, int suprafata) {
        this.id = id;
        this.decomandata = decomandata;
        this.nume = nume;
        this.nrCamere = nrCamere;
        this.suprafata = suprafata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDecomandata() {
        return decomandata;
    }

    public void setDecomandata(String decomandata) {
        this.decomandata = decomandata;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getNrCamere() {
        return nrCamere;
    }

    public void setNrCamere(int nrCamere) {
        this.nrCamere = nrCamere;
    }

    public int getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(int suprafata) {
        this.suprafata = suprafata;
    }
}
