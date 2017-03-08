package util;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
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

    public static byte[] loadFileAsStream(String path) throws Exception {
        return IOUtils.toByteArray(getStreeam(path));
    }

    private static URI getUri(String path) throws Exception {
        URL resource = ResourceLoader.class.getClassLoader().getResource(path);
        System.out.println(resource);
        Objects.requireNonNull(resource);
        Objects.requireNonNull(resource.toURI());
        return resource.toURI();
    }

    private static InputStream getStreeam(String path) throws Exception {
        return ResourceLoader.class.getClassLoader().getResourceAsStream(path);
    }

}
