package org.example;

import org.example.algorithms.KruskalAlgorithm;
import org.example.algorithms.PrimAlgorithm;
import org.example.graph.Graph;
import org.example.io.InputReader;
import org.example.io.OutputWriter;
import org.example.model.*;

public class Main {
    public static void main(String[] args) throws Exception {
        InputRoot input = InputReader.readFromResources("/Assignment 3 Input.json");

        OutputRoot out = new OutputRoot();

        for (InputGraph ig : input.graphs) {
            Graph g = new Graph(ig.nodes, ig.edges);

            ResultItem r = new ResultItem();
            r.graph_id = ig.id;
            r.input_stats.vertices = ig.nodes.size();
            r.input_stats.edges = ig.edges.size();

            r.prim = PrimAlgorithm.run(g);
            r.kruskal = KruskalAlgorithm.run(g);

            if (r.prim.total_cost != r.kruskal.total_cost) {
                System.err.println("Cost mismatch on graph " + ig.id +
                        ": Prim=" + r.prim.total_cost + " vs Kruskal=" + r.kruskal.total_cost);
            }
            int expectedEdges = Math.max(0, ig.nodes.size() - 1);
            if (r.prim.mst_edges == null || r.prim.mst_edges.size() < expectedEdges) {
                System.err.println("Prim produced fewer than V-1 edges on graph " + ig.id);
            }
            if (r.kruskal.mst_edges == null || r.kruskal.mst_edges.size() < expectedEdges) {
                System.err.println("Kruskal produced fewer than V-1 edges on graph " + ig.id);
            }

            out.results.add(r);
        }

        String outPath = "src/main/resources/output/Assignment 3 Output.json";
        OutputWriter.writeToFile(out, outPath);
        System.out.println("Results saved to: " + outPath);

        String csvPath = "src/main/resources/output/results_summary.csv";
        org.example.io.CsvWriter.writeSummary(out, csvPath);
        System.out.println("CSV saved to: " + csvPath);
    }
}
