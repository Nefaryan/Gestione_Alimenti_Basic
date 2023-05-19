package it.nttdata.gestionealimenti.businessLO.interfaces;

import it.nttdata.gestionealimenti.model.Category;

import java.util.List;

public interface CategoryLO {
    Category create (Category category);
    List<Category> getAll();
    Category getSingle(Long id);
    Category Update(Long id, Category category);
    void delete(Long id);
}
