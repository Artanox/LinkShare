package it.linkshare.controller;

import it.linkshare.service.UrlService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {

    UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService = urlService;
    }
}
