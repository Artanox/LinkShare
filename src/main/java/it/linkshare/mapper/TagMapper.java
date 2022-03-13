package it.linkshare.mapper;

import it.linkshare.dao.TagDAO;
import it.linkshare.dto.TagRequestDTO;
import it.linkshare.dto.TagResponseDTO;

public class TagMapper {

    public static TagDAO mapToDao(TagRequestDTO tagRequestDTO){
        return new TagDAO(tagRequestDTO.getName(), tagRequestDTO.getNsfw());
    }

    public static TagDAO mapToDao(Long id) {
        TagDAO tagDAO = new TagDAO();
        tagDAO.setId(id);
        return tagDAO;
    }

    public static TagDAO maptoDao(TagDAO tagDAO, TagRequestDTO tagRequestDTO) {
        tagDAO.setName(tagRequestDTO.getName());
        tagDAO.setNsfw(tagRequestDTO.getNsfw());
        return tagDAO;
    }

    public static TagResponseDTO mapToResponseDto(TagDAO tagDAO){
        return new TagResponseDTO(tagDAO.getId(), tagDAO.getName(), tagDAO.getNsfw());
    }

}
