package it.linkshare.service;

import it.linkshare.dao.LinkDAO;
import it.linkshare.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {
/*
    LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    public List<LinkDAO> getAllLink(){
        return linkRepository.findAll();
    }

    public LinkDAO getLinkById(Long id){
        return linkRepository.getById(id);
    }

    public LinkDAO addNewLink(LinkDAO link){
        return linkRepository.save(link);
    }

    public LinkDAO updateLink(LinkDAO link){
        return linkRepository.findById(id)
                .map(t -> {
                    t.setName(tag.getName());
                    t.setNsfw(tag.getNsfw());
                    return linkRepository.save(t);})
                .orElseGet(() -> {
                    tag.setId(id);
                    return linkRepository.save(tag);});
    }

    public void deleteLink(LinkDAO link){
        linkRepository.delete(link);
    }*/
}
