package it.linkshare.dto;

import java.util.List;

public class LinkResponseDTO {
    private final Long id;
    private final String title;
    private final String description;
    private final UrlResponseDTO urlResponseDTO;
    private final List<TagResponseDTO> tagResponseDTOList;

    public LinkResponseDTO(Long id, String title, String description, UrlResponseDTO urlResponseDTO, List<TagResponseDTO> tagResponseDTOList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.urlResponseDTO = urlResponseDTO;
        this.tagResponseDTOList = tagResponseDTOList;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public UrlResponseDTO getUrlResponseDTO() {
        return urlResponseDTO;
    }

    public List<TagResponseDTO> getTagResponseDTOList() {
        return tagResponseDTOList;
    }
}
