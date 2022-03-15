package it.linkshare.mapper;

import it.linkshare.dao.UrlDAO;
import it.linkshare.dto.UrlRequestDTO;
import it.linkshare.dto.UrlResponseDTO;

public class UrlMapper {

    public static UrlResponseDTO mapToResponseDTO(UrlDAO urlDAO) {
        return new UrlResponseDTO(
                urlDAO.getId(),
                urlDAO.getName(),
                TagMapper.mapToResponseDTO(urlDAO.getTagDAO()));
    }

    public static UrlDAO mapToDAO(UrlRequestDTO urlRequestDTO) {
        return new UrlDAO(
                urlRequestDTO.getName(),
                TagMapper.mapToDAO(urlRequestDTO.getTagRequestDTO()));
    }

    public static UrlDAO mapToDAO(Long id, UrlRequestDTO urlRequestDTO) {
        UrlDAO urlDAO = mapToDAO(urlRequestDTO);
        urlDAO.setId(id);
        return urlDAO;
    }

    public static UrlDAO mapToDAO(UrlDAO urlDAO, UrlRequestDTO urlRequestDTO) {
        urlDAO.setName(urlRequestDTO.getName());
        urlDAO.setTagDAO(TagMapper.mapToDAO(urlRequestDTO.getTagRequestDTO()));
        return urlDAO;
    }

}