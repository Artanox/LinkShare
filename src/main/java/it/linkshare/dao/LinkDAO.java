package it.linkshare.dao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class LinkDAO {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private BigDecimal id;

    @ManyToOne
    private UrlDAO url;

    private String title;
    private String description;

    @OneToMany(targetEntity= TagDAO.class)
    private List<TagDAO> tagList;

    public LinkDAO(
//            UrlEntity url,
            String title, String description) {
//        this.url = url;
        this.title = title;
        this.description = description;
//        this.tagList = tagList;
    }

    public LinkDAO() {

    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public UrlDAO getUrl() {
        return url;
    }

    public void setUrl(UrlDAO url) {
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

    public List<TagDAO> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagDAO> tagList) {
        this.tagList = tagList;
    }
}
