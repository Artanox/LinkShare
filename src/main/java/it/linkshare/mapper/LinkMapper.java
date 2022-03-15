package it.linkshare.mapper;

import it.linkshare.dao.LinkDAO;
import it.linkshare.dto.LinkRequestDTO;
import it.linkshare.dto.LinkResponseDTO;

import java.util.stream.Collectors;

public class LinkMapper {

    public static LinkResponseDTO mapToResponseDTO(LinkDAO linkDAO) {
        return new LinkResponseDTO(
                linkDAO.getId(),
                linkDAO.getTitle(),
                linkDAO.getDescription(),
                UrlMapper.mapToResponseDTO(linkDAO.getUrlDAO()),
                linkDAO.getTagDAOList()
                        .stream()
                        .map(TagMapper::mapToResponseDTO)
                        .collect(Collectors.toList()));
    }

    public static LinkDAO mapToDAO(LinkRequestDTO linkRequestDTO) {
        return new LinkDAO(
                linkRequestDTO.getTitle(),
                linkRequestDTO.getDescription(),
                UrlMapper.mapToDAO(linkRequestDTO.getUrlRequestDTO()),
                linkRequestDTO.getTagRequestDTOList()
                        .stream()
                        .map(TagMapper::mapToDAO)
                        .collect(Collectors.toList()));
    }

    public static LinkDAO mapToDAO(LinkDAO linkDAO, LinkRequestDTO linkRequestDTO) {
        linkDAO.setTitle(linkRequestDTO.getTitle());
        linkDAO.setDescription(linkRequestDTO.getDescription());
        linkDAO.setUrlDAO(UrlMapper.mapToDAO(linkRequestDTO.getUrlRequestDTO()));
        linkDAO.setTagDAOList(
                linkRequestDTO.getTagRequestDTOList()
                        .stream()
                        .map(TagMapper::mapToDAO)
                        .collect(Collectors.toList()));
        return linkDAO;
    }

    public static LinkDAO mapToDAO(Long id, LinkRequestDTO linkRequestDTO){
        LinkDAO linkDAO = mapToDAO(linkRequestDTO);
        linkDAO.setId(id);
        return linkDAO;
    }

}
