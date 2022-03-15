package it.linkshare.dao;

import javax.persistence.*;
import java.util.List;

@Entity
public class LinkDAO {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToOne(cascade = {CascadeType.ALL})
    private UrlDAO urlDAO;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<TagDAO> tagDAOList;

    public LinkDAO(){}

    public LinkDAO(String title, String description, UrlDAO urlDAO, List<TagDAO> tagDAOList) {
        this.title = title;
        this.description = description;
        this.urlDAO = urlDAO;
        this.tagDAOList = tagDAOList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UrlDAO getUrlDAO() {
        return urlDAO;
    }

    public void setUrlDAO(UrlDAO urlDAO) {
        this.urlDAO = urlDAO;
    }

    public List<TagDAO> getTagDAOList() {
        return tagDAOList;
    }

    public void setTagDAOList(List<TagDAO> tagDAOList) {
        this.tagDAOList = tagDAOList;
    }
}
