package it.linkshare.dao;

import javax.persistence.*;

@Entity
public class UrlDAO {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private TagDAO domain;

    public UrlDAO(){}

    public UrlDAO(String name
                     , TagDAO domain
    ) {
        this.name = name;
        this.domain = domain;
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

    public TagDAO getDomain() {
        return domain;
    }

    public void setDomain(TagDAO domain) {
        this.domain = domain;
    }
}
