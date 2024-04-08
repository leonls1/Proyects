package CMS.appIntegradora.service;

import java.util.List;
import java.util.Optional;
import CMS.appIntegradora.model.Comment;
import CMS.appIntegradora.model.PostMetadata;

public interface PostMetadataService {
    public List<PostMetadata> getAll();
    
    public Optional<PostMetadata> getById(Long id);
    
    public void delete(Long id);
    
    public void update(Long id, PostMetadata pm);
    
    public void create(PostMetadata postMetadata);
    
    public boolean existByid(Long id);
}
