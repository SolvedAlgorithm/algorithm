import java.util.Scanner;

public class Main {
	static int I, J;
	static int[][] map;
	// 맨위, 북, 동, 서, 남, 맨 아래
	static int[] dice;
	// 0, 동(오른), 서(왼), 북(위), 남(아래)
	static int[] di = { 0, 0, 0, -1, 1 };
	static int[] dj = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		I = sc.nextInt();
		J = sc.nextInt();
		int k = sc.nextInt();
		map = new int[n][m];
		dice = new int[6];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < k; i++) {
			int op = sc.nextInt();
			UDLR(n, m, op);
		}

	}

	static void UDLR(int n, int m, int op) {
		int ni = I + di[op];
		int nj = J + dj[op];
		if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
			return;
		}
		shuffle(op);
		I = ni;
		J = nj;
		if (map[I][J] != 0) {
			dice[5] = map[I][J];
			map[I][J] = 0;
		} else {
			map[I][J] = dice[5];
		}
		System.out.println(dice[0]);
	}

	static void shuffle(int op) {
		int[] renew = new int[6];

		switch (op) {
		case 1: { // 동
			renew = new int[] { dice[3], dice[1], dice[0], dice[5], dice[4], dice[2] };
			break;
		}
		case 2: { // 서
			renew = new int[] { dice[2], dice[1], dice[5], dice[0], dice[4], dice[3] };
			break;
		}
		case 3: { // 북
			renew = new int[] { dice[4], dice[0], dice[2], dice[3], dice[5], dice[1] };
			break;
		}
		case 4: { // 남
			renew = new int[] { dice[1], dice[5], dice[2], dice[3], dice[0], dice[4] };
			break;
		}

		}
		dice = renew;
	}

}
