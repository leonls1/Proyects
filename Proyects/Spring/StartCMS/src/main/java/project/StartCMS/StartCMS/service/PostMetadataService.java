package project.StartCMS.StartCMS.service;

import java.util.List;
import java.util.Optional;
import project.StartCMS.StartCMS.model.Comment;
import project.StartCMS.StartCMS.model.PostMetadata;

public interface PostMetadataService {
    public List<PostMetadata> getAll();
    
    public Optional<PostMetadata> getById(Long id);
    
    public void delete(Long id);
    
    public void update(Long id, PostMetadata pm);
    
    public void create(PostMetadata postMetadata);
    
    public boolean existByid(Long id);
}
