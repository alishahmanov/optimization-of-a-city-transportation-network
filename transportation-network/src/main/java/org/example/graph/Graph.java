package org.example.graph;

import org.example.model.Edge;

import java.util.*;

/**
 * In-memory representation of an undirected, weighted graph.
 * Stores:
 *  - nodes: list of vertex labels
 *  - edges: list of all edges (unique, as in input)
 *  - adj: adjacency lists for quick traversal (contains both directions)
 */
public class Graph {
    public final List<String> nodes;
    public final List<Edge> edges;
    public final Map<String, List<Edge>> adj = new HashMap<>();

    public Graph(List<String> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;

        // init adjacency buckets
        for (String v : nodes) {
            adj.put(v, new ArrayList<>());
        }

        // build undirected adjacency
        for (Edge e : edges) {
            // original direction
            adj.get(e.from).add(e);
            // mirrored edge for undirected traversal
            adj.get(e.to).add(new Edge(e.to, e.from, e.weight));
        }
    }

    /** Returns degree (number of incident edges in undirected sense) */
    public int degree(String v) {
        List<Edge> list = adj.get(v);
        return list == null ? 0 : list.size();
    }

    /** Defensive check: returns true if all nodes appear in adjacency map */
    public boolean isConsistent() {
        for (String v : nodes) {
            if (!adj.containsKey(v)) return false;
        }
        return true;
    }
}
