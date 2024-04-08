package CMS.appIntegradora.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import CMS.appIntegradora.model.Group;
import CMS.appIntegradora.repository.GroupRepository;

@Service
public class GroupImp implements GroupService {

    @Autowired
    private GroupRepository repo;

    @Override
    public List<Group> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Group> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Long id, Group group) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Group group) {
        repo.save(group);
    }

    @Override
    public boolean existByid(Long id) {
        return repo.existsById(id);
    }

}
