package bj9237;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] inArr = br.readLine().split(" ");
		int[] tree = new int[N];
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(inArr[i]) * (-1);
		}

		Arrays.sort(tree);
		int answer = 0;
		int time = 2;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, time + (tree[i] * (-1)));
			time++;
		}

		System.out.println(answer);

	}

}
