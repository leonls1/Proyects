package CMS.appIntegradora.service;

import java.util.List;
import java.util.Optional;
import CMS.appIntegradora.model.Comment;
import CMS.appIntegradora.model.Group;

public interface GroupService {
    public List<Group> getAll();
    
    public Optional<Group> getById(Long id);
    
    public void delete(Long id);
    
    public void update(Long id, Group group);
    
    public void create(Group group);
    
    public boolean existByid(Long id);
}
