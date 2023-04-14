package bj1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String temp = bf.readLine();
		StringTokenizer st = new StringTokenizer(temp, " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] node = new int[n + 1];
		int[] rank = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			node[i] = i;
			rank[i] = 1;
		}

		for (int i = 0; i < m; i++) {
			temp = bf.readLine();
			st = new StringTokenizer(temp, " ");
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (op == 0)
				union(a, b, node, rank);
			else if (op == 1) {
				int pa = parent(a, node);
				int pb = parent(b, node);
				if (pa == pb)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}

	}

	public static int parent(int e, int[] node) {
		if (node[e] == e)
			return e;
		return parent(node[e], node);
	}

	public static void union(int a, int b, int[] node, int[] rank) {
		int pa = parent(a, node);
		int pb = parent(b, node);
		if (rank[pa] > rank[pb]) {
			node[pb] = pa;
		} else if (rank[pa] < rank[pb]) {
			node[pa] = pb;
		} else {
			if (pa < pb) {
				node[pb] = pa;
				rank[pa]++;
			} else {
				node[pa] = pb;
				rank[pb]++;
			}
			
		}

	}

}
