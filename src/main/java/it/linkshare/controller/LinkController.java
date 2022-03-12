package it.linkshare.controller;

import it.linkshare.service.LinkService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {

    LinkService linkService;

    public LinkController(LinkService linkService){
        this.linkService = linkService;
    }
}
