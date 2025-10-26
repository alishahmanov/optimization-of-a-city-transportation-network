package org.example.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Disjoint Set Union (Union-Find) with path compression and union by rank.
 */
public class DisjointSet {
    private final Map<String, String> parent = new HashMap<>();
    private final Map<String, Integer> rank = new HashMap<>();

    public void makeSet(Iterable<String> nodes) {
        for (String v : nodes) {
            parent.put(v, v);
            rank.put(v, 0);
        }
    }

    public String find(String v) {
        if (!parent.get(v).equals(v)) {
            parent.put(v, find(parent.get(v)));
        }
        return parent.get(v);
    }

    public boolean union(String a, String b) {
        String ra = find(a), rb = find(b);
        if (ra.equals(rb)) return false;

        int raRank = rank.get(ra), rbRank = rank.get(rb);
        if (raRank < rbRank) {
            parent.put(ra, rb);
        } else if (raRank > rbRank) {
            parent.put(rb, ra);
        } else {
            parent.put(rb, ra);
            rank.put(ra, raRank + 1);
        }
        return true;
    }
}
