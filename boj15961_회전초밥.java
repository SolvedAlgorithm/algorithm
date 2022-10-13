package boj15961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 2531번과 같은 문제지만 N이 최대 3000000이기 때문에 2531번처럼 풀 수 없으
 * 초밥 종류를 먹은 걸 체크할 때 boolean[]으로 하지말고, int[]로 체크하자.
 * 
 * 처음에 0번 접시부터 k개를 먹는다.
 * 다음 경우는 0번 접시를 안 먹고, (1 + k - 1) 번 접시를 먹는다.
 * 그 다음 경우는 1번 접시를 안 먹고, (2 + k - 1) 번 접시를 먹는다.
 * 
 * 이때, 순환해야하기 때문에 나머지 연산을 해줘야 한다.
 * 
 * 안 먹고서 count 배열의 값이 0이 되면 가짓수를 -1
 * 먹고서 count 배열의 값이 1이 되면 가짓수를 +1
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int N = Integer.parseInt(inArr[0]); // 접시 수
		int d = Integer.parseInt(inArr[1]); // 초밥 종류 수
		int k = Integer.parseInt(inArr[2]); // 연속해서 먹는 접시 수
		int eat = Integer.parseInt(inArr[3]); // 쿠폰으로 먹는 초밥 번호
		int[] sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		} // end input;
		int[] count = new int[d + 1];
		int max = 0;
		for (int i = 0; i < k; i++) {
			if (count[sushi[i]] == 0) {
				max++;
			}
			count[sushi[i]]++;
		}
		int cnt = max;
		if (count[eat] == 0) { // 쿠폰으로 주는 초밥 안먹었으면 max++
			max++;
		}
		for (int start = 1; start < N; start++) {
			int end = (start + k - 1) % N; // start를 시작으로 k개 먹었을 때 먹는 마지막 초밥
			count[sushi[start - 1]]--; // 이제 안먹어야 하는 초밥 --
			if (count[sushi[start - 1]] == 0) { // 안먹어야 하는 초밥 안먹었는데 0이면 가짓수 줄이기
				cnt--;
			}

			count[sushi[end]]++; // 마지막 초밥 먹기 ++

			if (count[sushi[end]] == 1) { // 마지막 초밥 먹었을 때 1이면 가짓수 키우기
				cnt++;
			}
			if (count[eat] == 0) { // 쿠폰으로 주는 초밥 안먹었으면 가짓수 키우기
				cnt++;
			}
			max = Math.max(max, cnt); // max값 update
			if (count[eat] == 0) { // 쿠폰으로 주는 초밥 이제 안먹은 걸로 해주기 --
				cnt--;
			}
		}
		System.out.println(max);
	}

}