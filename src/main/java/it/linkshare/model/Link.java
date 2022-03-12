package it.linkshare.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Link {

    @Id
    private Long id;

    @ManyToOne
    private Url url;

    private String title;
    private String description;

    @OneToMany(targetEntity=Tag.class)
    private List<Tag> tagList;

    public Link(){}

    public Link(Url url, String title, String description, List<Tag> tagList) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.tagList = tagList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
