import javax.swing.table.AbstractTableModel;
import java.util.List;

public class VizionareTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private static final int ID_COL = 0;
    private static final int DATA_COL = 1;
    private static final int ORA_COL = 2;
    private static final int PROPRIETATE_ID_COL = 3;
    private static final int CLIENT_ID_COL = 4;
    private static final int INCHIRIERE_COL = 5;
    public static final int OBJECT_COL = -1;
    private String[] columnNames = {"nr vizionare", "data", "ora", "nr proprietate", "nr client", "inchiriere"};
    private List<Vizionare> vizionari;
    public VizionareTableModel(List <Vizionare> viz)
    {
        vizionari = viz;
    }
    @Override
    public int getRowCount() {
        return vizionari.size();
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
        Vizionare tempVizionare = vizionari.get(rowIndex);
        switch(columnIndex){
            case ID_COL:
                return tempVizionare.getId();
            case DATA_COL:
                return tempVizionare.getData_vizionarii();
            case ORA_COL:
                return tempVizionare.getOra_vizionarii();
            case PROPRIETATE_ID_COL:
                return tempVizionare.getProprietate_id();
            case CLIENT_ID_COL:
                return tempVizionare.getClient_id();
            case INCHIRIERE_COL:
                return tempVizionare.getInchiriere();
            case OBJECT_COL:
                return tempVizionare;
            default:
                return tempVizionare.getId();
        }
    }
}
