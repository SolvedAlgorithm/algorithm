package bj1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int N = Integer.parseInt(inArr[0]);
		int S = Integer.parseInt(inArr[1]);
		inArr = br.readLine().split(" ");
		int[] number = new int[N];
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(inArr[i]);
		}

		int start = 0;
		int end = 1;

		int partial_sum = number[0];
		int answer = Integer.MAX_VALUE;

		while (start < end) {
			if (partial_sum < S) {
				if (end < N) {
					partial_sum += number[end++];
				} else {
					start++;
				}
			} else {
				answer = Math.min(answer, end - start);
				if (answer == 1) {
					break;
				}
				partial_sum -= number[start++];
			}
			partial_sum = Math.max(partial_sum, 0);

		}
		if (answer == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}
	}

}
