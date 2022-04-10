package bj1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		int testcase = Integer.parseInt(temp);
		for(int j = 0; j < testcase; j++) {
			temp = br.readLine();
			int N = Integer.parseInt(temp);
			Grade[] people = new Grade[N];
			for(int k = 0; k < N; k++) {
				temp = br.readLine();
				String[] a = temp.split(" ");
				int d= Integer.parseInt(a[0]);
				int v= Integer.parseInt(a[1]);
				people[k] = new Grade(v, d, k);
			}
			Arrays.sort(people);
			int chk = people[0].view;
			int answer = 1;
			for(int k = 0; k < N; k++) {
				if(chk > people[k].view) {
					chk = people[k].view;
					answer++;
				}
			}
			System.out.println(answer);
		}
		
	}
	

}
class Grade implements Comparable<Grade>{
	int view, doc, idx;
	public Grade(int v, int d, int i) {
		this.view = v;
		this.doc = d;
		this.idx = i;
	}
	public int compareTo(Grade oth) {
		if(this.doc > oth.doc) {
			return 1;
		}else if(this.doc < oth.doc) {
			return -1;
		}else {
			return 0;
		}
	}
	
}