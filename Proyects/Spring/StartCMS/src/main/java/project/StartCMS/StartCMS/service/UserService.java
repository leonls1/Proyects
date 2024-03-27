package project.StartCMS.StartCMS.service;

import java.util.List;
import project.StartCMS.StartCMS.model.User;

public interface UserService {
    public List<User> getAll();
    
    public User getById(User user);
    
    public void delete(Long id);
    
    public void update(Long id, User user);
    
    public void create(User user);
    
    public boolean existByid(Long id);
}
