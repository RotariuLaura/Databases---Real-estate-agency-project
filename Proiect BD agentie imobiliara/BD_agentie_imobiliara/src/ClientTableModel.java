import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ClientTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private static final int ID_COL = 0;
    private static final int NUME_COL = 1;
    private static final int PRENUME_COL = 2;
    private static final int TIP_CLIENT_COL = 3;
    private static final int NR_TELEFON_COL = 4;
    private static final int EMAIL_COL = 5;
    public static final int OBJECT_COL = -1;
    private String[] columnNames = {"nr client", "nume", "prenume", "tip_client", "nr_telefon", "email"};
    private List<Client> clients;
    public ClientTableModel(List <Client> theClients)
    {
        clients = theClients;
    }
    @Override
    public int getRowCount() {
        return clients.size();
    }
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    public String getColumnName(int col){
        return columnNames[col];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client tempClient = clients.get(rowIndex);
        switch(columnIndex){
            case ID_COL:
                return tempClient.getId();
            case NUME_COL:
                return tempClient.getNume();
            case PRENUME_COL:
                return tempClient.getPrenume();
            case TIP_CLIENT_COL:
                return tempClient.getTip_client();
            case NR_TELEFON_COL:
                return tempClient.getNr_telefon();
            case EMAIL_COL:
                return tempClient.getEmail();
            case OBJECT_COL:
                return tempClient;
            default:
                return tempClient.getNume();
        }
    }
}
