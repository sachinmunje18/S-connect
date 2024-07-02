package com.dijkra.task17;

import java.util.*;

class GraphNode {
	int vertex;
	int weight;

	public GraphNode(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}

public class DijkstraAlgorithm {
	private int V;
	private List<List<GraphNode>> adj;

	public DijkstraAlgorithm(int V) {
		this.V = V;
		adj = new ArrayList<>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	public void addEdge(int u, int v, int weight) {
		adj.get(u).add(new GraphNode(v, weight));
		adj.get(v).add(new GraphNode(u, weight)); // For undirected graph
	}

	public void dijkstra(int source) {
		PriorityQueue<GraphNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;
		pq.offer(new GraphNode(source, 0));

		while (!pq.isEmpty()) {
			int u = pq.poll().vertex;
			for (GraphNode neighbor : adj.get(u)) {
				int v = neighbor.vertex;
				int weight = neighbor.weight;
				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
					dist[v] = dist[u] + weight;
					pq.offer(new GraphNode(v, dist[v]));
				}
			}
		}

		System.out.println("Shortest distances from source vertex " + source + ":");
		for (int i = 0; i < V; i++) {
			System.out.println("Vertex " + i + ": " + dist[i]);
		}
	}

	public static void main(String[] args) {
		int V = 6;
		DijkstraAlgorithm graph = new DijkstraAlgorithm(V);

		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 4, 4);
		graph.addEdge(2, 5, 2);
		graph.addEdge(2, 3, 7);
		graph.addEdge(3, 4, 1);
		graph.addEdge(4, 5, 2);

		int source = 0;
		graph.dijkstra(source);
	}
}
