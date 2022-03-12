package it.linkshare.service;

import it.linkshare.repository.entity.UrlEntity;
import it.linkshare.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {

    UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }


    public List<UrlEntity> getAllUrl(){
        return urlRepository.findAll();
    }

    public UrlEntity getUrlById(Long id){
        return urlRepository.getById(id);
    }

    public UrlEntity addNewUrl(UrlEntity url){
        return urlRepository.save(url);
    }

    public UrlEntity updateUrl(UrlEntity url){
        return urlRepository.save(url);
    }

    public void deleteUrl(UrlEntity url){
        urlRepository.delete(url);
    }
}
