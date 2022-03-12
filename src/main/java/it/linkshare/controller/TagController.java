package it.linkshare.controller;

import it.linkshare.controller.dto.Tag;
import it.linkshare.controller.dto.TagCreationRequest;
import it.linkshare.repository.entity.TagEntity;
import it.linkshare.service.TagService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TagController {

    private final TagService tagService;
    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    @GetMapping("/tag/{id}")
    public TagEntity get(@PathVariable Long id){
        return tagService.getTagById(id);
    }

    @GetMapping("/tags")
    public List<TagEntity> getAll(){
        return tagService.getAllTag();
    }

    @PostMapping("/tag")
    Tag add(@Validated @RequestBody TagCreationRequest tag) {
        return tagService.addNewTag(tag);
    }

    @PutMapping("/tag/{id}")
    TagEntity update(@RequestBody TagEntity tag, @PathVariable Long id) {
        return tagService.updateTag(tag, id);
    }

    @DeleteMapping("/tag/{id}")
    void delete(@PathVariable Long id) {
        tagService.deleteTag(id);
    }

}
