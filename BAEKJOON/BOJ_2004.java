import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		long n = Long.parseLong(inArr[0]);
		long m = Long.parseLong(inArr[1]);
		long count_2 = count_k(n, 2) - count_k(m, 2) - count_k(n - m, 2);
		long count_5 = count_k(n, 5) - count_k(m, 5) - count_k(n - m, 5);
		System.out.println(Math.min(count_2, count_5));

	}

	public static long count_k(long n, long k) {
		long cnt = 0;
		while (n >= k) {
			cnt += n / k;
			n /= k;
		}
		return cnt;
	}
}
