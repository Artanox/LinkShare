package it.linkshare.repository;

import it.linkshare.dao.LinkDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<LinkDAO, Long> {
}
