package it.nttdata.gestionealimenti.controller;

import it.nttdata.gestionealimenti.businessLO.impl.ProductLOImpl;
import it.nttdata.gestionealimenti.model.Category;
import it.nttdata.gestionealimenti.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductLOImpl productLO;


    @PostMapping("/{categoryId}")
    public ResponseEntity<?> create(@PathVariable Long categoryId,@RequestBody Product pr){
        try{
            return new ResponseEntity<>(productLO.create(pr,categoryId), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        try{
            return new ResponseEntity<>(productLO.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingle(@PathVariable Long id){
        try{
            return new ResponseEntity<>(productLO.getSingle(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> upadte(@PathVariable Long id,@RequestBody Product pr){
        try{
            return new ResponseEntity<>(productLO.Update(id,pr), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            productLO.delete(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
