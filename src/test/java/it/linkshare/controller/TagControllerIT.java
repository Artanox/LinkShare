package it.linkshare.controller;

import it.linkshare.controller.dto.Tag;
import it.linkshare.controller.dto.TagCreationRequest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureWebTestClient
class TagControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    private static final String TAG_URL = "api/v1/tags";

    @Nested
    class CreateTagsControllerIT {

        @Test
        void createTagRequest_tagIsCreated() {
            // Arrange
            var request = new TagCreationRequest("name", true, TagCreationRequest.DomainName.MEGA);

            // Act
            Tag response = webTestClient.post()
                    .uri(uriBuilder -> uriBuilder.path(TAG_URL).build())
                    .bodyValue(request)
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody(Tag.class).returnResult().getResponseBody();

            // Assert
            assertThat(response).isNotNull();
            assertThat(response.getId()).isNotNull();
            assertThat(response.getName()).isEqualTo("name");
            assertThat(response.getNsfw()).isTrue();
        }

        @Test
        void createTagRequest_missingDomain_validationErrorIsReturned() {
            // Arrange
            var request = new TagCreationRequest("name", true, null);

            // Act and Assert
            webTestClient.post()
                    .uri(uriBuilder -> uriBuilder.path(TAG_URL).build())
                    .bodyValue(request)
                    .exchange()
                    .expectStatus().isBadRequest();
        }
    }

    @Nested
    class GetTagsControllerIT {
        @Test
        void getTagById_butTagNotExists_notFoundIsReturned() {
            // Arrange
            var request = new TagCreationRequest("name", true, TagCreationRequest.DomainName.MEGA);
            var randomId = "1234";

            // Act
            webTestClient.get()
                    .uri(uriBuilder -> uriBuilder.path(TAG_URL).pathSegment(randomId).build())
                    .exchange()
                    .expectStatus().isNotFound();
        }
    }

}