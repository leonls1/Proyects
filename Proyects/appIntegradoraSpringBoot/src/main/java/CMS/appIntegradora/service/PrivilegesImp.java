package CMS.appIntegradora.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import CMS.appIntegradora.model.Privileges;
import CMS.appIntegradora.repository.PrivilegesRepository;

@Service
public class PrivilegesImp implements PrivilegesService {

    @Autowired
    private PrivilegesRepository repo;

    @Override
    public List<Privileges> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Privileges> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Long id, Privileges privileges) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Privileges privileges) {
        repo.save(privileges);
    }

    @Override
    public boolean existByid(Long id) {
        return repo.existsById(id);
    }
}
