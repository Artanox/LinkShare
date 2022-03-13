package it.linkshare.remote.photoservice;

import it.linkshare.remote.photoservice.dto.PhotoOverview;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class PhotoAdapter {

	private static final String PHOTO_SERVICE_BASEURL = "https://jsonplaceholder.typicode.com/photos";

	private final WebClient webClient = WebClient.builder()
												 .baseUrl(PHOTO_SERVICE_BASEURL)
												 .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
												 .build();

	public List<PhotoOverview> fetchPhotos() {
		// TODO: Add error handling
		return webClient.get()
						.retrieve()
						.toEntityList(PhotoOverview.class)
						.block()
						.getBody();
	}

}
