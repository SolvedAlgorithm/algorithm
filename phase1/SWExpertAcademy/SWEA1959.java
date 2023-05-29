import java.util.Scanner;

public class Solution {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			boolean chk = false;

			if (m > n) {
				int temp = m;
				m = n;
				n = temp;
				chk = true;
			}
			int[] a = new int[n];
			int[] b = new int[m];
			if (chk) {
				for (int i = 0; i < m; i++) {
					b[i] = sc.nextInt();
				}
				for (int i = 0; i < n; i++) {
					a[i] = sc.nextInt();
				}
			} else {
				for (int i = 0; i < n; i++) {
					a[i] = sc.nextInt();
				}
				for (int i = 0; i < m; i++) {
					b[i] = sc.nextInt();
				}
			}
			int idx = n - m + 1;
			int sum = 0;
			for (int i = 0; i < idx; i++) {
				int temp = 0;
				for (int j = 0; j < m; j++) {
					temp += a[i + j] * b[j];
				}
				if (temp > sum) {
					sum = temp;
				}
			}
			System.out.println("#" + test_case + " " + sum);

		}
	}

}