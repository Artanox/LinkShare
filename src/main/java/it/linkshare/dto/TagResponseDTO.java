package it.linkshare.dto;

public class TagResponseDTO {

    private final Long id;
    private final String name;
    private final Boolean nsfw;

    public TagResponseDTO(Long id, String name, Boolean nsfw) {
        this.id = id;
        this.name = name;
        this.nsfw = nsfw;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getNsfw() {
        return nsfw;
    }
}
