package bj1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int N = Integer.parseInt(input);
		input = br.readLine();
		String[] temp = input.split(" ");
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(temp[i]);
		}
		
		input = br.readLine();
		temp = input.split(" ");
		int[] B = new int[N];
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(A);
		Arrays.sort(B);
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans += A[i] * B[N-i-1];
		}
		System.out.println(ans);
	}

}
