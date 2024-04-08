package CMS.appIntegradora.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import CMS.appIntegradora.service.UserMetadataService;

@RestController
@RequestMapping("api/v1/userMetadata")
public class UserMetadataController {
    
    @Autowired
    private UserMetadataService service;

}
