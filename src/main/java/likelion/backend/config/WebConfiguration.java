package likelion.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Spring Web MVC configuration class.
 * - Maps /images/** requests to the local images directory.
 * - Configures CORS settings for the application.
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * Configures a resource handler to serve static files from the images directory.
     * If the images directory does not exist, it is created automatically.
     *
     * @param registry the ResourceHandlerRegistry to configure resource handling
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        try {
            Path imageDir = Paths.get("images").toAbsolutePath();
            if (Files.notExists(imageDir)) {
                Files.createDirectories(imageDir);
            }
            registry.addResourceHandler("/images/**")
                    .addResourceLocations(imageDir.toUri().toString());
        } catch (IOException e) {
            throw new RuntimeException("Could not add resource location", e);
        }
    }

    /**
     * Configures CORS mappings for the application.
     * Allows all paths, specific origins, HTTP methods, and headers.
     *
     * @param registry the CorsRegistry to configure CORS
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all paths
                .allowedOrigins("http://localhost:3000") // Allowed origin (e.g., React app)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true) // Allow credentials (cookies)
                .maxAge(3600); // Cache preflight response for 3600 seconds
    }

}
