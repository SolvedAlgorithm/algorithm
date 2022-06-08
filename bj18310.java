package bj18310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inArr = br.readLine().split(" ");
		int[] antenna = new int[n];
		for (int i = 0; i < n; i++) {
			antenna[i] = Integer.parseInt(inArr[i]);
		}
		Arrays.sort(antenna);
		int mid = (n - 1) / 2;
		while (mid > 0) {
			if (antenna[mid] == antenna[mid - 1]) {
				mid--;
			} else {
				break;
			}
		}
		System.out.println(antenna[mid]);

	}

}
