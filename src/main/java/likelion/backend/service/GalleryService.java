package likelion.backend.service;

import likelion.backend.domain.Gallery;
import likelion.backend.dto.GalleryResponseDto;
import likelion.backend.repository.GalleryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
