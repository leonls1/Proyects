package project.StartCMS.StartCMS.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.StartCMS.StartCMS.model.Post;
import project.StartCMS.StartCMS.repository.PostRepository;

@Service
public class PostImp implements PostService {

    @Autowired
    private PostRepository repo;

    @Override
    public List<Post> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Post> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Long id, Post post) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Post post) {
        repo.save(post);
    }

    @Override
    public boolean existByid(Long id) {
        return repo.existsById(id);
    }

}
