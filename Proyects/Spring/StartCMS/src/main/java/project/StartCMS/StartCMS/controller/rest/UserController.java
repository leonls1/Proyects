package project.StartCMS.StartCMS.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.StartCMS.StartCMS.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired 
    private UserService service;
}
