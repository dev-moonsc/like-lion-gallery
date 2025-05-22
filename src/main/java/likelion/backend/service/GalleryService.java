package likelion.backend.service;

import likelion.backend.domain.Gallery;
import likelion.backend.dto.GalleryRequestDto;
import likelion.backend.dto.GalleryResponseDto;
import likelion.backend.repository.GalleryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling business logic related to galleries.
 * Provides methods for retrieving and managing gallery data.
 */
@Service
@RequiredArgsConstructor
public class GalleryService {
    private final GalleryRepository galleryRepository;

    /**
     * Retrieves all galleries from the database and converts them to GalleryResponseDto objects.
     * This method runs in a read-only transaction.
     *
     * @return a list of GalleryResponseDto representing all galleries
     */
    @Transactional(readOnly = true)
    public List<GalleryResponseDto> getAllGalleries() {
        List<Gallery> galleries = galleryRepository.findAll();
        return galleries.stream().map(GalleryResponseDto::new).toList();
    }

    /**
     * Creates and saves a new gallery entity to the database.
     * Constructs a Gallery object from the provided request data and image path,
     * then persists it using the gallery repository.
     *
     * @param requestDto the DTO containing gallery title and description
     * @param image      the image URL or path associated with the gallery
     */
    @Transactional
    public void createGallery(GalleryRequestDto requestDto, String image) {
        Gallery gallery = new Gallery(requestDto, image);
        galleryRepository.save(gallery);
    }

    /**
     * Retrieves a gallery by its ID and returns it as a GalleryResponseDto.
     * Returns null if the gallery does not exist.
     *
     * @param id the unique identifier of the gallery
     * @return GalleryResponseDto if found, otherwise null
     */
    @Transactional
    public GalleryResponseDto getGalleryById(Long id) {
        Optional<Gallery> gallery = galleryRepository.findById(id);
        return gallery.map(GalleryResponseDto::new).orElse(null);
    }

}
