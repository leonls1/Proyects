package project.StartCMS.StartCMS.service;

import java.util.List;
import project.StartCMS.StartCMS.model.UserMetadata;

public interface UserMetadataService {
    public List<UserMetadata> getAll();
    
    public UserMetadata getById(Long id);
    
    public void delete(Long id);
    
    public void update(Long id, UserMetadata userMetadata);
    
    public void create(UserMetadata userMetadata);
    
    public boolean existByid(Long id);
}
