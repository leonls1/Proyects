package project.StartCMS.StartCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.StartCMS.StartCMS.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
