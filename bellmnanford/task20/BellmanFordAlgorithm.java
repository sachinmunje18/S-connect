package com.bellmnanford.task20;

import java.util.*;

class Edge {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class BellmanFordAlgorithm {
    private int V;
    private int E;
    private List<Edge> edges;

    public BellmanFordAlgorithm(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    public void bellmanFord(int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 1; i < V; ++i) {
            for (Edge edge : edges) {
                int u = edge.src;
                int v = edge.dest;
                int weight = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        System.out.println("Shortest distances from source vertex " + source + ":");
        for (int i = 0; i < V; ++i) {
            System.out.println("Vertex " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 8; // Number of edges
        BellmanFordAlgorithm graph = new BellmanFordAlgorithm(V, E);

        // Adding edges to the graph (src, dest, weight)
        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);

        int source = 0; // Source vertex

        // Perform Bellman-Ford algorithm from source vertex
        graph.bellmanFord(source);
    }
}
