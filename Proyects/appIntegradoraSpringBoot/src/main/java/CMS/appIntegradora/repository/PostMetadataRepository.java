package CMS.appIntegradora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import CMS.appIntegradora.model.PostMetadata;

@Repository
public interface PostMetadataRepository extends JpaRepository<PostMetadata, Long>{

}
