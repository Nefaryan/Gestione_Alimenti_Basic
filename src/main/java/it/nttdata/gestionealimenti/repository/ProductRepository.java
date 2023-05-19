package it.nttdata.gestionealimenti.repository;

import it.nttdata.gestionealimenti.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}