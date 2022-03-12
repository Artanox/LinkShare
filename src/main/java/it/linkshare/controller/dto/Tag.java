package it.linkshare.controller.dto;

public class Tag {
    private final Long id;
    private final String name;
    private final Boolean nsfw;

    public Tag(Long id, String name, Boolean nsfw) {
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
