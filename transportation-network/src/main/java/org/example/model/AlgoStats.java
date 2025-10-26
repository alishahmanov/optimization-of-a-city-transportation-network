package org.example.model;

import java.util.List;

/**
 * Stores statistics for a single algorithm (Prim or Kruskal):
 * - Edges in the MST
 * - Total cost
 * - Operation count
 * - Execution time
 */
public class AlgoStats {
    public List<MSTEdge> mst_edges;
    public int total_cost;
    public long operations_count;
    public double execution_time_ms;

    public AlgoStats() {}
}
