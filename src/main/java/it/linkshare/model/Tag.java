package it.linkshare.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tag {

    @Id
    private Long id;
    private String name;
    private Boolean nsfw;

    public Tag(){}

    public Tag(String name, Boolean nsfw) {
        this.name = name;
        this.nsfw = nsfw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }
}
