package it.linkshare.service;
import it.linkshare.model.Tag;
import it.linkshare.repository.TagRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TagServiceTest {

    @Mock private TagRepository tagRepository;
    @InjectMocks private TagService tagService;

    @Test
    void getAllTag() {
        when(tagRepository.findAll())
                .thenReturn(Stream.of(new Tag()).collect(Collectors.toList()));
        assertEquals(1, tagService.getAllTag().size());
    }

    @Test
    void getTagById() {
        Tag tag = new Tag();
        when(tagRepository.getById(tag.getId())).thenReturn(tag);
        assertEquals(tag, tagService.getTagById(tag.getId()));
    }

    @Test
    void addNewTag() {
        Tag tag = new Tag();
        when(tagRepository.save(tag)).thenReturn(tag);
        assertEquals(tag, tagService.addNewTag(tag));
    }
}