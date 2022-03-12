package it.linkshare.service;
import it.linkshare.model.Tag;
import it.linkshare.repository.TagRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TagServiceTest {

    @Mock private TagRepository tagRepository;
    @InjectMocks private TagService tagService;
    static private Tag tag;

    @BeforeAll
    static void beforeAll(){
        tag = new Tag();
    }

    @Test
    void getTagById() {
        when(tagRepository.getById(tag.getId())).thenReturn(tag);
        assertEquals(tag, tagService.getTagById(tag.getId()));
    }

    @Test
    void getAllTag() {
        when(tagRepository.findAll())
                .thenReturn(Stream.of(new Tag(), new Tag(), new Tag()).collect(Collectors.toList()));
        assertEquals(3, tagService.getAllTag().size());
    }
    @Test
    void addNewTag() {
        when(tagRepository.save(tag)).thenReturn(tag);
        assertEquals(tag, tagService.addNewTag(tag));
    }

/*    @Test
    void updateTag() {
        Tag newTag = new Tag();
        tagService.updateTag(newTag, tag.getId());
        verify(tagRepository, times(1)).save(newTag);
    }*/

    @Test
    void deleteTag() {
        tagService.deleteTag(tag.getId());
        verify(tagRepository, times(1)).delete(tag);
    }
}