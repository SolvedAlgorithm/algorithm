package bj3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] number;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inArr = br.readLine().split(" ");
		int x = Integer.parseInt(br.readLine());
		number = new int[n];
		visit = new boolean[n];
		if (n == 1) {
			System.out.println(0);
			System.exit(0);
		}
		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(inArr[i]);
			visit[i] = false;
		}
		Arrays.sort(number);
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (visit[i]) {
				continue;
			}
			int data = x - number[i];
			int idx = BS(n, data);
			if (idx == -1 || idx == i) {
				continue;
			}
			visit[i] = true;
			visit[idx] = true;
			answer++;
		}
		System.out.println(answer);

	}

	public static int BS(int n, int data) {
		int start = 0;
		int end = n - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (number[mid] > data) {
				end = mid - 1;
			} else if (number[mid] == data) {
				return mid;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

}
