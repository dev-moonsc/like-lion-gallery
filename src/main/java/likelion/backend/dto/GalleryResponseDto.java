package likelion.backend.dto;

import likelion.backend.domain.Gallery;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Data Transfer Object for representing detailed gallery information in responses.
 * This DTO is used for returning detailed information about a single gallery post,
 * including the image path or URL, title, description, and the last update time.
 */
@Getter
@AllArgsConstructor
public class GalleryResponseDto {
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
     * The last update time of the gallery.
     */
    private LocalDateTime lastUpdate;

    /**
     * Constructs a GalleryResponseDto from a Gallery entity.
     *
     * @param gallery the Gallery entity from which to extract data
     */
    public GalleryResponseDto(Gallery gallery) {
        this.image = gallery.getImage();
        this.title = gallery.getTitle();
        this.description = gallery.getDescription();
        this.lastUpdate = gallery.getLastUpdate();
    }
}
