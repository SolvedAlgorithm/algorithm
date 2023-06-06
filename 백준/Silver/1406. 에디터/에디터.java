import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			left.add(input.charAt(i));
		}
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] inArr = br.readLine().split(" ");
			switch (inArr[0]) {
			case "P": {
				left.add(inArr[1].charAt(0));
				break;
			}
			case "L": {
				if (left.isEmpty()) {
					continue;
				}
				char a = left.pop();
				right.add(a);
				break;
			}
			case "D": {
				if (right.isEmpty()) {
					continue;
				}
				char a = right.pop();
				left.add(a);
				break;
			}
			case "B": {
				if (left.isEmpty()) {
					continue;
				}
				left.pop();
				break;
			}
			}
		}
		StringBuffer sb = new StringBuffer();
		String answer = "";
		while(!left.isEmpty()) {
			char a = left.pop();
			sb.append(a);
		}
		answer += sb.reverse().toString();
		sb = new StringBuffer();
		while(!right.isEmpty()) {
			char a = right.pop();
			sb.append(a);
		}
		System.out.println(answer + sb.toString());
	}
}