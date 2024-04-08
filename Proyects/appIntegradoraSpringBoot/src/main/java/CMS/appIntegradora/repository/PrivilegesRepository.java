package CMS.appIntegradora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CMS.appIntegradora.model.Privileges;

@Repository
public interface PrivilegesRepository extends JpaRepository<Privileges, Long>{

}
