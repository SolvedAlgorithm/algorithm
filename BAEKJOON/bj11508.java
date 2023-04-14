import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] input = new int[n];
		
		for(int i = 0; i < n; i++) {
			input[i] = sc.nextInt() * (-1);
		}
		
		Arrays.sort(input);
		
		int minPrice = 0;
		for(int i = 0; i < n; i++) {
			int check = (n-i) / 3;
			if(check > 0) {
				minPrice += (-1)*input[i] + (-1)*input[i+1];
				i += 2;
			}else {
				minPrice += (-1)*input[i];
			}
		}
		
		System.out.println(minPrice);

	}

}
