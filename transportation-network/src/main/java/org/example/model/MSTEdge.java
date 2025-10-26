package org.example.model;

/**
 * Represents an edge included in the Minimum Spanning Tree (MST).
 */
public class MSTEdge {
    public String from;
    public String to;
    public int weight;

    public MSTEdge() {}

    public MSTEdge(String from, String to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return from + " - " + to + " (" + weight + ")";
    }
}
