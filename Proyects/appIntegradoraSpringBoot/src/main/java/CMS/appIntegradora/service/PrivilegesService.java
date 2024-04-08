package CMS.appIntegradora.service;

import java.util.List;
import java.util.Optional;
import CMS.appIntegradora.model.Comment;
import CMS.appIntegradora.model.Privileges;

public interface PrivilegesService {
    public List<Privileges> getAll();
    
    public Optional<Privileges> getById(Long id);
    
    public void delete(Long id);
    
    public void update(Long id, Privileges privileges);
    
    public void create(Privileges privileges);
    
    public boolean existByid(Long id);
}
