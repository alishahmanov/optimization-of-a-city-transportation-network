package org.example.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.InputRoot;

import java.io.InputStream;

/**
 * Reads the input JSON file from the resources folder.
 */
public class InputReader {

    public static InputRoot readFromResources(String resourcePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream is = InputReader.class.getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new IllegalArgumentException("File not found: " + resourcePath);
            }
            return mapper.readValue(is, InputRoot.class);
        }
    }
}
