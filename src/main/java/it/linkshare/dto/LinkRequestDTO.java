package it.linkshare.dto;

import java.util.List;

public class LinkRequestDTO {

    private final String title;
    private final String description;
    private final UrlRequestDTO urlRequestDTO;
    private final List<TagRequestDTO> tagRequestDTOList;

    public LinkRequestDTO(String title, String description, UrlRequestDTO urlRequestDTO, List<TagRequestDTO> tagRequestDTOList) {
        this.title = title;
        this.description = description;
        this.urlRequestDTO = urlRequestDTO;
        this.tagRequestDTOList = tagRequestDTOList;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public UrlRequestDTO getUrlRequestDTO() {
        return urlRequestDTO;
    }

    public List<TagRequestDTO> getTagRequestDTOList() {
        return tagRequestDTOList;
    }

}
