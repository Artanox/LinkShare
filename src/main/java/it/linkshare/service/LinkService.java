package it.linkshare.service;


import it.linkshare.dao.LinkDAO;
import it.linkshare.dto.LinkRequestDTO;
import it.linkshare.dto.LinkResponseDTO;
import it.linkshare.mapper.LinkMapper;
import it.linkshare.repository.LinkRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkService{

    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

   @Transactional
    public LinkResponseDTO getById(Long id) {
        return linkRepository.findById(id)
                .map(LinkMapper::mapToResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public List<LinkResponseDTO> getAll() {
        return linkRepository.findAll()
                .stream()
                .map(LinkMapper::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public LinkResponseDTO addNew(LinkRequestDTO linkRequestDTO) {
        return saveDaoThenMapResponseDto(
                LinkMapper.mapToDAO(linkRequestDTO));
    }

    public LinkResponseDTO update(LinkRequestDTO linkRequestDTO, Long id) {
        return saveDaoThenMapResponseDto(
                linkRepository.findById(id)
                        .map(l -> LinkMapper.mapToDAO(l, linkRequestDTO))
                        .orElse(LinkMapper.mapToDAO(id, linkRequestDTO))
        );
    }

    public void delete(Long id) {
        linkRepository.delete(linkRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    public LinkResponseDTO saveDaoThenMapResponseDto(LinkDAO linkDAO) {
        return LinkMapper.mapToResponseDTO(
                linkRepository.save(linkDAO));
    }
}


