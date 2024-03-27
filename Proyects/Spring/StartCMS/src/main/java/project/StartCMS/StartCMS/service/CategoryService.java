package project.StartCMS.StartCMS.service;

import java.util.List;
import java.util.Optional;
import project.StartCMS.StartCMS.model.Category;

public interface CategoryService {
    public List<Category> getAll();
    
    public Optional<Category> getById(Long id);
    
    public void delete(Long id);
    
    public void update(Long id, Category category);
    
    public void create(Category category);
    
    public boolean existByid(Long id);
 }
