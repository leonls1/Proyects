package project.StartCMS.StartCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.StartCMS.StartCMS.model.Privileges;

@Repository
public interface PrivilegesRepository extends JpaRepository<Privileges, Long>{

}
