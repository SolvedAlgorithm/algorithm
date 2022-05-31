package bj16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		long init = Long.parseLong(inArr[0]);
		long goal = Long.parseLong(inArr[1]);
		int answer = 1;
		while (true) {
			if (init == goal) {
				break;
			} else if (init > goal) {
				answer = -1;
				break;
			}
			if (goal % 10 == 1) {
				goal = goal / 10;
			} else if (goal % 2 == 0) {
				goal = goal / 2;
			} else {
				answer = -1;
				break;
			}
			answer++;

		}
		System.out.println(answer);
	}

}