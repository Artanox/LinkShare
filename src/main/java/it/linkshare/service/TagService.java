package it.linkshare.service;

import it.linkshare.dao.TagDAO;
import it.linkshare.dto.TagRequestDTO;
import it.linkshare.dto.TagResponseDTO;
import it.linkshare.mapper.TagMapper;
import it.linkshare.repository.TagRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public TagResponseDTO getTagById(Long id) {
        return tagRepository.findById(id)
                .map(TagMapper::mapToResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TagResponseDTO> getAllTags() {
        return tagRepository.findAll().stream().map(TagMapper::mapToResponseDTO).collect(Collectors.toList());
    }

    public TagResponseDTO addNewTag(TagRequestDTO tagRequestDTO) {
        return TagMapper.mapToResponseDTO(tagRepository.save(TagMapper.mapToDAO(tagRequestDTO)));
    }

    public TagResponseDTO updateTag(TagRequestDTO tagRequestDTO, Long id) {
        TagDAO tagDAO = tagRepository.findById(id)
                .map(tag -> {
                    tag.setName(tagRequestDTO.getName());
                    tag.setNsfw(tagRequestDTO.getNsfw());
                    return tag;})
                .orElse(TagMapper.mapToDAO(tagRequestDTO, id));
        return TagMapper.mapToResponseDTO(tagRepository.save(tagDAO));
    }

    public void deleteTag(Long id) {
        if(tagRepository.existsById(id))
            tagRepository.deleteById(id);
    }
}
