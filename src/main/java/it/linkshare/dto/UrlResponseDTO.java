package it.linkshare.dto;

public class UrlResponseDTO {

    private final Long id;
    private final String name;
    private final TagResponseDTO tagResponseDTO;

    public UrlResponseDTO(Long id, String name, TagResponseDTO tagResponseDTO) {
        this.id = id;
        this.name = name;
        this.tagResponseDTO = tagResponseDTO;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TagResponseDTO getTagResponseDTO() {
        return tagResponseDTO;
    }
}
