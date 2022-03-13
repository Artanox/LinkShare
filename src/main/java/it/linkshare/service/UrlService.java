package it.linkshare.service;

import it.linkshare.dao.UrlDAO;
import it.linkshare.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {

    UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }


    public List<UrlDAO> getAllUrl(){
        return urlRepository.findAll();
    }

    public UrlDAO getUrlById(Long id){
        return urlRepository.getById(id);
    }

    public UrlDAO addNewUrl(UrlDAO url){
        return urlRepository.save(url);
    }

    public UrlDAO updateUrl(UrlDAO url){
        return urlRepository.save(url);
    }

    public void deleteUrl(UrlDAO url){
        urlRepository.delete(url);
    }
}
