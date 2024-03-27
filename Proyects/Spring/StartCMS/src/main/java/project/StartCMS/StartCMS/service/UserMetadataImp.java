package project.StartCMS.StartCMS.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.StartCMS.StartCMS.model.UserMetadata;
import project.StartCMS.StartCMS.repository.UserMetadataRepository;

@Service
public class UserMetadataImp implements UserMetadataService {

    @Autowired
    private UserMetadataRepository repo;

    @Override
    public List<UserMetadata> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<UserMetadata> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Long id, UserMetadata userMetadata) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(UserMetadata userMetadata) {
        repo.save(userMetadata);
    }

    @Override
    public boolean existByid(Long id) {
        return repo.existsById(id);
    }

}
