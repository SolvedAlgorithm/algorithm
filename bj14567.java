package bj14567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] answer;
	static ArrayList<ArrayList<Integer>> subjects;
	static int[] in;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int N = Integer.parseInt(inArr[0]);
		int M = Integer.parseInt(inArr[1]);

		in = new int[N + 1];
		answer = new int[N + 1];
		subjects = new ArrayList<>();

		for (int i = 0; i < N + 1; i++) {
			in[i] = 0;
			answer[i] = 0;
			subjects.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			inArr = br.readLine().split(" ");
			int a = Integer.parseInt(inArr[0]);
			int b = Integer.parseInt(inArr[1]);

			in[b]++;
			subjects.get(a).add(b);
		}
		Queue<Tuple> queue = new LinkedList<>();
		int depth = 1;
		for (int i = 1; i < N + 1; i++) {
			if (in[i] == 0) {
				queue.add(new Tuple(i, depth));
			}
		}

		while (!queue.isEmpty()) {
			Tuple tuple = queue.poll();
			answer[tuple.value] = tuple.depth;
			ArrayList<Integer> t = subjects.get(tuple.value);
			int size = t.size();
			for (int i = 0; i < size; i++) {
				in[t.get(i)]--;
				if (in[t.get(i)] == 0) {
					queue.add(new Tuple(t.get(i), tuple.depth + 1));
				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			System.out.print(answer[i] + " ");
		}
	}

}

class Tuple {
	int value;
	int depth;

	public Tuple(int v, int d) {
		this.value = v;
		this.depth = d;
	}
}
