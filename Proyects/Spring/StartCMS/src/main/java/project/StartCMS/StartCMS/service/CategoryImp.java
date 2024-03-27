package project.StartCMS.StartCMS.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.StartCMS.StartCMS.model.Category;
import project.StartCMS.StartCMS.repository.CategoryRepository;

@Service
public class CategoryImp implements CategoryService{
    
    @Autowired
    private CategoryRepository repo;

    @Override
    public List<Category> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Category> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Long id, Category category) {
        Category oldCategory;
        oldCategory = repo.findById(id).orElse(null);
        
        if(category != null){
            oldCategory.setCategoryUpper(category.getCategoryUpper());
            oldCategory.setDate(category.getDate());
            oldCategory.setDescription(category.getDescription());
            oldCategory.setName(category.getName());
            oldCategory.setPosts(category.getPosts());
            
            repo.save(oldCategory);
        }else{
            System.out.println("Doesn't exist the category with that id:" + id);
        }
        
    
    }

    @Override
    public void create(Category category) {
       repo.save(category);
    }

    @Override
    public boolean existByid(Long id) {
        return repo.existsById(id);    
    }

}
