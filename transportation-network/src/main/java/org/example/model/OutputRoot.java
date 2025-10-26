package org.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Root structure for the output JSON file.
 * Contains results of all processed graphs.
 */
public class OutputRoot {
    public List<ResultItem> results = new ArrayList<>();
}
