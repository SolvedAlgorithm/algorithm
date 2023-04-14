package bj5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int F = Integer.parseInt(inArr[0]);
		int S = Integer.parseInt(inArr[1]);
		int G = Integer.parseInt(inArr[2]);
		int[] UD = { Integer.parseInt(inArr[3]), -Integer.parseInt(inArr[4]) };

		int[] floors = new int[F + 1];
		for (int i = 1; i < F + 1; i++) {
			floors[i] = Integer.MAX_VALUE;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(S);
		floors[S] = 0;
		while (!queue.isEmpty()) {
			int a = queue.poll();
			for (int i = 0; i < 2; i++) {
				int A = a + UD[i];
				if (A > F || A <= 0) {
					continue;
				}
				if (floors[A] <= floors[a] + 1) {
					continue;
				}
				floors[A] = floors[a] + 1;
				queue.add(A);

			}

		}
		if (floors[G] == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		} else {
			System.out.println(floors[G]);
		}
	}

}
