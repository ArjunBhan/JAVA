/**
 * Name: Arjun Bhan
 * Date: 12/4/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 */

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import static java.lang.Integer.MAX_VALUE;

public class Graph {
	
	private int[][] edges; // adjacency matrix
	private Object[] labels;

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

	public void removeEdge(int source, int target) {
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
					System.out.println(labels[j] + " -> "+ labels[i] + ":" + edges[j][i] + " ");
			}
			System.out.println();
		}
	}


	public int getUnvisitedNeighbor(int vertex, int[] visited) {
		// find an unvisited neighbor of a given vertex
		// if there exist multiple unvisited neighbors, return the first one found
		// if all neighbors are visited, return -1

		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0 && visited[i] != 1)
				return i;
		}
		return -1;
	}


	public boolean detectcycle() {
		// Complete the method to detect cycles in a directed graph
		// Feel free to change the return type, parameters

		int visitNode[] = new int[labels.length];
		Stack<Integer> curNode = new Stack<Integer>();
		int start = 0;

		//Assigning every node as unvisited
		for (int i = 0; i < visitNode.length; i++)
		{
			visitNode[i] = -1;
		}

		curNode.push(start);

		while (!curNode.isEmpty())
		{
			visitNode[start] = 0;
			// Find current node and its neighbors.
			int cur = curNode.peek();
			int neighLis[] = neighbors(cur);
			int neigh=1;


			for(int i = 0; i < neighLis.length; i++)
			{
				//If node has been visited twice return true
				if(visitNode[neighLis[i]] == 0)
				{
					int curCount=0;
					int curVal=MAX_VALUE;
					boolean pre = false;

					//Outputing cycle
					while(curNode.lastElement()!=curVal)
					{
						curVal=curNode.get(curCount);
						curCount++;

						if(curVal==neighLis[i])
							pre=true;

						if(pre==true) {
							System.out.print(curVal);
							System.out.print(", ");
						}
					}

					System.out.println(neighLis[i]);

					return true;
				}

				else if(visitNode[neighLis[i]] == -1)
				{
					neigh = neighLis[i];
				}
			}

			//Marking unvisited nodes as on the stack
			if(visitNode[neigh] == -1)
			{
				visitNode[cur] = 0;
				curNode.push(neigh);
			}

			//Marking nodes as finished
			else
			{
				visitNode[cur] = 1;
				curNode.pop();
			}
		}
		return false;
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
		t.addEdge(2, 1, 1);
		t.addEdge(1, 3, 1);
		t.addEdge(1, 5, 1);
		t.addEdge(2, 3, 1);
		t.addEdge(4, 3, 1);
		t.addEdge(4, 2, 1);
		t.addEdge(5, 4, 1);
		//Test cycle detection
		t.print();
		System.out.println(t.detectcycle());

		t = new Graph(3);
		t.setLabel(0, "A");
		t.setLabel(1, "B");
		t.setLabel(2, "C");
		t.addEdge(1, 0, 1);
		t.addEdge(0, 2, 1);
		t.addEdge(2, 1, 1);
		t.print();
		System.out.println(t.detectcycle());

		t = new Graph(3);

		t.setLabel(0, "A");
		t.setLabel(1, "B");
		t.setLabel(2, "C");
		t.addEdge(0, 1, 1);
		t.addEdge(1, 2, 1);
		t.print();
		System.out.println(t.detectcycle());

		t = new Graph(6);
		t.setLabel(0, "A");
		t.setLabel(1, "B");
		t.setLabel(2, "C");
		t.setLabel(3, "D");
		t.setLabel(4, "E");
		t.setLabel(5, "F");
		t.addEdge(5, 1, 1);
		t.addEdge(4, 2, 1);
		t.addEdge(4, 2, 1);
		t.addEdge(0, 1, 1);
		t.addEdge(1, 2, 1);
		t.addEdge(2, 3, 1);
		t.addEdge(3, 4, 1);
		t.addEdge(4, 1, 1);
		//Test cycle detection
		t.print();
		System.out.println(t.detectcycle());
	}

}
