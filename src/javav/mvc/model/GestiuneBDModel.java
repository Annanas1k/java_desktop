package javav.mvc.model;

import javax.swing.table.DefaultTableModel;

public class GestiuneBDModel extends DefaultTableModel {
    public GestiuneBDModel() {
        super();
        addColumn("ID");
        addColumn("Valuta");
        addColumn("Curs");
        addColumn("Data Actualizare");
    }
}
