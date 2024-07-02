package com.graph.task13;

import java.util.*;

class Graph {
	private int V;
	private Map<Integer, List<Integer>> adj; // Adjacency list

	// Constructor
	public Graph(int V) {
		this.V = V;
		adj = new HashMap<>();
		for (int i = 0; i < V; i++) {
			adj.put(i, new ArrayList<>());
		}
	}

	public void addEdge(int v1, int v2) {
		adj.get(v1).add(v2);
		adj.get(v2).add(v1);
	}

	public void removeEdge(int v1, int v2) {
		if (adj.containsKey(v1) && adj.containsKey(v2)) {
			adj.get(v1).remove(Integer.valueOf(v2));
			adj.get(v2).remove(Integer.valueOf(v1));
		}
	}

	// Method to add a vertex
	public void addVertex(int v) {
		if (!adj.containsKey(v)) {
			adj.put(v, new ArrayList<>());
			V++;
		}
	}

	// Method to remove a vertex
	public void removeVertex(int v) {
		if (adj.containsKey(v)) {
			List<Integer> neighbors = adj.get(v);
			for (int neighbor : neighbors) {
				adj.get(neighbor).remove(Integer.valueOf(v));
			}
			adj.remove(v);
			V--;
		}
	}

	public boolean hasEdge(int v1, int v2) {
		return adj.containsKey(v1) && adj.get(v1).contains(v2);
	}

	public boolean hasVertex(int v) {
		return adj.containsKey(v);
	}

	public void DFS(int start) {
		boolean[] visited = new boolean[V];
		DFSUtil(start, visited);
	}

	private void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");

		for (int neighbor : adj.get(v)) {
			if (!visited[neighbor]) {
				DFSUtil(neighbor, visited);
			}
		}
	}

	public void BFS(int start) {
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int v = queue.poll();
			System.out.print(v + " ");

			for (int neighbor : adj.get(v)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.offer(neighbor);
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(5);

		// Adding edges
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		// Displaying the graph
		System.out.println("Graph:");
		graph.printGraph();

		// Removing an edge
		graph.removeEdge(1, 4);
		System.out.println("\nGraph after removing edge (1, 4):");
		graph.printGraph();

		// Adding and removing vertices
		graph.addVertex(5);
		graph.addEdge(2, 5);
		System.out.println("\nGraph after adding vertex 5 and edge (2, 5):");
		graph.printGraph();

		graph.removeVertex(2);
		System.out.println("\nGraph after removing vertex 2:");
		graph.printGraph();

		// Checking existence of vertices and edges
		System.out.println("\nDoes vertex 3 exist? " + graph.hasVertex(3));
		System.out.println("Does edge (1, 3) exist? " + graph.hasEdge(1, 3));

		// Performing DFS and BFS
		System.out.print("\nDFS starting from vertex 0: ");
		graph.DFS(0);

		System.out.print("\nBFS starting from vertex 0: ");
		graph.BFS(0);
	}

	public void printGraph() {
		for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
			System.out.print(entry.getKey() + " -> ");
			for (int neighbor : entry.getValue()) {
				System.out.print(neighbor + " ");
			}
			System.out.println();
		}
	}
}
