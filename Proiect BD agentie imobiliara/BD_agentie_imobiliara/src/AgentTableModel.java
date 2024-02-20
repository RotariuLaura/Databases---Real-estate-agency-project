import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AgentTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private static final int ID_COL = 0;
    private static final int NUME_COL = 1;
    private static final int PRENUME_COL = 2;
    private static final int NR_TELEFON_COL = 3;
    private static final int EMAIL_COL = 4;
    public static final int OBJECT_COL = -1;
    private String[] columnNames = {"nr agent", "nume", "prenume", "nr_telefon", "email"};
    private List<Agent> agenti;
    public AgentTableModel(List <Agent> theAgents)
    {
        agenti = theAgents;
    }
    @Override
    public int getRowCount() {
        return agenti.size();
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
        Agent tempAgent = agenti.get(rowIndex);
        switch(columnIndex){
            case ID_COL:
                return tempAgent.getId();
            case NUME_COL:
                return tempAgent.getNume();
            case PRENUME_COL:
                return tempAgent.getPrenume();
            case NR_TELEFON_COL:
                return tempAgent.getNr_telefon();
            case EMAIL_COL:
                return tempAgent.getEmail();
            case OBJECT_COL:
                return tempAgent;
            default:
                return tempAgent.getNume();
        }
    }
}
