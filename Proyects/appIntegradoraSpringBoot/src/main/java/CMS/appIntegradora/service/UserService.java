package CMS.appIntegradora.service;

import java.util.List;
import java.util.Optional;
import CMS.appIntegradora.model.Comment;
import CMS.appIntegradora.model.User;

public interface UserService {
    public List<User> getAll();
    
    public Optional<User> getById(Long id);
    
    public void delete(Long id);
    
    public void update(Long id, User user);
    
    public void create(User user);
    
    public boolean existByid(Long id);
}
