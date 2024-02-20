import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TipPropTabelModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private static final int ID_COL = 0;
    private static final int DEC_COL = 1;
    private static final int NUME_COL = 2;
    private static final int NR_CAM_COL = 3;
    private static final int SUPRAFATA_COL = 4;
    public static final int OBJECT_COL = -1;
    private String[] columnNames = {"nr tip", "decomandata", "nume", "nr camere", "suprafata"};
    private List<TipProprietate> tipProp;
    public TipPropTabelModel(List <TipProprietate> tipuri)
    {
        tipProp = tipuri;
    }
    @Override
    public int getRowCount() {
        return tipProp.size();
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
        TipProprietate tempTip = tipProp.get(rowIndex);
        switch(columnIndex){
            case ID_COL:
                return tempTip.getId();
            case DEC_COL:
                return tempTip.getDecomandata();
            case NUME_COL:
                return tempTip.getNume();
            case NR_CAM_COL:
                return tempTip.getNrCamere();
            case SUPRAFATA_COL:
                return tempTip.getSuprafata();
            case OBJECT_COL:
                return tempTip;
            default:
                return tempTip.getNume();
        }
    }
}
