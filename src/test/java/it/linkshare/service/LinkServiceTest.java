package it.linkshare.service;

import it.linkshare.model.Link;
import it.linkshare.model.Tag;
import it.linkshare.repository.LinkRepository;
import it.linkshare.repository.TagRepository;
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
class LinkServiceTest {

    @Mock
    private LinkRepository linkRepository;
    @InjectMocks
    private LinkService linkService;
    static private Link link;

    @BeforeAll
    static void beforeAll(){
        link = new Link();
    }

    @Test
    void getAllLink() {
        when(linkRepository.findAll())
                .thenReturn(Stream.of(new Link(), new Link(), new Link()).collect(Collectors.toList()));
        assertEquals(3, linkService.getAllLink().size());
    }

    @Test
    void getLinkById() {
        when(linkRepository.getById(link.getId())).thenReturn(link);
        assertEquals(link, linkService.getLinkById(link.getId()));
    }

    @Test
    void addNewLink() {
        when(linkRepository.save(link)).thenReturn(link);
        assertEquals(link, linkService.addNewLink(link));
    }

    @Test
    void updateLink() {
        when(linkRepository.save(link)).thenReturn(link);
        assertEquals(link, linkService.updateLink(link));
    }

    @Test
    void deleteLink() {
        linkService.deleteLink(link);
        verify(linkRepository, times(1)).delete(link);
    }
}