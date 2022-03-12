package it.linkshare.repository;

import it.linkshare.repository.entity.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<LinkEntity, Long> {
}
