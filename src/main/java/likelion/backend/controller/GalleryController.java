package likelion.backend.controller;

import likelion.backend.dto.GalleryResponseDto;
import likelion.backend.service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for handling gallery-related API requests.
 * Provides endpoints for retrieving gallery information.
 */
@RestController
@RequestMapping("/api/galleries")
@RequiredArgsConstructor
public class GalleryController {
    private final GalleryService galleryService;

    /**
     * Retrieves a list of all galleries.
     *
     * @return ResponseEntity containing a list of GalleryResponseDto objects and HTTP 200 status
     */
    @GetMapping
    public ResponseEntity<List<GalleryResponseDto>> getAllGalleries() {
        return ResponseEntity.ok(galleryService.getAllGalleries());
    }
}
