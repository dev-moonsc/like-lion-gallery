package likelion.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Service for saving uploaded images and generating their URLs.
 */
@Service
public class ImageService {

    /**
     * Absolute path to the directory where uploaded images will be stored.
     */
    private static final Path IMAGE_DIR = Paths.get("images").toAbsolutePath();

    /**
     * Saves the uploaded image file and returns its URL.
     *
     * @param image the uploaded file
     * @return the URL to access the saved image
     * @throws IOException if saving fails or extension is invalid
     */
    public String saveImage(MultipartFile image) throws IOException {
        String original = image.getOriginalFilename();
        if (original == null || !original.contains(".")) throw new IOException("Invalid file name.");
        String filename = UUID.randomUUID() + original.substring(original.lastIndexOf('.'));
        Files.createDirectories(IMAGE_DIR);
        image.transferTo(IMAGE_DIR.resolve(filename).toFile());
        return "/images/" + filename;
    }
}
