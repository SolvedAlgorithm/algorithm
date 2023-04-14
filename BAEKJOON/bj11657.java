package bj11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int N = Integer.parseInt(inArr[0]);
		int M = Integer.parseInt(inArr[1]);
		long[] distance = new long[N + 1];
		Edge[] edges = new Edge[M];

		for (int i = 0; i < N + 1; i++) {
			distance[i] = Long.MAX_VALUE;
		}
		for (int i = 0; i < M; i++) {
			inArr = br.readLine().split(" ");
			edges[i] = new Edge(Integer.parseInt(inArr[0]), Integer.parseInt(inArr[1]), Integer.parseInt(inArr[2]));
		}
		int start = 1;
		boolean chk = false;
		for (int i = 0; i < N; i++) {
			distance[start] = 0;
			for (int j = 0; j < M; j++) {
				int current = edges[j].departure;
				int next = edges[j].arrive;
				long cost = edges[j].cost;
				if (distance[current] != Long.MAX_VALUE && distance[next] > distance[current] + cost) {
					distance[next] = distance[current] + cost;
					if (i == N - 1) {
						chk = true;
						break;
					}
				}
			}
			if (chk) {
				break;
			}
		}

		if (chk) {
			System.out.println(-1);
		} else {
			for (int i = 2; i < N + 1; i++) {
				if (distance[i] == Long.MAX_VALUE) {
					System.out.println(-1);
				} else {
					System.out.println(distance[i]);
				}
			}
		}
	}

}

class Edge {
	int departure, arrive;
	long cost;

	public Edge(int d, int a, long c) {
		this.departure = d;
		this.arrive = a;
		this.cost = c;
	}

}
