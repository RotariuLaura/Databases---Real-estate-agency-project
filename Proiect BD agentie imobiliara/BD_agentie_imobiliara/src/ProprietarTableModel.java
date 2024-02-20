import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProprietarTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private static final int ID_COL = 0;
    private static final int NUME_COL = 1;
    private static final int PRENUME_COL = 2;
    private static final int NR_TELEFON_COL = 3;
    private static final int EMAIL_COL = 4;
    public static final int OBJECT_COL = -1;
    private String[] columnNames = {"nr proprietar", "nume", "prenume", "nr_telefon", "email"};
    private List<Proprietar> proprietari;
    public ProprietarTableModel(List <Proprietar> theProprietari)
    {
        proprietari = theProprietari;
    }
    @Override
    public int getRowCount() {
        return proprietari.size();
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
        Proprietar tempProprietar = proprietari.get(rowIndex);
        switch(columnIndex){
            case ID_COL:
                return tempProprietar.getId();
            case NUME_COL:
                return tempProprietar.getNume();
            case PRENUME_COL:
                return tempProprietar.getPrenume();
            case NR_TELEFON_COL:
                return tempProprietar.getNr_telefon();
            case EMAIL_COL:
                return tempProprietar.getEmail();
            case OBJECT_COL:
                return tempProprietar;
            default:
                return tempProprietar.getNume();
        }
    }
}
