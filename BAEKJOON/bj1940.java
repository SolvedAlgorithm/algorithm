package bj1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] num;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String[] inArr = br.readLine().split(" ");
		if (N == 1) {
			System.out.println(0);
			System.exit(0);
		}
		visit = new boolean[N];
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(inArr[i]);
			visit[i] = false;
		}

		int answer = 0;
		Arrays.sort(num);

		for (int i = 0; i < N; i++) {
			if (visit[i]) {
				continue;
			}
			int a = BS(0, N - 1, M - num[i]);
			if (a == i) {
				continue;
			}
			if (a != -1) {
				if (visit[a]) {
					continue;
				}
				visit[i] = true;
				visit[a] = true;
				answer++;
			}
		}
		System.out.println(answer);

	}

	public static int BS(int start, int end, int data) {
		int answer = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (num[mid] > data) {
				end = mid - 1;
			} else if (num[mid] == data) {
				return mid;
			} else {
				start = mid + 1;
			}
		}
		return answer;
	}

}
