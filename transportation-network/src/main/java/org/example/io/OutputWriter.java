package org.example.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.model.OutputRoot;

import java.io.File;

/**
 * Writes the output JSON file to disk in a pretty-printed format.
 */
public class OutputWriter {

    public static void writeToFile(OutputRoot root, String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT);

        mapper.writeValue(new File(filePath), root);
    }
}
