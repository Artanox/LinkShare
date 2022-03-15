package it.linkshare.dao.controller;

import it.linkshare.dto.UrlRequestDTO;
import it.linkshare.dto.UrlResponseDTO;
import it.linkshare.service.UrlService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/urls")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService = urlService;
    }

    @GetMapping("/{id}")
    public UrlResponseDTO get(@PathVariable @NonNull Long id){
        return urlService.getById(id);
    }

    @GetMapping()
    public List<UrlResponseDTO> getAll(){
        return urlService.getAll();
    }

    @PostMapping()
    UrlResponseDTO add(@RequestBody UrlRequestDTO crudRequestDTO) {
        return urlService.addNew(crudRequestDTO);
    }

    @PutMapping("/{id}")
    UrlResponseDTO update(@RequestBody UrlRequestDTO crudRequestDTO, @PathVariable @NonNull Long id) {
        return urlService.update(crudRequestDTO, id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable @NonNull Long id) {
        urlService.delete(id);
    }

}
