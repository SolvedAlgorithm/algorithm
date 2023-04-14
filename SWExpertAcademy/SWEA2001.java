import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] inArr = br.readLine().split(" ");
			int n = Integer.parseInt(inArr[0]);
			int k = Integer.parseInt(inArr[1]);
			int[][] map = new int[n][n];
			int[][] sum = new int[n][n];
			for (int i = 0; i < n; i++) {
				inArr = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(inArr[j]);
					sum[i][j] = 0;
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sum[i][j] += map[i][j];
					if (i - 1 > -1) {
						sum[i][j] += sum[i - 1][j];
					}
					if (j - 1 > -1) {
						sum[i][j] += sum[i][j-1];
					}
					if (i - 1 > -1 && j - 1 > -1) {
						sum[i][j] -= sum[i - 1][j - 1];
					}

				}
			}
			int answer = 0;
			for (int i = k - 1; i < n; i++) {
				for (int j = k - 1; j < n; j++) {
					int temp = sum[i][j];
					int a = i - k;
					int b = j - k;
					if(a > -1) {
						temp -= sum[a][j];
					}
					if(b > -1) {
						temp -= sum[i][b];
					}
					if(a > -1 && b > -1) {
						temp += sum[a][b];
					}
					answer = Math.max(answer, temp);
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}

}