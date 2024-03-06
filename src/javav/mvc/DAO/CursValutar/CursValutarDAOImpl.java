package javav.mvc.DAO.CursValutar;

import javav.mvc.DAO.CursValutar.CursValutarDAO;
import javav.mvc.model.GestiuneBDModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursValutarDAOImpl implements CursValutarDAO {
    private Connection connection;

    // Constructor
    public CursValutarDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<GestiuneBDModel> getAll() {
        List<GestiuneBDModel> cursValutarList = new ArrayList<>();
        String query = "SELECT * FROM CursValutar";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String valuta = resultSet.getString("Valuta");
                double curs = resultSet.getDouble("Curs");
                String dataActualizare = resultSet.getString("DataActualizare");
                GestiuneBDModel cursValutar = new GestiuneBDModel();
                cursValutarList.add(cursValutar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursValutarList;
    }

    @Override
    public GestiuneBDModel getById(int id) {
        // Crează un obiect de tipul GestiuneBDModel pentru a returna rezultatul
        GestiuneBDModel cursValutar = null;
        String query = "SELECT * FROM CursValutar WHERE ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int retrievedId = resultSet.getInt("ID");
                String valuta = resultSet.getString("Valuta");
                double curs = resultSet.getDouble("Curs");
                String dataActualizare = resultSet.getString("DataActualizare");
                cursValutar = new GestiuneBDModel();
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursValutar;
    }

    @Override
    public void insert(GestiuneBDModel cursValutar) {
        String query = "INSERT INTO CursValutar (Valuta, Curs, DataActualizare) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(GestiuneBDModel cursValutar) {
        String query = "UPDATE CursValutar SET Valuta = ?, Curs = ?, DataActualizare = ? WHERE ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM CursValutar WHERE ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
