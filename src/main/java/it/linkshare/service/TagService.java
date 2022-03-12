package it.linkshare.service;

import it.linkshare.controller.dto.Tag;
import it.linkshare.controller.dto.TagCreationRequest;
import it.linkshare.repository.TagRepository;
import it.linkshare.repository.entity.TagEntity;
import it.linkshare.service.mapper.TagMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag getTagById(Long id) {
        return tagRepository.findFirstById(id)
                .map(TagMapper::mapToRest)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TagEntity> getAllTag() {
        return tagRepository.findAll();
    }

    public Tag addNewTag(TagCreationRequest request) {
        return TagMapper.mapToRest(tagRepository.save(TagMapper.mapToEntity(request)));
    }

    public TagEntity updateTag(TagEntity tag, Long id) {
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

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

}
