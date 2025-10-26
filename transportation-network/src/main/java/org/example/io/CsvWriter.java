package org.example.io;

import org.example.model.OutputRoot;
import org.example.model.ResultItem;

import java.io.FileWriter;
import java.io.PrintWriter;

public class CsvWriter {

    public static void writeSummary(OutputRoot root, String path) throws Exception {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            pw.println("GraphId,Vertices,Edges,PrimCost,KruskalCost,PrimTime(ms),KruskalTime(ms),PrimOps,KruskalOps");
            for (ResultItem r : root.results) {
                String line = String.format(
                        "%d,%d,%d,%d,%d,%.3f,%.3f,%d,%d",
                        r.graph_id,
                        r.input_stats.vertices,
                        r.input_stats.edges,
                        r.prim.total_cost,
                        r.kruskal.total_cost,
                        r.prim.execution_time_ms,
                        r.kruskal.execution_time_ms,
                        r.prim.operations_count,
                        r.kruskal.operations_count
                );
                pw.println(line);
            }
        }
    }
}
