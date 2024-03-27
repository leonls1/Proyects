package project.StartCMS.StartCMS.service;

import java.util.List;
import java.util.Optional;
import project.StartCMS.StartCMS.model.Comment;
import project.StartCMS.StartCMS.model.Privileges;

public interface PrivilegesService {
    public List<Privileges> getAll();
    
    public Optional<Privileges> getById(Long id);
    
    public void delete(Long id);
    
    public void update(Long id, Privileges privileges);
    
    public void create(Privileges privileges);
    
    public boolean existByid(Long id);
}
