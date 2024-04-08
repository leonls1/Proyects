package CMS.appIntegradora.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import CMS.appIntegradora.service.ContentService;

@RequestMapping("api/v1/content")
@RestController
public class ContentController {

    @Autowired
    private ContentService Service;
    
    
}
