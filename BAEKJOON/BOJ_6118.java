package bj6118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int n = Integer.parseInt(inArr[0]);
		int m = Integer.parseInt(inArr[1]);
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int[] dist = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<Integer>());
			dist[i] = 0;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			inArr = br.readLine().split(" ");
			int a = Integer.parseInt(inArr[0]);
			int b = Integer.parseInt(inArr[1]);

			graph.get(a).add(b);
			graph.get(b).add(a);
			if (a == 1) {
				queue.add(b);
				dist[b] = 1;
			}
			if (b == 1) {
				queue.add(a);
				dist[a] = 1;
			}
		}
		int far = 1;
		while (!queue.isEmpty()) {
			int pop = queue.poll();
			ArrayList<Integer> temp = graph.get(pop);
			for (int i = 0; i < temp.size(); i++) {
				if (dist[temp.get(i)] > 0 || temp.get(i) == 1) {
					continue;
				}
				dist[temp.get(i)] = dist[pop] + 1;
				far = Math.max(far, dist[temp.get(i)]);
				queue.add(temp.get(i));
			}
		}
		int cnt = 0;
		int answer = 0;
		for(int i = n; i > 1; i--) {
			if(dist[i] == far) {
				answer = i;
				cnt++;
			}
		}
		System.out.println(answer + " " + far + " " + cnt);

	}

}
