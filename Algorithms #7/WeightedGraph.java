/**
 * Name: Arjun Bhan
 * Due Data: 11/18/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 */

public class WeightedGraph {

	private static int[][] edges; // adjacency matrix
	private Object[] labels;

	public WeightedGraph(int n) {
		// n: size of nodes
		edges = new int[n][n];
		labels = new Object[n];
	}

	public int size() {
		return labels.length;
	}

	public void setLabel(int vertex, Object label) {
		//vertex: vertex index, label: vertex name
		labels[vertex] = label;
		
	}

	public Object getLabel(int vertex) {
		return labels[vertex];
	}

	public void addEdge(int source, int target, int w) {
		//w for weight
		edges[source][target] = w;
		edges[target][source] = w; // undirected graph
	}

	public boolean isEdge(int source, int target) {
		//if edges[i][j] > 0, there exists an edge from vertex i to vertex j
		return edges[source][target] > 0;
	}

	public static void removeEdge(int source, int target) {
		edges[source][target] = 0;
		edges[target][source] = 0; // undirected graph
	}

	public static int getWeight(int source, int target) {
		return edges[source][target];
	}

	public static int[] neighbors(int vertex) {
		int count = 0;
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0)
				count++;
		}
		final int[] answer = new int[count];
		count = 0;
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0)
				answer[count++] = i;
		}
		return answer;
	}

	public void print() {
		for (int j = 0; j < edges.length; j++) {
			System.out.print(labels[j] + ": ");
			for (int i = 0; i < edges[j].length; i++) {
				if (edges[j][i] > 0)
					System.out.print(labels[i] + ":" + edges[j][i] + " ");
			}
			System.out.println();
		}
	}

	private static int minVertex(int[] dist, boolean[] ST) {
		// find a vertex v that has NOT been added to the shortest path tree ST, and has the minimum estimated distance d[v]
		int x = Integer.MAX_VALUE;
		int v = -1; // graph not connected, or all vertices have been added to the shortest path tree

		for (int i = 0; i < dist.length; i++) {
			// examine nodes one by one
			if (!ST[i] && dist[i] < x) {
				// vertex i has NOT been added to the shorest path tree yet, and has a smaller estimated distance to s
				v = i;
				x = dist[i];
			}
		}

		return v;
	}

	public static int targDis(int[] pred, int s, int e) {
		int x = e;
		int totWeight = 0;

		//Going through graph and counting the distances of each node
		while (x != s) {
			totWeight += WeightedGraph.getWeight(x,pred[x]);
			x = pred[x];
		}
		totWeight += WeightedGraph.getWeight(x,s);

		return totWeight;
	}

	public static int shortestcycle(WeightedGraph t ,int source, int target)
	{
		//Finding out the length from source to target then removing the path.
		int totWeig=getWeight(source,target);
		removeEdge(source,target);

		int[] pred = Dijkstra.dijkstra(t, source);

		//Obtaining the path from target to source when no direct path exists
		totWeig = targDis(pred, source, target)+totWeig;

		return totWeig; // Return the preceding node array

	}

	public static void main(String args[]) {
		
		// Problem 3. 
		// Instructions for Problem 2 and 4 can be found in the main method after the test statements of Dijkstra's algorithm.
		WeightedGraph t = new WeightedGraph(6);
		// Create a graph t
		t.setLabel(0, "v0");
		t.setLabel(1, "v1");
		t.setLabel(2, "v2");
		t.setLabel(3, "v3");
		t.setLabel(4, "v4");
		t.setLabel(5, "v5");
		t.addEdge(0, 1, 2);
		t.addEdge(0, 5, 9);
		t.addEdge(1, 2, 8);
		t.addEdge(1, 3, 15);
		t.addEdge(1, 5, 6);
		t.addEdge(2, 3, 1);
		t.addEdge(4, 3, 3);
		t.addEdge(4, 2, 7);
		t.addEdge(5, 4, 3);

		System.out.println("Dijkstra's");

		//Test the Dijkstra's algorithm to find the shortest path from v0 to every other node in graph t
		int[] pred = Dijkstra.dijkstra(t, 0);
		for (int n = 0; n < 6; n++) {
			Dijkstra.printPath(t, pred, 0, n);
		}
		//Expected output
		/*
		[v0]
		[v0, v1]
		[v0, v1, v2]
		[v0, v1, v2, v3]
		[v0, v1, v5, v4]
		[v0, v1, v5]
		*/

		t = new WeightedGraph(8);
		t.setLabel(0, "A");
		t.setLabel(1, "B");
		t.setLabel(2, "C");
		t.setLabel(3, "D");
		t.setLabel(4, "E");
		t.setLabel(5, "F");
		t.setLabel(6, "G");
		t.setLabel(7, "Z");
		t.addEdge(0, 1, 2);
		t.addEdge(0, 2, 3);
		t.addEdge(1, 2, 6);
		t.addEdge(2, 4, 4);
		t.addEdge(1, 3, 4);
		t.addEdge(1, 4, 5);
		t.addEdge(3, 4, 8);
		t.addEdge(3, 5, 4);
		t.addEdge(4, 5, 5);
		t.addEdge(4, 6, 5);
		t.addEdge(5, 6, 8);
		t.addEdge(5, 7, 6);
		t.addEdge(6, 7, 7);

		// Problem 2 and 4.
		// Create an undirected graph for problem 2 in Assignment 9
		// Test the function shortestcycle() on the graph
		System.out.println("shortest cycle");
		System.out.println(shortestcycle(t,2,4));
		//14
	}



}
