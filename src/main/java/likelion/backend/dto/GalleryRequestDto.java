package likelion.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO for gallery creation or update requests.
 * Used by clients to send the gallery's title and description to the server.
 */
@Getter
@AllArgsConstructor
public class GalleryRequestDto {
    /**
     * The title of the gallery.
     */
    private String title;

    /**
     * The description of the gallery.
     */
    private String description;
}

