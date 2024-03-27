package project.StartCMS.StartCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.StartCMS.StartCMS.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{

}
