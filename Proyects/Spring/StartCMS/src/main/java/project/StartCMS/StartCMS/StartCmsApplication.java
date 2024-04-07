package project.StartCMS.StartCMS;

import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.StartCMS.StartCMS.model.Category;
import project.StartCMS.StartCMS.service.CategoryImp;
import project.StartCMS.StartCMS.service.CategoryService;

@SpringBootApplication
public class StartCmsApplication {
    
    
    private static CategoryService service = new CategoryImp();

    public static void main(String[] args) {
        //SpringApplication.run(StartCmsApplication.class, args);
        SpringApplication.run(StartCmsApplication.class, args);

        
        Category cate = new Category();
        cate.setDate(LocalDate.now());
        cate.setName("categoria1");
        cate.setDescription("una nueva categoria");
        
        service.create(cate);

        
    }

}
