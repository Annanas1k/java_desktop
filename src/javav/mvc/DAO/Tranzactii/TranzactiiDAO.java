package javav.mvc.DAO.Tranzactii;

import javav.mvc.model.TranzactiiModel;

public interface TranzactiiDAO {
    TranzactiiModel getById(int id);
    void insert(TranzactiiModel tranzactie);
    void update(TranzactiiModel tranzactie);
    void delete(int id);
}
