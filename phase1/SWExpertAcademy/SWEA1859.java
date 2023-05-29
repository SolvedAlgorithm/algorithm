package SWEA1859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			String[] inArr = br.readLine().split(" ");
			long[] prices = new long[n];
			long sum = 0;
			for(int i = 0; i < n; i++) {
				prices[i] = Long.parseLong(inArr[i]);
			}
			long max = prices[n-1];
			for(int i = n-2; i >= 0; i--) {
				if(prices[i] < max) {
					sum += max - prices[i];
				}else if(prices[i] > max) {
					max = prices[i];
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}

	}

}
