import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = "";

		while ((temp = br.readLine()) != null) {
			String[] temp_split = temp.split(" ");
			long tryN = Long.parseLong(temp_split[0]);
			long win = Long.parseLong(temp_split[1]);
			long Z = ((win * 100) / tryN);
			if (tryN == win || Z == 99) {
				System.out.println(-1);
			} else {
				System.out.println(answer(tryN, win, Z));
			}
		}
	}

	public static long answer(long tryN, long win, long Z) {
		long start = 1;
		long end = (long) tryN;
		long ans = -1;
		while (start <= end) {
			long mid = (start + end) / 2;
			long chk = (win + mid) * 100 / (tryN + mid);
			if (chk > Z) {
				end = mid - 1;
				ans = mid;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

}
