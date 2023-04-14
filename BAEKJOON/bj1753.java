package bj1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String temp = bf.readLine();
		String[] temp_arr = temp.split(" ");
		int node = Integer.parseInt(temp_arr[0]);
		int edge = Integer.parseInt(temp_arr[1]);
		int start = Integer.parseInt(bf.readLine());

		ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i < node + 1; i++) 
			graph.add(new ArrayList<Edge>());
		
		for (int i = 0; i < edge; i++) {
			temp = bf.readLine();
			temp_arr = temp.split(" ");
			int n1 = Integer.parseInt(temp_arr[0]);
			int n2 = Integer.parseInt(temp_arr[1]);
			int dist = Integer.parseInt(temp_arr[2]);
			graph.get(n1).add(new Edge(n2, dist));
		}

		int[] distance = new int[node + 1];
		for (int i = 1; i < node + 1; i++) 
			distance[i] = Integer.MAX_VALUE;
		
		distance[start] = 0;
		PriorityQueue<Edge> queue = new PriorityQueue();
		queue.add(new Edge(start, 0));
		while (!queue.isEmpty()) {
			Edge popE = queue.poll();
			if (distance[popE.node] < popE.distance)
				continue;
			ArrayList<Edge> popArray = graph.get(popE.node);
			for (int i = 0; i < popArray.size(); i++) {
				if (distance[popArray.get(i).node] > popE.distance + popArray.get(i).distance) {
					distance[popArray.get(i).node] = popE.distance + popArray.get(i).distance;
					queue.add(new Edge(popArray.get(i).node, distance[popArray.get(i).node]));
				}
			}
		}
		for (int i = 1; i < node + 1; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}

	}

}

class Edge implements Comparable<Edge> {
	int node;
	int distance;

	public Edge(int _node, int _distance) {
		this.node = _node;
		this.distance = _distance;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		if (this.distance > o.distance) {
			return 1;
		} else if (this.distance < o.distance) {
			return -1;
		} else {
			return 0;
		}
	}

}
