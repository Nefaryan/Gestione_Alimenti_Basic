package it.nttdata.gestionealimenti.businessLO.impl;


import it.nttdata.gestionealimenti.businessLO.interfaces.ProductLO;
import it.nttdata.gestionealimenti.model.Category;
import it.nttdata.gestionealimenti.model.Product;
import it.nttdata.gestionealimenti.repository.CategoryRepository;
import it.nttdata.gestionealimenti.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLOImpl implements ProductLO {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public Product create(Product pr,Long categoryId) {
      Category c = categoryRepository.findById(categoryId).get();
      Product pr1 = new Product();
      pr1.setName(pr.getName());
      pr1.setDescription(pr.getDescription());
      pr1.setCategory(c);
      pr1.setPrice(pr.getPrice());
      pr1.setExpiryDate(pr.getExpiryDate());

      return productRepository.save(pr1);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getSingle(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product Update(Long id, Product pr) {
        Product pr1 = productRepository.findById(id).get();
        if(productRepository.existsById(id)){
            pr1.setName(pr.getName());
            pr1.setDescription(pr.getDescription());
            pr1.setPrice(pr.getPrice());
            pr1.setCategory(pr1.getCategory());
            pr1.setExpiryDate(pr.getExpiryDate());
            productRepository.saveAndFlush(pr1);
        }
        return pr1;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);

    }
}
