package it.linkshare.repository.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class LinkEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private BigDecimal id;

    @ManyToOne
    private UrlEntity url;

    private String title;
    private String description;

    @OneToMany(targetEntity= TagEntity.class)
    private List<TagEntity> tagList;

    public LinkEntity(
//            UrlEntity url,
            String title, String description) {
//        this.url = url;
        this.title = title;
        this.description = description;
//        this.tagList = tagList;
    }

    public LinkEntity() {

    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public UrlEntity getUrl() {
        return url;
    }

    public void setUrl(UrlEntity url) {
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

    public List<TagEntity> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagEntity> tagList) {
        this.tagList = tagList;
    }
}
