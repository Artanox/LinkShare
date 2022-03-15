package it.linkshare.service;

import it.linkshare.dao.UrlDAO;
import it.linkshare.dto.UrlRequestDTO;
import it.linkshare.dto.UrlResponseDTO;
import it.linkshare.mapper.UrlMapper;
import it.linkshare.repository.UrlRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }

    public UrlResponseDTO getById(Long id) {
        return urlRepository.findById(id)
                .map(UrlMapper::mapToResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<UrlResponseDTO> getAll() {
        return urlRepository.findAll()
                .stream()
                .map(UrlMapper::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public UrlResponseDTO addNew(UrlRequestDTO urlRequestDTO) {
        return saveDaoThenMapResponseDto(
                UrlMapper.mapToDAO(urlRequestDTO));
    }

    public UrlResponseDTO update(UrlRequestDTO urlRequestDTO, Long id) {
        return saveDaoThenMapResponseDto(
                urlRepository.findById(id)
                        .map(u -> UrlMapper.mapToDAO(u, urlRequestDTO))
                        .orElse(UrlMapper.mapToDAO(id, urlRequestDTO)));
    }

    public void delete(Long id) {
        urlRepository.delete(urlRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    public UrlResponseDTO saveDaoThenMapResponseDto(UrlDAO urlDAO) {
        return UrlMapper.mapToResponseDTO(
                urlRepository.save(urlDAO));
    }
}
