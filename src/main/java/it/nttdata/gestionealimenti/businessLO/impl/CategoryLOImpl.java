package it.nttdata.gestionealimenti.businessLO.impl;

import it.nttdata.gestionealimenti.businessLO.interfaces.CategoryLO;
import it.nttdata.gestionealimenti.model.Category;
import it.nttdata.gestionealimenti.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryLOImpl implements CategoryLO {
@Autowired
CategoryRepository categoryRepository;
    @Override
    public Category create(Category category) {
        if(category== null)throw new NullPointerException ("Category is null");
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();

    }

    @Override
    public Category getSingle(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category Update(Long id, Category category) {
        Category c1 = new Category();
        if(categoryRepository.existsById(id)){
            c1.setId(id);
            c1.setName(category.getName());
            c1.setDescription(category.getDescription());
            categoryRepository.saveAndFlush(c1);

        }
        return c1;
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);

    }
}
