import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AdresaTabelModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private static final int ID_COL = 0;
    private static final int ORAS_COL = 1;
    private static final int STRADA_COL = 2;
    private static final int NUMAR_COL = 3;
    private static final int SCARA_COL = 4;
    private static final int ETAJ_COL = 5;
    private static final int NR_APARTAMENT_COL = 6;
    public static final int OBJECT_COL = -1;
    private String[] columnNames = {"nr adresa", "oras", "strada", "numar", "scara", "etaj", "nr"};
    private List<Adresa> adrese;
    public AdresaTabelModel(List <Adresa> adr)
    {
        adrese = adr;
    }
    @Override
    public int getRowCount() {
        return adrese.size();
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
        Adresa tempAdresa = adrese.get(rowIndex);
        switch(columnIndex){
            case ID_COL:
                return tempAdresa.getId();
            case ORAS_COL:
                return tempAdresa.getOras();
            case STRADA_COL:
                return tempAdresa.getStrada();
            case NUMAR_COL:
                return tempAdresa.getNumar();
            case SCARA_COL:
                return tempAdresa.getScara();
            case ETAJ_COL:
                return tempAdresa.getEtaj();
            case NR_APARTAMENT_COL:
                return tempAdresa.getNr_apartament();
            case OBJECT_COL:
                return tempAdresa;
            default:
                return tempAdresa.getId();
        }
    }
}
