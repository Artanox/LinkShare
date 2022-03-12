package it.linkshare.service;
import it.linkshare.repository.entity.TagEntity;
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
    static private TagEntity tag;

    @BeforeAll
    static void beforeAll(){
        tag = new TagEntity();
    }

    @Test
    void getTagById() {
        when(tagRepository.getById(tag.getId())).thenReturn(tag);
        assertEquals(tag, tagService.getTagById(tag.getId()));
    }

    @Test
    void getAllTag() {
        when(tagRepository.findAll())
                .thenReturn(Stream.of(new TagEntity(), new TagEntity(), new TagEntity()).collect(Collectors.toList()));
        assertEquals(3, tagService.getAllTag().size());
    }
//    @Test
//    void addNewTag() {
//        when(tagRepository.save(tag)).thenReturn(tag);
//        assertEquals(tag, tagService.addNewTag(tag));
//    }

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