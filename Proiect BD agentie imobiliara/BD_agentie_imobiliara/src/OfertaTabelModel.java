import javax.swing.table.AbstractTableModel;
import java.util.List;

public class OfertaTabelModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private static final int ID_COL = 0;
    private static final int STATUS_COL = 1;
    public static final int OBJECT_COL = -1;
    private String[] columnNames = {"nr oferta", "status"};
    private List<Oferta> oferte;
    public OfertaTabelModel(List <Oferta> ofr)
    {
        oferte = ofr;
    }
    @Override
    public int getRowCount() {
        return oferte.size();
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
        Oferta tempOferta = oferte.get(rowIndex);
        switch(columnIndex){
            case ID_COL:
                return tempOferta.getId();
            case STATUS_COL:
                return tempOferta.getStatus();
            case OBJECT_COL:
                return tempOferta;
            default:
                return tempOferta.getId();
        }
    }
}
