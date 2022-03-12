package it.linkshare.service;

import it.linkshare.model.Tag;
import it.linkshare.model.Url;
import it.linkshare.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {

    UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }


    public List<Url> getAllUrl(){
        return urlRepository.findAll();
    }

    public Url getUrlById(Long id){
        return urlRepository.getById(id);
    }

    public Url addNewUrl(Url url){
        return urlRepository.save(url);
    }

    public Url updateUrl(Url url){
        return urlRepository.save(url);
    }

    public void deleteUrl(Url url){
        urlRepository.delete(url);
    }
}
