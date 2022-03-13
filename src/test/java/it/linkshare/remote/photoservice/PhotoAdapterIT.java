package it.linkshare.remote.photoservice;

import it.linkshare.remote.photoservice.dto.PhotoOverview;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@SpringBootTest
class PhotoAdapterIT {

	@Autowired
	private PhotoAdapter photoAdapter;

	private static final Integer COUNT_PHOTOS_FROM_REMOTE = 5000;

	@Test
	void fetchPhotosFromRemote_photosAreReturned() {
		// Act
		List<PhotoOverview> photosFromRemote = photoAdapter.fetchPhotos();

		// Assert
		assertThat(photosFromRemote).isNotEmpty().hasSize(COUNT_PHOTOS_FROM_REMOTE);
	}

}