public class Vizionare {
    private int id;
    private String data_vizionarii;
    private int ora_vizionarii;
    private int proprietate_id;
    private int client_id;
    private String inchiriere;

    public Vizionare(int id, String data_vizionarii, int ora_vizionarii, int proprietate_id, int client_id, String inchiriere) {
        this.id = id;
        this.data_vizionarii = data_vizionarii;
        this.ora_vizionarii = ora_vizionarii;
        this.proprietate_id = proprietate_id;
        this.client_id = client_id;
        this.inchiriere = inchiriere;
    }

    public int getId() {
        return id;
    }

    public String getData_vizionarii() {
        return data_vizionarii;
    }

    public int getOra_vizionarii() {
        return ora_vizionarii;
    }

    public int getProprietate_id() {
        return proprietate_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public String getInchiriere() {
        return inchiriere;
    }
}
