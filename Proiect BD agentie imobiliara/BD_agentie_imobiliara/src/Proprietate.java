public class Proprietate {
    private int id;
    private float pret;
    private String descriere;
    private String status_proprietate;
    private int agent_id;
    private int proprietar_id;
    private int tip_proprietate_id;
    private int adresa_adresa_id;
    private int oferta_oferta_id;
    public Proprietate(int id, float pret, String descriere, String status_proprietate, int agent_id, int proprietar_id, int tip_proprietate_id,
                       int adresa_adresa_id, int oferta_oferta_id){
        this.id  = id;
        this.pret = pret;
        this.descriere = descriere;
        this.status_proprietate = status_proprietate;
        this.agent_id = agent_id;
        this.proprietar_id = proprietar_id;
        this.tip_proprietate_id = tip_proprietate_id;
        this.adresa_adresa_id = adresa_adresa_id;
        this.oferta_oferta_id = oferta_oferta_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getStatus_proprietate() {
        return status_proprietate;
    }

    public void setStatus_proprietate(String status_proprietate) {
        this.status_proprietate = status_proprietate;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public int getProprietar_id() {
        return proprietar_id;
    }

    public void setProprietar_id(int proprietar_id) {
        this.proprietar_id = proprietar_id;
    }

    public int getTip_proprietate_id() {
        return tip_proprietate_id;
    }

    public void setTip_proprietate_id(int tip_proprietate_id) {
        this.tip_proprietate_id = tip_proprietate_id;
    }
    public int getAdresa_adresa_id() {
        return adresa_adresa_id;
    }

    public void setAdresa_adresa_id(int adresa_adresa_id) {
        this.adresa_adresa_id = adresa_adresa_id;
    }

    public int getOferta_oferta_id() {
        return oferta_oferta_id;
    }

    public void setOferta_oferta_id(int oferta_oferta_id) {
        this.oferta_oferta_id = oferta_oferta_id;
    }

    @Override
    public String toString() {
        return String.format("Proprietate [id=%s, pret=%s, descriere=%s, status proprietate=%s]", id, pret, descriere, status_proprietate);
    }
}
