package project.StartCMS.StartCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMetadataRepository extends JpaRepository<UserMetadataRepository, Long>{

}
