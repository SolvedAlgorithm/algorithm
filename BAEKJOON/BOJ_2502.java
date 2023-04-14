package bj2502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int n = Integer.parseInt(inArr[0]);
		int k = Integer.parseInt(inArr[1]);

		int[][] dp = new int[n + 1][2];
		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = 0;
			dp[i][1] = 0;
		}
		dp[1][0] = 1;
		dp[2][1] = 1;

		for (int i = 3; i < n + 1; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];

		}

		if (n == 3) {
			System.out.println(1);
			System.out.println(k - 1);
		} else {
			for (int i = 1; i < 50000; i++) {
				int temp = k - i * dp[n][0];
				if (dp[n][1] == 0) {
					continue;
				}
				if (temp % dp[n][1] == 0) {
					System.out.println(i);
					System.out.println(temp / dp[n][1]);
					break;
				}
			}

		}

	}

}
