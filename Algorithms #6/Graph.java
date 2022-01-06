/**
 * Name: Arjun Bhan
 * Due Data: 11/11/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 */

import java.util.*;

public class Graph {

	private int[][] edges; // adjacency matrix
	private Object[] labels; // vertex label, i.e, vertex 0, its label = "A"

	public Graph(int n) {
		// n: size of nodes
		// weighted graph
		edges = new int[n][n];
		// edges[i][j] saves the weight of edge i->j, assume weight > 0
		// for unweighted graph 
		// set edges[i][j] to 1 if there exists an edge i->j
		// set edges[i][j] to 0 otherwise
		labels = new Object[n];
	}

	public void setLabel(int vertex, Object label) {
		//vertex: vertex index, label: vertex name
		labels[vertex] = label;

	}

	public Object getLabel(int vertex) {
		return labels[vertex];
	}


	public int size() {
		return edges.length;
	}


	public void addEdge(int source, int target, int w) {
		//w for weight
		edges[source][target] = w;
		//edges[target][source] = w;// undirected graph
	}


	public boolean isEdge(int source, int target) {
		//if edges[i][j] > 0, there exists an edge from vertex i to vertex j
		return edges[source][target] > 0;
	}

	public void removeEdge(int source, int target)
	{
		edges[source][target] = 0;
		//edges[target][source] = 0;// undirected graph
	}

	public int getWeight(int source, int target) {
		return edges[source][target];
	}

	public int[] neighbors(int vertex) {
		// find neighbors of a given vertex
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
			//System.out.print(labels[j] + ": ");
			for (int i = 0; i < edges[j].length; i++) {
				if (edges[j][i] > 0)
					System.out.println(labels[j] + " -> " + labels[i] + ":" + edges[j][i] + " ");
			}
			System.out.println();
		}
	}


	public int getUnvisitedNeighbor(int vertex, boolean[] visited) {
		// find an unvisited neighbor of a given vertex
		// if there exist multiple unvisited neighbors, return the first one found
		// if all neighbors are visited, return -1

		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0 && visited[i] == false)
				return i;
		}
		return -1;
	}

	public void dfs() {// DFS
		// Complete this method to traverse a graph using DFS
		// Start DFS from a randomly selected node in the graph
		// Note: Follow the pseudocode of DFS() in slides.
		System.out.println("DFS");

		//Find random value
		Random rand=new Random();
		int start = rand.nextInt(labels.length);

		Stack<Integer> curNode = new Stack<>();
		boolean visitNode[] = new boolean[labels.length];

		for (int i = 0; i < visitNode.length; i++) {
			visitNode[i] = false;
		}

		//Inputing in the starting value of the DFS
		System.out.println(labels[start] + " was visited");
		visitNode[start] = true;
		curNode.push(start);

		while (!curNode.isEmpty()) {

			//updating current value and its unvisited neighbors
			int cur = curNode.peek();
			int neighbor = getUnvisitedNeighbor(cur, visitNode);

			//If the value has neighboring unvisited values
			if (neighbor != -1) {
				System.out.println(labels[neighbor] + " was visited");
				curNode.push(neighbor);
				visitNode[neighbor] = true;
			}

			else {
				curNode.pop();
			}
		}

	}

	public void bfs() {// BFS
		// Complete this method to traverse a graph using BFS
		// Start BFS from a randomly selected node in the graph
		// Note: Follow the pseudocode of BFS() in slides.
		System.out.println("BFS");

		//Starting off at random point
		Random rand=new Random();
		int startPos = rand.nextInt(labels.length);

		boolean visitNode[] = new boolean[labels.length];
		Queue<Integer> curNode = new LinkedList();

		//Making sure all value are false
		for (int i = 0; i < visitNode.length; i++) {
			visitNode[i] = false;
		}

		//Storing first value
		visitNode[startPos] = true;
		System.out.println(labels[startPos] + " was visited");
		curNode.add(startPos);

		while (!curNode.isEmpty()) {
			//updating values
			int cur = curNode.peek();
			int neighbor = getUnvisitedNeighbor(cur, visitNode);

			//No unvisited neighbor
			if (neighbor != -1) {
				System.out.println(labels[neighbor] + " was visited");
				visitNode[neighbor] = true;
				curNode.add(neighbor);
			}

			else {
				curNode.remove();
			}
		}
	}


	public LinkedList<String>[]  adjList() {// Adjacency List
		// Complete the method to create an adjacency list for the graph
		// Feel free to change the return type
		System.out.println("adjList");
		LinkedList[] adjacLis = new LinkedList[labels.length];
		LinkedList adjacLisSeg = new LinkedList();
		for (int j = 0; j < edges.length; j++) {
			//Starting point
			adjacLisSeg.add(labels[j]);

			//Finding all neighbors
			for (int k = 0; k < neighbors(j).length; k++) {
				adjacLisSeg.add(labels[neighbors(j)[k]]);
			}

			//Storing all linked lists
			adjacLis[j]=adjacLisSeg;
			adjacLisSeg = new LinkedList();
		}
		return adjacLis;
	}

	public boolean isConnected() {
		// Complete the method to check an undirected graph is connected or not
		// Return true if the graph is connected
		// dfs()
		// visitNode[], true = number of vertices visited by dfs
		// compare number with number of vertices in the graph = visitNode.length
		// Complete the method to detect cycles in a directed graph
		// Feel free to change the return type, parameters
		System.out.println("isConnected");
		int start = 0;
		Stack<Integer> curNode = new Stack<>();
		int couTrue=0;

		boolean Conn=true;
		boolean visitNode[] = new boolean[labels.length];

		for (int i = 0; i < visitNode.length; i++) {
			visitNode[i] = false;
		}

		visitNode[start] = true;
		curNode.push(start);
		couTrue++;

		while (!curNode.isEmpty()) {
			//Updating current values
			int cur = curNode.peek();
			int neighbor = getUnvisitedNeighbor(cur, visitNode);

			//If unvisited neighbors exist
			if (neighbor != -1) {
				curNode.push(neighbor);
				visitNode[neighbor] = true;
				couTrue++;
			}

			else {
				curNode.pop();
			}
		}

		//Checking if all the nodes were visited
		if(couTrue!=labels.length)
		{
			Conn=false;
		}

		return Conn;
	}

	public static void main(String args[]) {

		// An example to create a graph using the Graph class
		Graph t = new Graph(6);
		t.setLabel(0, "A");
		t.setLabel(1, "B");
		t.setLabel(2, "C");
		t.setLabel(3, "D");
		t.setLabel(4, "E");
		t.setLabel(5, "F");
		t.addEdge(0, 1, 1);
		t.addEdge(0, 5, 1);
		t.addEdge(1, 2, 1);
		t.addEdge(1, 3, 1);
		t.addEdge(1, 5, 1);
		t.addEdge(2, 3, 1);
		t.addEdge(4, 3, 1);
		t.addEdge(4, 2, 1);
		t.addEdge(5, 4, 1);

		t = new Graph(6);
		t.setLabel(0, "0");
		t.setLabel(1, "1");
		t.setLabel(2, "2");
		t.setLabel(3, "3");
		t.setLabel(4, "4");
		t.setLabel(5, "5");
		t.addEdge(0, 1, 1);
		t.addEdge(0, 2, 1);
		t.addEdge(1, 2, 1);
		t.addEdge(1, 3, 1);
		t.addEdge(2, 3, 1);
		t.addEdge(3, 4, 1);
		t.addEdge(4, 0, 1);
		t.addEdge(4, 1, 1);
		t.addEdge(4, 5, 1);



		LinkedList<String>[] adjacen;
		LinkedList<String> curLinkLis;
		adjacen= t.adjList();

		for(int i = 0;i<adjacen.length;i++)
		{
			curLinkLis = adjacen[i];
			for(int j = 0;j < curLinkLis.size(); j++) {
				System.out.print("["+ adjacen[i].get(j)+"]");
				if(j != curLinkLis.size()-1)
				{
					System.out.print(" -> ");
				}
			}
			System.out.println();
		}

		// Test BFS
		t.bfs();

		// Test DFS
		t.dfs();

		t = new Graph(5);
		t.setLabel(0, "0");
		t.setLabel(1, "1");
		t.setLabel(2, "2");
		t.setLabel(3, "3");
		t.setLabel(4, "4");

		t.addEdge(0, 1, 1);
		t.addEdge(1, 3, 1);
		t.addEdge(3, 2, 1);
		t.addEdge(3, 4, 1);

		t.addEdge(1, 0, 1);
		t.addEdge(3, 1, 1);
		t.addEdge(2, 3, 1);
		t.addEdge(4, 3, 1);

		System.out.println(t.isConnected());

		t = new Graph(5);
		t.setLabel(0, "0");
		t.setLabel(1, "1");
		t.setLabel(2, "2");
		t.setLabel(3, "3");
		t.setLabel(4, "4");

		t.addEdge(0, 1, 1);
		t.addEdge(1, 3, 1);
		t.addEdge(3, 2, 1);

		t.addEdge(1, 0, 1);
		t.addEdge(3, 1, 1);
		t.addEdge(2, 3, 1);

		System.out.println(t.isConnected());
		// Complete the main method to create an adjacency list for the directed graph in problem 6
		// in Assignment 8
		// Print the adjacency list
		// Call bfs(), dfs() on the graph of problem 6 (its adjacency list or adjacency matrix)
		// Then create an undirected graph for problem 5 in Assignment 8
		// Test the function isConnected() on the graph


	}

}
