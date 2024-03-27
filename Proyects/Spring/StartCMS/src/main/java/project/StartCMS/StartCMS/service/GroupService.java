package project.StartCMS.StartCMS.service;

import java.util.List;
import project.StartCMS.StartCMS.model.Group;

public interface GroupService {
    public List<Group> getAll();
    
    public Group getById(Long id);
    
    public void delete(Long id);
    
    public void update(Long id, Group group);
    
    public void create(Group group);
    
    public boolean existByid(Long id);
}
