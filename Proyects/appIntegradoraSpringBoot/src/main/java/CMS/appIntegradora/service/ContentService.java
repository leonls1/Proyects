package CMS.appIntegradora.service;

import java.util.List;
import java.util.Optional;
import CMS.appIntegradora.model.Comment;
import CMS.appIntegradora.model.Content;

public interface ContentService {
    public List<Content> getAll();
    
    public Optional<Content> getById(Long id);
    
    public void delete(Long id);
    
    public void update(Long id, Content content);
    
    public void create(Content content);
    
    public boolean existByid(Long id);
}
