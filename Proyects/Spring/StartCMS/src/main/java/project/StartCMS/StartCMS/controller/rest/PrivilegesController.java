package project.StartCMS.StartCMS.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.StartCMS.StartCMS.service.PrivilegesService;

@RestController
@RequestMapping("api/v1/privileges")
public class PrivilegesController {
    
    @Autowired
    private PrivilegesService service;

}
