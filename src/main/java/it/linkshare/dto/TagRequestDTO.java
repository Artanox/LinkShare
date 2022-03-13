package it.linkshare.dto;

public class TagRequestDTO {

    private final String name;
    private final Boolean nsfw;

    public TagRequestDTO(String name, Boolean nsfw) {
        this.name = name;
        this.nsfw = nsfw;
    }

    public String getName() {
        return name;
    }

    public Boolean getNsfw() {
        return nsfw;
    }
}
