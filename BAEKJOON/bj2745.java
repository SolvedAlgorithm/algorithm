import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int b = Integer.parseInt(inArr[1]);
		System.out.println(parseAnswer(inArr[0], b));
//		long b = Long.parseLong(inArr[1]);
//		System.out.println(answer(inArr[0], b));
	}
	public static int parseAnswer(String str, int b) {
		return Integer.parseInt(str, b);
	}

	public static long answer(String str, long b) {
		long answer = 0;
		int len = str.length();
		long idx = 1;
		for (int i = len - 1; i >= 0; i--) {
			char ch = str.charAt(i);
			int n = ch - '0';
			if ('A' <= ch && ch <= 'Z') {
				n = 10 + (ch - 'A');
			}
			answer += n * idx;
			idx *= b;
		}
		return answer;
	}

}