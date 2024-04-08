package CMS.appIntegradora.controller.rest;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import CMS.appIntegradora.model.Category;
import CMS.appIntegradora.model.common.RepBase;
import CMS.appIntegradora.service.CategoryService;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PutMapping("addCategory")
    public ResponseEntity<RepBase> save(@RequestBody Category category) {
        service.create(category);
        return ResponseEntity.ok(new RepBase());
    }

    @PostMapping()
    public ResponseEntity<RepBase> update(@RequestBody Category category) {
        service.create(category);
        return ResponseEntity.ok(new RepBase());
    }
    
    //to try my controller
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello world";
    }
    //
    

    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> getbyId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RepBase> deleteById(@PathVariable Long id) {
      
            service.delete(id);
            return ResponseEntity.ok(new RepBase());
    }

}
