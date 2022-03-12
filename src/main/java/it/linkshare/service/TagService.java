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

    public Tag addNewTag(Tag tag){
        return tagRepository.save(tag);
    }

    public Tag updateTag(Tag tag, Long id){
        return tagRepository.findById(id)
                .map(t -> {
                    t.setName(tag.getName());
                    t.setNsfw(tag.getNsfw());
                    return tagRepository.save(t);
                })
                .orElseGet(() -> {
                    tag.setId(id);
                    return tagRepository.save(tag);
                });
    }

    public void deleteTag(Long id){
        tagRepository.deleteById(id);
    }

}
