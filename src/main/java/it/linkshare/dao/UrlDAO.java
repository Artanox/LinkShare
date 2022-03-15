package it.linkshare.dao;

import javax.persistence.*;

@Entity
public class UrlDAO {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(cascade = {CascadeType.ALL})
    private TagDAO tagDAO;

    public UrlDAO(){}

    public UrlDAO(String name, TagDAO tagDao) {
        this.name = name;
        this.tagDAO = tagDao;
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

    public TagDAO getTagDAO() {
        return tagDAO;
    }

    public void setTagDAO(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }
}
