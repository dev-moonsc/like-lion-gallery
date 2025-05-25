package likelion.backend.dto;

import likelion.backend.domain.Gallery;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Data Transfer Object for representing a summary of gallery information in list responses.
 * This DTO is used when returning a list of gallery posts, containing the gallery's
 * unique identifier, image path or URL, title, and description.
 */
@Getter
@AllArgsConstructor
public class GalleryListResponseDto {
    /**
     * Unique identifier of the gallery.
     */
    private Long id;

    /**
     * Image URL or path of the gallery.
     */
    private String image;

    /**
     * Title of the gallery.
     */
    private String title;

    /**
     * Description of the gallery.
     */
    private String description;

    /**
     * Constructs a GalleryListResponseDTO from a Gallery entity.
     *
     * @param gallery the Gallery entity from which to extract data
     */
    public GalleryListResponseDto(Gallery gallery) {
        this.id = gallery.getId();
        this.image = gallery.getImage();
        this.title = gallery.getTitle();
        this.description = gallery.getDescription();
    }
}
