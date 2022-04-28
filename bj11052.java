package bj11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] cards = new int[n + 1];
		cards[0] = 0;
		String[] inArr = new String[n];
		inArr = br.readLine().split(" ");
		for (int i = 1; i < n + 1; i++) {
			cards[i] = Integer.parseInt(inArr[i - 1]);
		}
		int[] dp = new int[n + 1];
		dp[0] = cards[0];
		dp[1] = cards[1];

		for (int i = 2; i < n + 1; i++) {
			int temp = cards[1] * i;
			temp = Math.max(temp, cards[i]);
			for (int j = 1; j < i; j++) {
				int a = i - j;
				if (a < j) {
					break;
				}
				temp = Math.max(temp, dp[j] + dp[a]);
			}
			dp[i] = temp;
		}

		System.out.println(dp[n]);

	}

}
