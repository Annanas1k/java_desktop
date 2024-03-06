package javav.mvc.controller;

import javav.mvc.model.ConnectClass;
import javav.mvc.model.GestiuneBDModel;
import javav.mvc.view.GestiuneBDView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestiuneBDController {
    private GestiuneBDModel model;
    private GestiuneBDView view;

    public GestiuneBDController(GestiuneBDModel model, GestiuneBDView view) {
        this.model = model;
        this.view = view;


        refreshTable();


        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valuta = view.getValutaField().getText();
                double curs = Double.parseDouble(view.getCursField().getText());
                String dataActualizare = view.getDataField().getText();
                addRecord(valuta, curs, dataActualizare);
            }
        });


        view.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) view.getTable().getValueAt(selectedRow, 0);
                    String valuta = view.getValutaField().getText();
                    double curs = Double.parseDouble(view.getCursField().getText());
                    String dataActualizare = view.getDataField().getText();
                    updateRecord(id, valuta, curs, dataActualizare);
                }
            }
        });


        view.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) view.getTable().getValueAt(selectedRow, 0);
                    deleteRecord(id);
                }
            }
        });
    }


    private void refreshTable() {

        model.setRowCount(0);


        Connection connection = ConnectClass.getConnection();

        try {

            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery("SELECT * FROM CursValutar");


            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String valuta = resultSet.getString("Valuta");
                double curs = resultSet.getDouble("Curs");
                String dataActualizare = resultSet.getString("DataActualizare");


                model.addRow(new Object[]{id, valuta, curs, dataActualizare});
            }


            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void addRecord(String valuta, double curs, String dataActualizare) {

        Connection connection = ConnectClass.getConnection();

        try {

            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO CursValutar (Valuta, Curs, DataActualizare) VALUES ('%s', %.2f, '%s')", valuta, curs, dataActualizare);
            statement.executeUpdate(query);


            statement.close();
            connection.close();


            refreshTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void updateRecord(int id, String valuta, double curs, String dataActualizare) {

        Connection connection = ConnectClass.getConnection();

        try {

            Statement statement = connection.createStatement();
            String query = String.format("UPDATE CursValutar SET Valuta = '%s', Curs = %.2f, DataActualizare = '%s' WHERE ID = %d", valuta, curs, dataActualizare, id);
            statement.executeUpdate(query);


            statement.close();
            connection.close();


            refreshTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void deleteRecord(int id) {

        Connection connection = ConnectClass.getConnection();

        try {

            Statement statement = connection.createStatement();
            String query = String.format("DELETE FROM CursValutar WHERE ID = %d", id);
            statement.executeUpdate(query);


            statement.close();
            connection.close();


            refreshTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
