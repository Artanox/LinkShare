package it.linkshare.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import it.linkshare.model.Tag;
import it.linkshare.service.TagService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@ExtendWith(SpringExtension.class)
@WebMvcTest(TagController.class)
class TagControllerTest {
    @MockBean
    TagService tagService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        Mockito.when(tagService.getAllTag()).thenReturn(Stream.of(new Tag(), new Tag(), new Tag()).collect(Collectors.toList()));
        mockMvc.perform(get("/api/v1/tag/tags"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(3)));
    }
}