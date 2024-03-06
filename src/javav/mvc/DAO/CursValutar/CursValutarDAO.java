package javav.mvc.DAO.CursValutar;

import javav.mvc.model.GestiuneBDModel;

import java.util.List;

public interface CursValutarDAO {
    // Metode CRUD
    List<GestiuneBDModel> getAll();
    GestiuneBDModel getById(int id);
    void insert(GestiuneBDModel cursValutar);
    void update(GestiuneBDModel cursValutar);
    void delete(int id);
}
