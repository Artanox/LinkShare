package it.linkshare.repository.entity;

import javax.persistence.*;

@Entity
public class UrlEntity {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @ManyToOne
//    private TagEntity domain;

    public UrlEntity(){}

    public UrlEntity(String name
//                     ,TagEntity domain
    ) {
        this.name = name;
//        this.domain = domain;
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

//    public TagEntity getDomain() {
//        return domain;
//    }

//    public void setDomain(TagEntity domain) {
//        this.domain = domain;
//    }
}
