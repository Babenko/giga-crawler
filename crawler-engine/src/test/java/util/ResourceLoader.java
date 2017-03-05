package util;

import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * @author Sem Babenko
 */
public class ResourceLoader {

    public static byte[] loadFile(String path) throws Exception {
        return Files.readAllBytes(Paths.get(getUri(path)));
    }

    private static URI getUri(String path) throws Exception {
        URL resource = ResourceLoader.class.getClassLoader().getResource(path);
        Objects.requireNonNull(resource);
        Objects.requireNonNull(resource.toURI());
        return resource.toURI();
    }

}
