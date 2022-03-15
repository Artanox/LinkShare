package it.linkshare.service;

import it.linkshare.dao.TagDAO;
import it.linkshare.dto.TagRequestDTO;
import it.linkshare.dto.TagResponseDTO;
import it.linkshare.repository.TagRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TagServiceTest {

    @Mock private TagRepository tagRepository;
    @InjectMocks private TagService tagService;

    static private TagRequestDTO tagRequestDTO;
    static private TagResponseDTO tagResponseDTO;
    static private TagDAO tagDAO;
    static private Long id;

    @BeforeAll
    static void beforeAll() {
        tagRequestDTO = new TagRequestDTO("foo", true);
        tagResponseDTO = new TagResponseDTO(1L, "foo", true);
        tagDAO = new TagDAO("foo", true);
        id = 1L;
        tagDAO.setId(id);
    }

    @Test
    void getTagById() {
        when(tagRepository.findById(any())).thenReturn(Optional.ofNullable(tagDAO));
        TagResponseDTO testTagResponseDTO = tagService.getById(id);
        assertEquals(tagResponseDTO.getId(), testTagResponseDTO.getId());
        assertEquals(tagResponseDTO.getName(), testTagResponseDTO.getName());
        assertEquals(tagResponseDTO.getNsfw(), testTagResponseDTO.getNsfw());
    }

    @Test
    void getTagByIdNotFoundException() {
        when(tagRepository.findById(any())).thenReturn(Optional.ofNullable(null));
        Throwable exception = assertThrows(ResponseStatusException.class, () -> tagService.getById(id));
        assertEquals("404 NOT_FOUND", exception.getMessage());
    }

    @Test
    void getAllTag() {
        when(tagRepository.findAll()).thenReturn(
                Stream.of(new TagDAO(), new TagDAO(), new TagDAO())
                        .collect(Collectors.toList()));
        assertEquals(3, tagService.getAll().size());
    }

    @Test
    void addNewTag() {
        when(tagRepository.save(any())).thenReturn(tagDAO);
        TagResponseDTO testTagResponseDTO = tagService.addNew(tagRequestDTO);
        assertEquals(tagResponseDTO.getId(), testTagResponseDTO.getId());
        assertEquals(tagResponseDTO.getName(), testTagResponseDTO.getName());
        assertEquals(tagResponseDTO.getNsfw(), testTagResponseDTO.getNsfw());
    }

    @Test
    void updateExistingTag() {
        when(tagRepository.findById(any())).thenReturn(Optional.ofNullable(tagDAO));
        when(tagRepository.save(any())).thenReturn(tagDAO);
        TagResponseDTO testTagResponseDTO = tagService.update(tagRequestDTO, id);
        assertEquals(tagResponseDTO.getId(), testTagResponseDTO.getId());
        assertEquals(tagResponseDTO.getName(), testTagResponseDTO.getName());
        assertEquals(tagResponseDTO.getNsfw(), testTagResponseDTO.getNsfw());
    }

    @Test
    void updateNotExistingTag() {
        when(tagRepository.findById(any())).thenReturn(Optional.ofNullable(null));
        when(tagRepository.save(any())).thenReturn(tagDAO);
        TagResponseDTO testTagResponseDTO = tagService.update(tagRequestDTO, id);
        assertEquals(tagResponseDTO.getId(), testTagResponseDTO.getId());
        assertEquals(tagResponseDTO.getName(), testTagResponseDTO.getName());
        assertEquals(tagResponseDTO.getNsfw(), testTagResponseDTO.getNsfw());
    }

    @Test
    void deleteTag() {
        when(tagRepository.findById(any())).thenReturn(Optional.ofNullable(tagDAO));
        tagService.delete(id);
        verify(tagRepository, times(1)).findById(any());
        verify(tagRepository, times(1)).delete(any());
    }

    @Test
    void deleteTagNotFound() {
        when(tagRepository.findById(any())).thenReturn(Optional.ofNullable(null));
        Throwable exception = assertThrows(ResponseStatusException.class, () -> tagService.delete(id));
        assertEquals("404 NOT_FOUND", exception.getMessage());
    }

    @Test
    void saveDaoThenMapResponseDto() {
        when(tagRepository.save(any())).thenReturn(tagDAO);
        TagResponseDTO testTagResponseDTO = tagService.saveDaoThenMapResponseDto(tagDAO);
        assertEquals(tagResponseDTO.getId(), testTagResponseDTO.getId());
        assertEquals(tagResponseDTO.getName(), testTagResponseDTO.getName());
        assertEquals(tagResponseDTO.getNsfw(), testTagResponseDTO.getNsfw());
    }

}