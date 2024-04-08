package CMS.appIntegradora.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import CMS.appIntegradora.service.CommentService;

@RequestMapping
@RestController
public class CommentController {

    @Autowired
    private CommentService service;
}
