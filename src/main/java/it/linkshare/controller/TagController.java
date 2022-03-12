package it.linkshare.controller;

import it.linkshare.model.Tag;
import it.linkshare.service.TagService;
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
    public Tag get(@PathVariable Long id){
        return tagService.getTagById(id);
    }

    @GetMapping("/tags")
    public List<Tag> getAll(){
        return tagService.getAllTag();
    }

    @PostMapping("/tag")
    Tag add(@RequestBody Tag tag) {
        return tagService.addNewTag(tag);
    }

    @PutMapping("/tag/{id}")
    Tag update(@RequestBody Tag tag, @PathVariable Long id) {
        return tagService.updateTag(tag, id);
    }

    @DeleteMapping("/tag/{id}")
    void delete(@PathVariable Long id) {
        tagService.deleteTag(id);
    }

}
