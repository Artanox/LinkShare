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

    public TagResponseDTO getById(Long id) {
        return tagRepository.findById(id)
                .map(TagMapper::mapToResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TagResponseDTO> getAll() {
        return tagRepository.findAll()
                .stream()
                .map(TagMapper::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public TagResponseDTO addNew(TagRequestDTO tagRequestDTO) {
        return saveDaoThenMapResponseDto(
                TagMapper.mapToDAO(tagRequestDTO));
    }

    public TagResponseDTO update(TagRequestDTO tagRequestDTO, Long id) {
        return saveDaoThenMapResponseDto(
                tagRepository.findById(id)
                        .map(t -> TagMapper.mapToDAO(t, tagRequestDTO))
                        .orElse(TagMapper.mapToDAO(id, tagRequestDTO)));
    }

    public void delete(Long id) {
        tagRepository.delete(tagRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    public TagResponseDTO saveDaoThenMapResponseDto(TagDAO tagDAO) {
        return TagMapper.mapToResponseDTO(
                tagRepository.save(tagDAO));
    }

}