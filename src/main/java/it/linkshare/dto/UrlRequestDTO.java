package it.linkshare.dto;

public class UrlRequestDTO {

    private final String name;
    private final TagRequestDTO tagRequestDTO;

    public UrlRequestDTO(String name, TagRequestDTO tagRequestDTO) {
        this.name = name;
        this.tagRequestDTO = tagRequestDTO;
    }

    public String getName() {
        return name;
    }

    public TagRequestDTO getTagRequestDTO() {
        return tagRequestDTO;
    }

}
