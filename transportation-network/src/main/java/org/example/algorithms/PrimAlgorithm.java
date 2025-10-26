package org.example.algorithms;

import org.example.graph.Graph;
import org.example.model.AlgoStats;
import org.example.model.MSTEdge;
import org.example.model.Edge;
import org.example.util.OperationCounter;
import org.example.util.Stopwatch;

import java.util.*;

/**
 * Prim's algorithm for MST on an undirected weighted graph.
 * Uses a min-heap over edges leaving the currently grown tree.
 */
public class PrimAlgorithm {

    public static AlgoStats run(Graph g) {
        AlgoStats stats = new AlgoStats();
        if (g.nodes == null || g.nodes.isEmpty()) {
            stats.mst_edges = new ArrayList<>();
            stats.total_cost = 0;
            stats.operations_count = 0;
            stats.execution_time_ms = 0.0;
            return stats;
        }

        OperationCounter ops = new OperationCounter();
        Stopwatch sw = new Stopwatch();

        Set<String> used = new HashSet<>();
        List<MSTEdge> mst = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        String start = g.nodes.get(0);
        used.add(start);
        for (Edge e : g.adj.get(start)) { pq.offer(e); ops.inc(); }

        int totalCost = 0;

        sw.start();
        while (!pq.isEmpty() && mst.size() < g.nodes.size() - 1) {
            Edge e = pq.poll(); ops.inc();

            if (used.contains(e.to)) { ops.inc(); continue; }

            mst.add(new MSTEdge(e.from, e.to, e.weight));
            totalCost += e.weight;
            used.add(e.to);

            for (Edge ne : g.adj.get(e.to)) {
                if (!used.contains(ne.to)) {
                    pq.offer(ne); ops.add(2);
                } else {
                    ops.inc();
                }
            }
        }
        stats.execution_time_ms = sw.elapsedMs();
        stats.operations_count = ops.get();
        stats.total_cost = totalCost;
        stats.mst_edges = mst;
        return stats;
    }
}
