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

    public Tag getTagById(Long id){
        return tagRepository.getById(id);
    }

    public List<Tag> getAllTag(){
        return tagRepository.findAll();
    }
    /*
    public Tag addNewTag(Tag tag){
        return tagRepository.save(tag);
    }

    public Tag updateTag(Tag tag, Long id){

        return tagRepository.save(tag);
    }

    public void deleteTagById(Long id){
        tagRepository.delete(tagRepository.getById(id));
    }

    public void deleteTag(Tag tag){
        tagRepository.delete(tag);
    }*/
}
