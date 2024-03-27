package project.StartCMS.StartCMS.service;

import java.util.List;
import project.StartCMS.StartCMS.model.Content;

public interface ContentService {
    public List<Content> getAll();
    
    public Content getById(Long id);
    
    public void delete(Long id);
    
    public void update(Long id, Content content);
    
    public void create(Content content);
    
    public boolean existByid(Long id);
}
