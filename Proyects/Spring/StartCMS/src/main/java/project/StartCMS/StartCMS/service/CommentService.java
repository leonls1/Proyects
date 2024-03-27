package project.StartCMS.StartCMS.service;

import java.util.List;
import java.util.Optional;
import project.StartCMS.StartCMS.model.Comment;

public interface CommentService {

    public List<Comment> getAll();

    public Optional<Comment> getById (Long id);

    public void delete(Long id);

    public void update(Long id, Comment comment);

    public void create(Comment comment);

    public boolean existByid(Long id);
}
