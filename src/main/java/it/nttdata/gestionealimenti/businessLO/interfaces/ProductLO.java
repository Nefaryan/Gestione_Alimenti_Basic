package it.nttdata.gestionealimenti.businessLO.interfaces;


import it.nttdata.gestionealimenti.model.Product;

import java.util.List;

public interface ProductLO {

    Product create (Product pr, Long categoryId);
    List<Product> getAll();
    Product getSingle(Long id);
    Product Update(Long id, Product pr);
    void delete(Long id);
}

