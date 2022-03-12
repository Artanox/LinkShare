package it.linkshare.service;

import it.linkshare.model.Tag;
import it.linkshare.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    TagRepository tagRepository;

    public TagService(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAllTag(){
        return tagRepository.findAll();
    }

    public Tag getTagById(Long id){
        return tagRepository.getById(id);
    }

    public Tag addNewTag(Tag tag){
        return tagRepository.save(tag);
    }
}
