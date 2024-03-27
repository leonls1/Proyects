package project.StartCMS.StartCMS.service;

import java.util.List;
import java.util.Optional;
import project.StartCMS.StartCMS.model.Comment;
import project.StartCMS.StartCMS.model.Post;

public interface PostService {
    public List<Post> getAll();
    
    public Optional<Post> getById(Long id);
    
    public void delete(Long id);
    
    public void update(Long id, Post post);
    
    public void create(Post post);
    
    public boolean existByid(Long id);
}
