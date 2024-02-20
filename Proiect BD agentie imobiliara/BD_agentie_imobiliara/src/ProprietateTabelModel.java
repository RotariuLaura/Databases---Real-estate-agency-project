import javax.swing.table.AbstractTableModel;
import java.util.List;

    public class ProprietateTabelModel extends AbstractTableModel {
        private static final long serialVersionUID = 1L;
        private static final int ID_COL = 0;
        private static final int PRET_COL = 1;
        private static final int DESCRIERE_COL = 2;
        private static final int STATUS_PROPRIETATE_COL = 3;
        private static final int AGENT_ID_COL = 4;
        private static final int PROPRIETAR_ID_COL = 5;
        private static final int TIP_PROPRIETATE_ID_COL = 6;
        private static final int ADRESA_ID_COL = 7;
        private static final int OFERTA_ID_COL = 8;

        public static final int OBJECT_COL = -1;
        private String[] columnNames = {"nr", "pret", "descriere", "status", "nr agent", "nr_proprietar", "nr tip proprietate",
                                        "nr adresa", "nr oferta"};
        private List<Proprietate> proprietati;
        public ProprietateTabelModel(List <Proprietate> theProp)
        {
             proprietati = theProp;
        }
        @Override
        public int getRowCount() {
            return proprietati.size();
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
            Proprietate tempProprietate = proprietati.get(rowIndex);
            switch(columnIndex){
                case ID_COL:
                    return tempProprietate.getId();
                case PRET_COL:
                    return tempProprietate.getPret();
                case DESCRIERE_COL:
                    return tempProprietate.getDescriere();
                case STATUS_PROPRIETATE_COL:
                    return tempProprietate.getStatus_proprietate();
                case AGENT_ID_COL:
                    return tempProprietate.getAgent_id();
                case PROPRIETAR_ID_COL:
                    return tempProprietate.getProprietar_id();
                case TIP_PROPRIETATE_ID_COL:
                    return tempProprietate.getTip_proprietate_id();
                case ADRESA_ID_COL:
                    return tempProprietate.getAdresa_adresa_id();
                case OFERTA_ID_COL:
                    return tempProprietate.getOferta_oferta_id();
                case OBJECT_COL:
                    return tempProprietate;
                default:
                    return tempProprietate.getId();
            }
        }
    }
