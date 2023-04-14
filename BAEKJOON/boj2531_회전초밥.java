package boj2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
 * 0번 접시부터 K개씩 먹고 마지막에 쿠폰 접시를 먹고 먹은 종류를 count
 * 0번 접시가 시작, 1번 접시가 시작 ... N-1번 접시가 시작 
 * 총 N개의 경우의 수를 모두 본다.
 * N이 최대 30000이기 때문에 가능.
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int N = Integer.parseInt(inArr[0]);
		int d = Integer.parseInt(inArr[1]);
		int k = Integer.parseInt(inArr[2]);
		int eat = Integer.parseInt(inArr[3]);
		int[] sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
			
		} // end input;

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			boolean[] check = new boolean[d + 1];
			check[eat] = true;
			int size = 1;
			for (int j = 0; j < k; j++) {
				if(size + (k-j) < max) {
					break;
				}
				int idx = (i + j) % N;
				if (check[sushi[idx]])
					continue;
				check[sushi[idx]] = true;
				size++;
			}
			max = Math.max(max, size);
		}
		System.out.println(max);
	}

}
