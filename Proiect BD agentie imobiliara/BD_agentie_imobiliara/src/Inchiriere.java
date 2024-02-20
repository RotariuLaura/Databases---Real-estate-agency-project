public class Inchiriere {
    private int id;
    private String data_inchirierii;
    private String data_eliberarii;
    private int proprietate_id;
    private int client_id;

    public Inchiriere(int id, String data_vizionarii, String data_eliberarii, int proprietate_id, int client_id) {
        this.id = id;
        this.data_inchirierii = data_vizionarii;
        this.data_eliberarii = data_eliberarii;
        this.proprietate_id = proprietate_id;
        this.client_id = client_id;
    }

    public int getId() {
        return id;
    }

    public String getData_inchirierii() {
        return data_inchirierii;
    }

    public String getData_eliberarii() {
        return data_eliberarii;
    }

    public int getProprietate_id() {
        return proprietate_id;
    }

    public int getClient_id() {
        return client_id;
    }
}
