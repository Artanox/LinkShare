package it.linkshare.controller;

import it.linkshare.dto.LinkRequestDTO;
import it.linkshare.dto.LinkResponseDTO;
import it.linkshare.service.LinkService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/links")
public class LinkController{

    private final LinkService linkService;

    public LinkController(LinkService linkService){
        this.linkService = linkService;
    }

    @GetMapping("/{id}")
    public LinkResponseDTO get(@PathVariable @NonNull Long id){
        return linkService.getById(id);
    }

    @GetMapping()
    public List<LinkResponseDTO> getAll(){
        return linkService.getAll();
    }

    @PostMapping()
    public LinkResponseDTO add(@RequestBody LinkRequestDTO linkRequestDTO) {
        return linkService.addNew(linkRequestDTO);
    }

    @PutMapping("/{id}")
    public LinkResponseDTO update(@RequestBody LinkRequestDTO linkRequestDTO, @PathVariable @NonNull Long id) {
        return linkService.update(linkRequestDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @NonNull Long id) {
        linkService.delete(id);
    }

}
