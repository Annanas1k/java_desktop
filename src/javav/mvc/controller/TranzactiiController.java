package javav.mvc.controller;

import javav.mvc.model.ConnectClass;
import javav.mvc.model.TranzactiiModel;
import javav.mvc.view.TranzactiiView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TranzactiiController {
    private TranzactiiView view;
    private TranzactiiModel model;

    public TranzactiiController(TranzactiiView view, TranzactiiModel model) {
        this.view = view;
        this.model = model;

        refreshTable();

        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dataTranzactie = view.getDataField().getText();
                String valutaVanduta = view.getValutaVandutaField().getText();
                String valutaCumparata = view.getValutaCumparataField().getText();
                double sumaVanduta = Double.parseDouble(view.getSumaVandutaField().getText());
                double sumaCumparata = Double.parseDouble(view.getSumaCumparataField().getText());
                double comision = Double.parseDouble(view.getComisionField().getText());
                addRecord(dataTranzactie, valutaVanduta, valutaCumparata, sumaVanduta, sumaCumparata, comision);
            }
        });

        view.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) view.getTable().getValueAt(selectedRow, 0);
                    String dataTranzactie = view.getDataField().getText();
                    String valutaVanduta = view.getValutaVandutaField().getText();
                    String valutaCumparata = view.getValutaCumparataField().getText();
                    double sumaVanduta = Double.parseDouble(view.getSumaVandutaField().getText());
                    double sumaCumparata = Double.parseDouble(view.getSumaCumparataField().getText());
                    double comision = Double.parseDouble(view.getComisionField().getText());
                    updateRecord(id, dataTranzactie, valutaVanduta, valutaCumparata, sumaVanduta, sumaCumparata, comision);
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

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Tranzactii");

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String dataTranzactie = resultSet.getString("DataTranzactie");
                String valutaVanduta = resultSet.getString("ValutaVanduta");
                String valutaCumparata = resultSet.getString("ValutaCumparata");
                double sumaVanduta = resultSet.getDouble("SumaVanduta");
                double sumaCumparata = resultSet.getDouble("SumaCumparata");
                double comision = resultSet.getDouble("Comision");

                model.addRow(new Object[]{id, dataTranzactie, valutaVanduta, valutaCumparata, sumaVanduta, sumaCumparata, comision});
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addRecord(String dataTranzactie, String valutaVanduta, String valutaCumparata, double sumaVanduta, double sumaCumparata, double comision) {
        Connection connection = ConnectClass.getConnection();

        try {
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO Tranzactii (DataTranzactie, ValutaVanduta, ValutaCumparata, SumaVanduta, SumaCumparata, Comision) " +
                    "VALUES ('%s', '%s', '%s', %.2f, %.2f, %.2f)", dataTranzactie, valutaVanduta, valutaCumparata, sumaVanduta, sumaCumparata, comision);
            statement.executeUpdate(query);

            statement.close();
            connection.close();

            refreshTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateRecord(int id, String dataTranzactie, String valutaVanduta, String valutaCumparata, double sumaVanduta, double sumaCumparata, double comision) {
        Connection connection = ConnectClass.getConnection();

        try {
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE Tranzactii SET DataTranzactie = '%s', ValutaVanduta = '%s', ValutaCumparata = '%s', " +
                            "SumaVanduta = %.2f, SumaCumparata = %.2f, Comision = %.2f WHERE ID = %d", dataTranzactie, valutaVanduta, valutaCumparata,
                    sumaVanduta, sumaCumparata, comision, id);
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
            String query = String.format("DELETE FROM Tranzactii WHERE ID = %d", id);
            statement.executeUpdate(query);

            statement.close();
            connection.close();

            refreshTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
