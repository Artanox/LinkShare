package it.linkshare.service;

import it.linkshare.repository.UrlRepository;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }
}
