package project.StartCMS.StartCMS.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.StartCMS.StartCMS.service.GroupService;

@RequestMapping("api/v1/group")
@RestController
public class GroupController {

    @Autowired
    private GroupService service;
    
}
