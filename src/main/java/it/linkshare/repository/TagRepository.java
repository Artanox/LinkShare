package it.linkshare.repository;

import it.linkshare.dao.TagDAO;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagRepository extends JpaRepository<TagDAO, Long> {
}
