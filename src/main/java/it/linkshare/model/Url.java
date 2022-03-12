package it.linkshare.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Url {

    @Id
    private Long id;
    private String name;

    @ManyToOne
    private Tag domain;

    public Url(){}

    public Url(String name, Tag domain) {
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

    public Tag getDomain() {
        return domain;
    }

    public void setDomain(Tag domain) {
        this.domain = domain;
    }
}
