import java.util.Scanner;

public class Main9633 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] row = new int[n];
		int result = 0;
		System.out.println(dfs(row, 0));

	}

	public static boolean check(int[] row, int x) {
		for (int i = 0; i < x; i++) {
			if (row[x] == row[i]) {
				return false;
			}
			if (row[x] - row[i] == x - i) {
				return false;
			}
			if (-(row[x] - row[i]) == x - i) {
				return false;
			}
		}
		return true;
	}

	public static int dfs(int[] row, int x) {
		int result = 0;
		if (x == row.length) {
			result++;
		} else {
			for (int i = 0; i < row.length; i++) {
				row[x] = i;
				if (check(row, x)) {
					result += dfs(row, x+1);
				}
			}
		}
		return result;

	}

}
