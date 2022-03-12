package it.linkshare.repository;

import it.linkshare.repository.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long>{
}
