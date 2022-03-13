package it.linkshare.service;

import it.linkshare.dao.TagDAO;
import it.linkshare.dto.TagRequestDTO;
import it.linkshare.dto.TagResponseDTO;
import it.linkshare.mapper.TagMapper;
import it.linkshare.repository.TagRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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
                .map(TagMapper::mapToResponseDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TagResponseDTO> getAllTags() {
        return tagRepository.findAll()
                .stream()
                .map(TagMapper::mapToResponseDto)
                .collect(Collectors.toList());
    }

    public TagResponseDTO addNewTag(TagRequestDTO tagRequestDTO) {
        return saveDaoThenMapResponseDto(
                TagMapper.mapToDao(tagRequestDTO));
    }

    public TagResponseDTO updateTag(TagRequestDTO tagRequestDTO, Long id) {
        return saveDaoThenMapResponseDto(
                tagRepository.findById(id)
                        .map(t -> TagMapper.maptoDao(t, tagRequestDTO))
                        .orElse(TagMapper.mapToDao(id)));
    }

    public void deleteTag(Long id) {
        tagRepository.delete(tagRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    public TagResponseDTO saveDaoThenMapResponseDto(TagDAO tagDAO){
        return TagMapper.mapToResponseDto(
                tagRepository.save(tagDAO));
    }

}