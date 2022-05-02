package bj3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inArr = br.readLine().split(" ");
		int x = Integer.parseInt(br.readLine());
		int[] number = new int[n];
		if (n == 1) {
			System.out.println(0);
			System.exit(0);
		}
		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(inArr[i]);
		}
		Arrays.sort(number);
		int answer = 0;
		int start = 0;
		int end = n-1;
		while(start < end) {
			if(start == n || end == -1) {
				break;
			}
			int temp = number[start] + number[end];
			if(temp == x) {
				answer++;
				start++;
				end--;
			}else if(temp > x) {
				end--;
			}else {
				start++;
			}
		}
		System.out.println(answer);
		
	}

}
