package it.nttdata.gestionealimenti.controller;

import it.nttdata.gestionealimenti.businessLO.impl.CategoryLOImpl;
import it.nttdata.gestionealimenti.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryLOImpl categoryLOImpl;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Category category){
        try{
            return new ResponseEntity<>(categoryLOImpl.create(category), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        try{
            return new ResponseEntity<>(categoryLOImpl.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingle(@PathVariable Long id){
        try{
            return new ResponseEntity<>(categoryLOImpl.getSingle(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Category category){
        try{
            return new ResponseEntity<>(categoryLOImpl.Update(id,category), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            categoryLOImpl.delete(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
