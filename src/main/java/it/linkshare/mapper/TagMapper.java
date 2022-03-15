package it.linkshare.mapper;

import it.linkshare.dao.TagDAO;
import it.linkshare.dto.TagRequestDTO;
import it.linkshare.dto.TagResponseDTO;

public class TagMapper {

    public static TagDAO mapToDAO(TagRequestDTO tagRequestDTO){
        return new TagDAO(tagRequestDTO.getName(), tagRequestDTO.getNsfw());
    }

    public static TagDAO mapToDAO(Long id, TagRequestDTO tagRequestDTO) {
        TagDAO tagDAO = mapToDAO(tagRequestDTO);
        tagDAO.setId(id);
        return tagDAO;
    }

    public static TagDAO mapToDAO(TagDAO tagDAO, TagRequestDTO tagRequestDTO) {
        tagDAO.setName(tagRequestDTO.getName());
        tagDAO.setNsfw(tagRequestDTO.getNsfw());
        return tagDAO;
    }

    public static TagResponseDTO mapToResponseDTO(TagDAO tagDAO){
        return new TagResponseDTO(tagDAO.getId(), tagDAO.getName(), tagDAO.getNsfw());
    }

}
