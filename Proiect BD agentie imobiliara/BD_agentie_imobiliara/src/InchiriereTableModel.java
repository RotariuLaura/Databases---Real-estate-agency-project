import javax.swing.table.AbstractTableModel;
import java.util.List;

public class InchiriereTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private static final int ID_COL = 0;
    private static final int DATA_INCHIRIERII_COL = 1;
    private static final int DATA_ELIBERARII_COL = 2;
    private static final int PROPRIETATE_ID_COL = 3;
    private static final int CLIENT_ID_COL = 4;

    public static final int OBJECT_COL = -1;
    private String[] columnNames = {"nr inchiriere", "data inchiriere", "data eliberare", "nr proprietate", "nr client"};
    private List<Inchiriere> inchirieri;
    public InchiriereTableModel(List <Inchiriere> inch)
    {
        inchirieri = inch;
    }
    @Override
    public int getRowCount() {
        return inchirieri.size();
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
        Inchiriere tempInchiriere = inchirieri.get(rowIndex);
        switch(columnIndex){
            case ID_COL:
                return tempInchiriere.getId();
            case DATA_INCHIRIERII_COL:
                return tempInchiriere.getData_inchirierii();
            case DATA_ELIBERARII_COL:
                return tempInchiriere.getData_eliberarii();
            case PROPRIETATE_ID_COL:
                return tempInchiriere.getProprietate_id();
            case CLIENT_ID_COL:
                return tempInchiriere.getClient_id();
            case OBJECT_COL:
                return tempInchiriere;
            default:
                return tempInchiriere.getId();
        }
    }
}
