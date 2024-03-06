package javav.mvc.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TranzactiiView extends JPanel {
    private JTable table;
    private JTextField dataField, valutaVandutaField, valutaCumparataField, sumaVandutaField, sumaCumparataField, comisionField;
    private JButton addButton, updateButton, deleteButton;

    public TranzactiiView(DefaultTableModel model) {
        setLayout(new BorderLayout());

        JPanel tablePanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Gestionare Tranzactii:");
        tablePanel.add(label, BorderLayout.NORTH);
        tablePanel.setPreferredSize(new Dimension(800,300));


        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setPreferredSize(new Dimension(600, 300));

        JPanel editPanel = new JPanel(new GridLayout(7, 2));
        JLabel dataLabel = new JLabel("Data Tranzactie:");
        JLabel valutaVandutaLabel = new JLabel("Valuta Vanduta:");
        JLabel valutaCumparataLabel = new JLabel("Valuta Cumparata:");
        JLabel sumaVandutaLabel = new JLabel("Suma Vanduta:");
        JLabel sumaCumparataLabel = new JLabel("Suma Cumparata:");
        JLabel comisionLabel = new JLabel("Comision:");
        dataField = new JTextField();
        valutaVandutaField = new JTextField();
        valutaCumparataField = new JTextField();
        sumaVandutaField = new JTextField();
        sumaCumparataField = new JTextField();
        comisionField = new JTextField();
        addButton = new JButton("Adăugare");
        updateButton = new JButton("Actualizare");
        editPanel.add(dataLabel);
        editPanel.add(dataField);
        editPanel.add(valutaVandutaLabel);
        editPanel.add(valutaVandutaField);
        editPanel.add(valutaCumparataLabel);
        editPanel.add(valutaCumparataField);
        editPanel.add(sumaVandutaLabel);
        editPanel.add(sumaVandutaField);
        editPanel.add(sumaCumparataLabel);
        editPanel.add(sumaCumparataField);
        editPanel.add(comisionLabel);
        editPanel.add(comisionField);
        editPanel.add(addButton);
        editPanel.add(updateButton);

        JPanel actionPanel = new JPanel(new FlowLayout());
        deleteButton = new JButton("Ștergere");
        actionPanel.add(deleteButton);

        add(tablePanel, BorderLayout.CENTER);
        add(editPanel, BorderLayout.NORTH);
        add(actionPanel, BorderLayout.SOUTH);
    }

    public JTable getTable() {
        return table;
    }

    public JTextField getDataField() {
        return dataField;
    }

    public JTextField getValutaVandutaField() {
        return valutaVandutaField;
    }

    public JTextField getValutaCumparataField() {
        return valutaCumparataField;
    }

    public JTextField getSumaVandutaField() {
        return sumaVandutaField;
    }

    public JTextField getSumaCumparataField() {
        return sumaCumparataField;
    }

    public JTextField getComisionField() {
        return comisionField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
}
