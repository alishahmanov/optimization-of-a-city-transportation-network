
# Assignment 3 — Optimization of a City Transportation Network (MST)

**Course:** Design and Analysis of Algorithms  
**Student:** Alihan (SE-2401)  
**Project:** Implementation and comparison of **Prim’s** and **Kruskal’s** algorithms for finding the **Minimum Spanning Tree (MST)** in a weighted undirected graph.

---

##  Overview

This project models a **city transportation network** as a weighted graph,  
where:
- **Vertices** represent city districts  
- **Edges** represent possible roads  
- **Weights** represent construction costs  

The goal is to find a **set of roads (edges)** that connects all districts with the **minimum total cost**.

---

##  Implemented Algorithms

- **Prim’s Algorithm** — grows the MST by choosing the smallest edge from the connected part of the graph.  
- **Kruskal’s Algorithm** — sorts all edges and uses a **Disjoint Set Union (DSU)** structure to avoid cycles.  

Both algorithms were implemented in Java and compared by:
- Total cost of MST  
- Execution time (ms)  
- Operation count (comparisons, unions, etc.)

---
## Project Structure
org.example/
- ├── algorithms/
- │ ├── PrimAlgorithm.java
- │ ├── KruskalAlgorithm.java
- │ └── DisjointSet.java
- ├── graph/
- │ └── Graph.java
- ├── io/
- │ ├── InputReader.java
- │ ├── OutputWriter.java
- │ └── CsvWriter.java
- ├── model/
- │ ├── Edge.java
- │ ├── MSTEdge.java
- │ ├── AlgoStats.java
- ├── ResultItem.java
- │ ├── InputGraph.java
- │ ├── InputRoot.java
- │ └── OutputRoot.java
- └── Main.java

## Run Instructions

```bash
mvn -q -DskipTests package
mvn -q exec:java -Dexec.mainClass="org.example.Main"



