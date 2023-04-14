import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] inArr = br.readLine().split(" ");
			int n = Integer.parseInt(inArr[0]);
			int k = Integer.parseInt(inArr[1]);
			int cnt = 0;
			String[] heights = new String[n];
			for (int i = 0; i < n; i++) {
				heights[i] = "";
			}
			int one = 0;
			for (int i = 0; i < n; i++) {
				inArr = br.readLine().split(" ");
				one = 0;
				for (int j = 0; j < n; j++) {
					heights[j] = heights[j] + inArr[j];
					if (inArr[j].equals("1")) {
						one++;
					} else if (inArr[j].equals("0")) {
						if (one == k) {
							cnt++;
						}
						one = 0;
					}
				}
				if (one == k) {
					cnt++;
				}
			}
			for (int i = 0; i < n; i++) {
				one = 0;
				for (int j = 0; j < n; j++) {
					if (heights[i].charAt(j) == '1') {
						one++;
					} else if (heights[i].charAt(j) == '0') {
						if (one == k) {
							cnt++;
						}
						one = 0;
					}
				}
				if (one == k) {
					cnt++;
				}
			}
			
			System.out.println("#" + test_case + " " + cnt);
		}
	}

}