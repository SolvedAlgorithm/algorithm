import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Stack stack = new Stack();
		Scanner sc = new Scanner(System.in);
		
		String text = sc.next();
		int sum = 0;
		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == '(') {
				stack.push(text.charAt(i));
			}
			if(text.charAt(i) == ')') {
				stack.pop();
				if(text.charAt(i - 1) == '(') {
					sum += stack.size();
				}else {
					sum++;
				}
			}
			
		}
		System.out.println(sum);
		
	}

}