package project.StartCMS.StartCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.StartCMS.StartCMS.model.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long>{

}
