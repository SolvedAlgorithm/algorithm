package bj16398;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int[] root;
	static int[] rank;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(s);
		root = new int[n];
		rank = new int[n];
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			s = br.readLine();
			String[] temp = s.split(" ");
			for (int j = i; j < n; j++) {
				int temp_int = Integer.parseInt(temp[j]);
				if (temp_int != 0) {
					pq.add(new Edge(i, j, temp_int));
				}
			}
			root[i] = i;
			rank[i] = 1;
		}

		long answer = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll();

			if (union(e.a, e.b)) {
				answer += e.cost;
			}

			if (chk(n)) {
				break;
			}
		}
		System.out.println(answer);

	}

	public static boolean chk(int n) {
		int init = root[0];
		for (int i = 1; i < n; i++) {
			if (init != root[i]) {
				return false;
			}
		}
		return true;
	}

	public static int find(int a) {
		if (root[a] == a) {
			return a;
		}
		return root[a] = find(root[a]);
	}

	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b) {
			return false;
		}
		if (rank[a] > rank[b]) {
			root[b] = a;
		} else {
			if (rank[a] == rank[b]) {
				rank[b]++;
			}
			root[a] = b;
		}
		return true;
	}

}

class Edge implements Comparable<Edge> {
	int a, b, cost;

	public Edge(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.cost = c;
	}

	public int compareTo(Edge other) {
		if (this.cost > other.cost) {
			return 1;
		} else if (this.cost == other.cost) {
			return 0;
		} else {
			return -1;
		}
	}
}
