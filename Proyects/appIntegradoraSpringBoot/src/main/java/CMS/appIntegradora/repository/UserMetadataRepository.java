package CMS.appIntegradora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CMS.appIntegradora.model.UserMetadata;

@Repository
public interface UserMetadataRepository extends JpaRepository<UserMetadata, Long>{

}
