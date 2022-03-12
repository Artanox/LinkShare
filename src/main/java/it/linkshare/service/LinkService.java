package it.linkshare.service;

import it.linkshare.model.Link;
import it.linkshare.model.Url;
import it.linkshare.repository.LinkRepository;
import it.linkshare.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {

    LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    public List<Link> getAllLink(){
        return linkRepository.findAll();
    }

    public Link getLinkById(Long id){
        return linkRepository.getById(id);
    }

    public Link addNewLink(Link link){
        return linkRepository.save(link);
    }

    public Link updateLink(Link link){
        return linkRepository.save(link);
    }

    public void deleteLink(Link link){
        linkRepository.delete(link);
    }
}
