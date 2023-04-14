package bj1059;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String input = br.readLine();
		String[] inArr = input.split(" ");
		int[] num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(inArr[i]);
		}
		Arrays.sort(num);
		int n = Integer.parseInt(br.readLine());
		if(n < num[0]) {
			System.out.println(answer(1, num[0]-1, n));
		}else {
			int idx = idx(num, N, n);
			if(idx == -1) {
				System.out.println(0);
			}else {
				System.out.println(answer(num[idx]+1, num[idx+1]-1, n));
			}
		}

	}
	public static int answer(int a, int b, int n) {
		int A = a > n ? a-n:n-a;
		int B = b > n ? b-n : n-b;
		return (A+1) * (B+1) -1;
	}
	public static int idx(int[] num, int N, int n) {
		if(num[0] == n) {
			return -1;
		}
		for(int i = 1; i < N; i++) {
			if(num[i] == n) {
				return -1;
			}
			if(num[i-1] < n && n < num[i]) {
				return i-1;
			}
		}
		return -1;
	}

}
