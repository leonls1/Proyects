package CMS.appIntegradora.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import CMS.appIntegradora.service.PostService;

@RestController
@RequestMapping("api/v1/post")
public class PostController {

    @Autowired
    private PostService service;
}
