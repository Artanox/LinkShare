package it.linkshare.controller.dto;

import javax.validation.constraints.NotNull;

public class TagCreationRequest {

    private final String name;

    @NotNull
    private final Boolean nsfw;

    @NotNull
    private final DomainName domain;

    public TagCreationRequest(String name, Boolean nsfw, DomainName domain) {
        this.name = name;
        this.nsfw = nsfw;
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public Boolean getNsfw() {
        return nsfw;
    }

    static enum DomainName {
        MEGA, DRIVE
    }
}
