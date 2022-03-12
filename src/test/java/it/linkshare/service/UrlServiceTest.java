package it.linkshare.service;

import it.linkshare.repository.entity.UrlEntity;
import it.linkshare.repository.UrlRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UrlServiceTest {

    @Mock
    private UrlRepository urlRepository;
    @InjectMocks
    private UrlService urlService;
    private static UrlEntity url;

    @BeforeAll
    static void beforeAll(){
        url = new UrlEntity();
    }

    @Test
    void getAllUrl() {
        when(urlRepository.findAll())
                .thenReturn(Stream.of(new UrlEntity(), new UrlEntity(), new UrlEntity()).collect(Collectors.toList()));
        assertEquals(3, urlService.getAllUrl().size());
    }

    @Test
    void getUrlById() {
        when(urlRepository.getById(url.getId())).thenReturn(url);
        assertEquals(url, urlService.getUrlById(url.getId()));
    }

    @Test
    void addNewUrl() {
        when(urlRepository.save(url)).thenReturn(url);
        assertEquals(url, urlService.addNewUrl(url));
    }

    @Test
    void updateUrl() {
        when(urlRepository.save(url)).thenReturn(url);
        assertEquals(url, urlService.updateUrl(url));
    }

    @Test
    void deleteUrl() {
        urlService.deleteUrl(url);
        verify(urlRepository, times(1)).delete(url);
    }
}