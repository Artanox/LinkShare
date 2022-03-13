package it.linkshare.mapper;

import it.linkshare.dao.TagDAO;
import it.linkshare.dto.TagRequestDTO;
import it.linkshare.dto.TagResponseDTO;

public class TagMapper {

    public static TagDAO mapToDAO(TagRequestDTO tagRequestDTO){
        return new TagDAO(tagRequestDTO.getName(), tagRequestDTO.getNsfw());
    }

    public static TagDAO mapToDAO(TagRequestDTO tagRequestDTO, Long id) {
        TagDAO tagDAO = mapToDAO(tagRequestDTO);
        tagDAO.setId(id);
        return tagDAO;
    }

    public static TagResponseDTO mapToResponseDTO(TagDAO tagDAO){
        return new TagResponseDTO(tagDAO.getId(), tagDAO.getName(), tagDAO.getNsfw());
    }
}
