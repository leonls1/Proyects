package project.StartCMS.StartCMS.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.StartCMS.StartCMS.model.Category;
import project.StartCMS.StartCMS.model.common.RepBase;
import project.StartCMS.StartCMS.service.CategoryService;

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
    
    @PutMapping("addCategory")
    public ResponseEntity<RepBase> update(@RequestBody Category category) {
        service.create(category);
        return ResponseEntity.ok(new RepBase());
    }

}
