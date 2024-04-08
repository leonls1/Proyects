package CMS.appIntegradora.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import CMS.appIntegradora.service.PostMetadataService;

@RestController
@RequestMapping("api/v1/postMetadata")
public class PostMetadataController {

    @Autowired
    private PostMetadataService service;
}
