package bj13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = Integer.parseInt(input);
		long[] distance = new long[N-1];
		long[] prices = new long[N];
		
		input = br.readLine();
		String[] temp = input.split(" ");
		for(int i = 0; i < N-1; i++) {
			distance[i] = Long.parseLong(temp[i]);
		}
		input = br.readLine();
		temp = input.split(" ");
		for(int i = 0; i < N; i++) {
			prices[i] = Long.parseLong(temp[i]);
		}
		
		long answer = distance[0] * prices[0];
		long minPrice = prices[0];
		for(int i = 1; i < N -1; i++) {
			if(minPrice > prices[i]) {
				minPrice = prices[i];
			}
			answer += minPrice * distance[i];
		}
		
		System.out.println(answer);
		
	}

}
