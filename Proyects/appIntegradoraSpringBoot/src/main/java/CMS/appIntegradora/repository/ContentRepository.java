package CMS.appIntegradora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CMS.appIntegradora.model.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long>{

}
