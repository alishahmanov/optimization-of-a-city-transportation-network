package org.example.algorithms;

import org.example.graph.Graph;
import org.example.model.AlgoStats;
import org.example.model.MSTEdge;
import org.example.model.Edge;
import org.example.util.OperationCounter;
import org.example.util.Stopwatch;

import java.util.*;

/**
 * Kruskal's algorithm for MST: sort edges by weight and add if they don't create a cycle.
 */
public class KruskalAlgorithm {

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

        List<Edge> sorted = new ArrayList<>(g.edges);

        sw.start();
        sorted.sort(Comparator.comparingInt(e -> e.weight));
        ops.add(sorted.size() > 1 ? (long) (sorted.size() * (Math.log(sorted.size()) / Math.log(2))) : 0);

        DisjointSet dsu = new DisjointSet();
        dsu.makeSet(g.nodes);

        List<MSTEdge> mst = new ArrayList<>();
        int totalCost = 0;

        for (Edge e : sorted) {
            String ra = dsu.find(e.from); ops.inc();
            String rb = dsu.find(e.to);   ops.inc();

            if (!ra.equals(rb)) {
                boolean merged = dsu.union(ra, rb); ops.inc();
                if (merged) {
                    mst.add(new MSTEdge(e.from, e.to, e.weight));
                    totalCost += e.weight;
                    if (mst.size() == g.nodes.size() - 1) break;
                }
            } else {
                ops.inc();
            }
        }

        stats.execution_time_ms = sw.elapsedMs();
        stats.operations_count = ops.get();
        stats.total_cost = totalCost;
        stats.mst_edges = mst;
        return stats;
    }
}
