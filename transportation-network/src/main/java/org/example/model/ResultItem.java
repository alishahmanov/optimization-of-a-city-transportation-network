package org.example.model;

/**
 * Represents results for one graph:
 * includes both Prim and Kruskal algorithm data.
 */
public class ResultItem {
    public int graph_id;
    public InputStats input_stats = new InputStats();
    public AlgoStats prim = new AlgoStats();
    public AlgoStats kruskal = new AlgoStats();

    /**
     * Inner class for basic input graph info (vertices, edges count)
     */
    public static class InputStats {
        public int vertices;
        public int edges;
    }
}
