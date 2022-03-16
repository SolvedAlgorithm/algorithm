package bj1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Advanced {

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
		Node[] B = new Node[N];
		for(int i = 0; i < N; i++) {
			int t = Integer.parseInt(temp[i]);
			B[i] = new Node(t, i);
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum = 0;
		int[] rearrangeA = new int[N];
		
		for(int i = N-1; i >= 0; i--) {
			sum += B[i].value * A[N - i - 1];
			rearrangeA[B[i].idx] = A[N - i - 1];
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(rearrangeA[i] + " ");
		}
		System.out.println("");
		System.out.println(sum);
	}

}

class Node implements Comparable<Node>{
	int value, idx;
	public Node(int v, int i) {
		this.value = v;
		this.idx = i;
	}
	@Override
	public int compareTo(Node o) {
		if(this.value > o.value) return 1;
		else if(this.value == o.value) return 0;
		else return -1;
	}
	
	
}
