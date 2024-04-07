package project.StartCMS.StartCMS.repository;


import java.time.LocalDate;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.StartCMS.StartCMS.model.Category;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {AppConfig.class})
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repo;
    
    @Test
    public void testExistByName(){
        Category cate = new Category();
        cate.setDate(LocalDate.now());
        cate.setName("categoria1");
        cate.setDescription("una nueva categoria");
        
        repo.save(cate);
        
       // Assertions.assertThat(repo.existByName("categoria1")).isTrue(); 
    }
}
