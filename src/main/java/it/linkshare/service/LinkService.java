package it.linkshare.service;

import it.linkshare.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }
}
