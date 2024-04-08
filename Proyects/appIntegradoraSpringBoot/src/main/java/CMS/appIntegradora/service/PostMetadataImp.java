package CMS.appIntegradora.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import CMS.appIntegradora.model.PostMetadata;
import CMS.appIntegradora.repository.PostMetadataRepository;

@Service
public class PostMetadataImp implements PostMetadataService {

    @Autowired
    private PostMetadataRepository repo;

    @Override
    public List<PostMetadata> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<PostMetadata> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Long id, PostMetadata pm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(PostMetadata postMetadata) {
        repo.save(postMetadata);
    }

    @Override
    public boolean existByid(Long id) {
        return repo.existsById(id);
    }

}
