package javav.mvc.DAO.Tranzactii;

import javav.mvc.DAO.Tranzactii.TranzactiiDAO;
import javav.mvc.model.TranzactiiModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TranzactiiDAOImpl implements TranzactiiDAO {
    private Connection connection;

    public TranzactiiDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public TranzactiiModel getById(int id) {
        TranzactiiModel tranzactie = null;
        String query = "SELECT * FROM Tranzactii WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                tranzactie = new TranzactiiModel();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tranzactie;
    }

    @Override
    public void insert(TranzactiiModel tranzactie) {
        String query = "INSERT INTO Tranzactii (DataTranzactie, ValutaVanduta, ValutaCumparata, SumaVanduta, SumaCumparata, Comision) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {


            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TranzactiiModel tranzactie) {
        String query = "UPDATE Tranzactii SET DataTranzactie = ?, ValutaVanduta = ?, ValutaCumparata = ?, " +
                "SumaVanduta = ?, SumaCumparata = ?, Comision = ? WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {


            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Tranzactii WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
