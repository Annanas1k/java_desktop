package javav.mvc.model;

import javax.swing.table.DefaultTableModel;

public class TranzactiiModel extends DefaultTableModel {
    public TranzactiiModel() {
        super();
        addColumn("ID");
        addColumn("Data Tranzactie");
        addColumn("Valuta Vanduta");
        addColumn("Valuta Cumparata");
        addColumn("Suma Vanduta");
        addColumn("Suma Cumparata");
        addColumn("Comision");
    }
}
