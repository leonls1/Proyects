package project.StartCMS.StartCMS.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.StartCMS.StartCMS.model.Content;
import project.StartCMS.StartCMS.repository.ContentRepository;

@Service
public class ContentImp implements ContentService {

    @Autowired
    private ContentRepository repo;

    @Override
    public List<Content> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Content> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Long id, Content content) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Content content) {
        repo.save(content);
    }

    @Override
    public boolean existByid(Long id) {
        return repo.existsById(id);
    }

}
