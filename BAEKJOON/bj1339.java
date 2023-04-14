package bj1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		String str = br.readLine();
		int n = Integer.parseInt(str);

		int[] alpha = new int[26];
		for (int i = 0; i < 26; i++) {
			alpha[i] = 0;
		}

		for (int i = 0; i < n; i++) {
			str = br.readLine();
			int len = str.length();
			for (int j = 0; j < len; j++) {
				alpha[str.charAt(j) - 'A'] += Math.pow(10, len - j - 1);
			}
		}

		for (int i = 0; i < 26; i++) {
			if (alpha[i] == 0)
				continue;
			pq.add((-1) * alpha[i]);
		}

		int idx = 9;
		int answer = 0;
		while (!pq.isEmpty()) {
			int a = (-1) *  pq.poll();
			answer += a * idx;
			idx--;
		}
		System.out.println(answer);

	}

}
