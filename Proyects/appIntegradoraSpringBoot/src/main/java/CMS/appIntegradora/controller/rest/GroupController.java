package CMS.appIntegradora.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import CMS.appIntegradora.service.GroupService;

@RequestMapping("api/v1/group")
@RestController
public class GroupController {

    @Autowired
    private GroupService service;
    
}
