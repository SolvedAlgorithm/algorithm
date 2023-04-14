package bj11576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		long A = Long.parseLong(inArr[0]);
		long B = Long.parseLong(inArr[1]);
		int n = Integer.parseInt(br.readLine());
		
		inArr = br.readLine().split(" ");
		long temp = Ato10(A, inArr, n);
		String answer = to10B(B, temp);
		System.out.println(answer.substring(1));
		
	}
	public static long Ato10(long A, String[] arr, int n) {
		long temp = 1;
		long answer = 0;
		for(int i = n-1; i >= 0; i--) {
			answer += Long.parseLong(arr[i]) * temp;
			temp *= A;
		}
		return answer;
	}
	
	public static String to10B(long B, long num) {
		StringBuffer sb = new StringBuffer();
		while(true) {
			long temp = num % B;
			while(true) {
				sb.append(temp % 10);
				temp /= 10;
				if(temp == 0) {
					break;
				}
			}
			sb.append(" ");
			num /= B;
			if(num == 0) {
				break;
			}
		}
		return sb.reverse().toString();
	}
}
