package bj5972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int N = Integer.parseInt(inArr[0]);
		int M = Integer.parseInt(inArr[1]);

		int[] distance = new int[N + 1];
		ArrayList<ArrayList<Tuple>> map = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			distance[i] = Integer.MAX_VALUE;
			map.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			inArr = br.readLine().split(" ");
			int d = Integer.parseInt(inArr[0]);
			int a = Integer.parseInt(inArr[1]);
			int c = Integer.parseInt(inArr[2]);
			map.get(d).add(new Tuple(a, c));
			map.get(a).add(new Tuple(d, c));
		}
		PriorityQueue<Tuple> pq = new PriorityQueue<>();
		distance[1] = 0;
		pq.add(new Tuple(1, 0));
		while (!pq.isEmpty()) {
			Tuple pop = pq.poll();
			int cur = pop.node;
			int cow = pop.cow;
			
			if (distance[cur] < cow) {
				continue;
			}
			int size = map.get(cur).size();
			for (int i = 0; i < size; i++) {
				int next = map.get(cur).get(i).node;
				int next_cow = map.get(cur).get(i).cow;
				if (distance[next] > next_cow + cow) {
					distance[next] = next_cow + cow;
					pq.add(new Tuple(next, distance[next]));
				}
			}
		}
		System.out.println(distance[N]);

	}

}

class Tuple implements Comparable<Tuple> {
	int node, cow;

	public Tuple(int e, int c) {
		this.node = e;
		this.cow = c;
	}

	public int compareTo(Tuple oth) {
		if (this.cow > oth.cow) {
			return 1;
		} else if (this.cow == oth.cow) {
			return 0;
		} else {
			return -1;
		}
	}
}
