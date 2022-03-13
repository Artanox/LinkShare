package it.linkshare.repository;

import it.linkshare.dao.TagDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TagRepository extends JpaRepository<TagDAO, Long> {
    Optional<TagDAO> findByName(String name);
}
