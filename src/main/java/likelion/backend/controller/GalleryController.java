package likelion.backend.controller;

import likelion.backend.dto.GalleryRequestDto;
import likelion.backend.dto.GalleryResponseDto;
import likelion.backend.service.GalleryService;
import likelion.backend.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    private final ImageService imageService;

    /**
     * Retrieves a list of all galleries.
     *
     * @return ResponseEntity containing a list of GalleryResponseDto objects and HTTP 200 status
     */
    @GetMapping
    public ResponseEntity<List<GalleryResponseDto>> getAllGalleries() {
        return ResponseEntity.ok(galleryService.getAllGalleries());
    }

    /**
     * Handles HTTP POST requests to create a new gallery with an uploaded image.
     * Receives an image file and gallery data as multipart/form-data, saves the image,
     * and creates a new gallery entry.
     *
     * @param image      the uploaded image file (multipart part named "image")
     * @param requestDto the gallery data (multipart part named "data")
     * @return ResponseEntity with HTTP status 201 (Created) if successful
     * @throws RuntimeException if an error occurs while saving the image file
     */
    @PostMapping
    public ResponseEntity<Void> createGallery(
            @RequestPart("image") MultipartFile image,
            @RequestPart("data") GalleryRequestDto requestDto) {
        String imagePath;
        try {
            imagePath = imageService.saveImage(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        galleryService.createGallery(requestDto, imagePath);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
