package bj1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		String answer = isSame(0, 0, n, map);
		if (answer.length() == 1) {
			System.out.println(answer);
		} else {
			System.out.println("(" + answer + ")");
		}
	}

	public static String isSame(int x, int y, int len, int[][] map) {
		StringBuffer sb = new StringBuffer();

		if (len == 1) {
			sb.append(map[x][y]);
			return sb.toString();
		}
		int num = map[x][y];
		boolean chk = true;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (map[x + i][y + j] != num) {
					chk = false;
					break;
				}
			}
			if (!chk)
				break;
		}
		if (chk) {
			sb.append(num);
		} else {
			int[] dx = { 0, 0, len / 2, len / 2 };
			int[] dy = { 0, len / 2, 0, len / 2 };
			for (int i = 0; i < 4; i++) {
				String temp = isSame(x + dx[i], y + dy[i], len / 2, map);
				if (temp.length() == 1) {
					sb.append(temp);
				} else {
					sb.append("(");
					sb.append(temp);
					sb.append(")");
				}
			}
		}
		return sb.toString();
	}

}
