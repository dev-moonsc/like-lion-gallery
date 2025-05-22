package likelion.backend.dto;

import likelion.backend.domain.Gallery;
import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * DTO for sending gallery information in responses.
 * Contains gallery ID, image URL, title, and description.
 * Used to transfer gallery data from the server to the client.
 */
@Getter
@AllArgsConstructor
public class GalleryResponseDto {
    /**
     * The unique identifier of the gallery.
     */
    private Long id;

    /**
     * The image URL or path of the gallery.
     */
    private String image;

    /**
     * The title of the gallery.
     */
    private String title;

    /**
     * The description of the gallery.
     */
    private String description;

    /**
     * Constructs a GalleryResponseDto from a Gallery entity.
     *
     * @param gallery the Gallery entity
     */
    public GalleryResponseDto(Gallery gallery) {
        this.id = gallery.getId();
        this.image = gallery.getImage();
        this.title = gallery.getTitle();
        this.description = gallery.getDescription();
    }
}

