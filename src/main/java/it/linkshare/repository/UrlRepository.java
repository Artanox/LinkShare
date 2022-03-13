package it.linkshare.repository;

import it.linkshare.dao.UrlDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlDAO, Long> {
}
