package it.linkshare.service;

import it.linkshare.repository.entity.LinkEntity;
import it.linkshare.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {

    LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    public List<LinkEntity> getAllLink(){
        return linkRepository.findAll();
    }

    public LinkEntity getLinkById(Long id){
        return linkRepository.getById(id);
    }

    public LinkEntity addNewLink(LinkEntity link){
        return linkRepository.save(link);
    }

    public LinkEntity updateLink(LinkEntity link){
        return linkRepository.save(link);
    }

    public void deleteLink(LinkEntity link){
        linkRepository.delete(link);
    }
}
