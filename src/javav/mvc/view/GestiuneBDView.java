package javav.mvc.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestiuneBDView extends JPanel {
    private JTable table;
    private JTextField valutaField, cursField, dataField;
    private JButton addButton, updateButton, deleteButton;

    public GestiuneBDView(DefaultTableModel model) {
        setLayout(new BorderLayout());


        JPanel tablePanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Gestionare:");
        tablePanel.add(label, BorderLayout.NORTH);


        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setPreferredSize(new Dimension(600,400));


        JPanel editPanel = new JPanel(new GridLayout(4, 2));
        JLabel valutaLabel = new JLabel("Valuta:");
        JLabel cursLabel = new JLabel("Curs:");
        JLabel dataLabel = new JLabel("Data Actualizare:");
        valutaField = new JTextField();
        cursField = new JTextField();
        dataField = new JTextField();
        addButton = new JButton("Adăugare");
        updateButton = new JButton("Actualizare");
        editPanel.add(valutaLabel);
        editPanel.add(valutaField);
        editPanel.add(cursLabel);
        editPanel.add(cursField);
        editPanel.add(dataLabel);
        editPanel.add(dataField);
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

    public JTextField getValutaField() {
        return valutaField;
    }

    public JTextField getCursField() {
        return cursField;
    }

    public JTextField getDataField() {
        return dataField;
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
