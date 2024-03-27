package project.StartCMS.StartCMS.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.StartCMS.StartCMS.model.Comment;
import project.StartCMS.StartCMS.repository.CommentRepository;

@Service
public class CommentImp implements CommentService {

    @Autowired
    private CommentRepository repo;

    @Override
    public List<Comment> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Comment> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Long id, Comment comment) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Comment comment) {
        repo.save(comment);
    }

    @Override
    public boolean existByid(Long id) {
        return repo.existsById(id);
    }

}
