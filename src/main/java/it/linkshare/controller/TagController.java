package it.linkshare.controller;

import it.linkshare.dto.TagRequestDTO;
import it.linkshare.dto.TagResponseDTO;
import it.linkshare.service.TagService;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    @GetMapping("/{id}")
    public TagResponseDTO get(@PathVariable @NonNull Long id){
        return tagService.getTagById(id);
    }

    @GetMapping()
    public List<TagResponseDTO> getAll(){
        return tagService.getAllTags();
    }

    @PostMapping()
    TagResponseDTO add(@RequestBody TagRequestDTO tagRequestDTO) {
        return tagService.addNewTag(tagRequestDTO);
    }

    @PutMapping("/{id}")
    TagResponseDTO update(@RequestBody TagRequestDTO tagRequestDTO, @PathVariable @NonNull Long id) {
        return tagService.updateTag(tagRequestDTO, id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable @NonNull Long id) {
        tagService.deleteTag(id);
    }

}
