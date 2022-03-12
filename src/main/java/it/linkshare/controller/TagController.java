package it.linkshare.controller;

import it.linkshare.service.TagService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

    TagService tagService;

    public TagController(TagService tagService){
        this.tagService = tagService;
    }
}
