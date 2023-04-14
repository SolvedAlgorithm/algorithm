package bj2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input =br.readLine();
		String[] inArr = input.split(" ");
		int N = Integer.parseInt(inArr[0]);
		int op = Integer.parseInt(inArr[1]) + Integer.parseInt(inArr[2]);
		long[] num = new long[N];
		for(int i = 0; i < N; i++) {
			input = br.readLine();
			num[i] = Long.parseLong(input);
		}
		SegmentTree st = new SegmentTree(N, num);
		for(int i = 0; i < op; i++) {
			input = br.readLine();
			inArr = input.split(" ");
			int opCode = Integer.parseInt(inArr[0]);
			if(opCode == 1) {	//update
				int idx = Integer.parseInt(inArr[1]);
				long value = Long.parseLong(inArr[2]);
				long old = st.getNumValue(idx-1);
				st.setNumValue(idx-1, value);
				st.update(0, N-1, 1, idx-1, value - old);
				
			}else if(opCode == 2) {		//sum
				int left = Integer.parseInt(inArr[1]);
				int right = Integer.parseInt(inArr[2]);
				System.out.println(st.sum(0, N-1, 1, left-1, right-1));
			}
		}
	}

}
class SegmentTree {
	long[] num, tree;
	public SegmentTree(int N, long[] n) {
		this.tree = new long[N*4];
		this.num = n;
		init(0, N-1, 1);
	}
	public long init(int start, int end, int nodeN) {
		if(start == end) {
			return this.tree[nodeN] = this.num[start];
		}
		int mid = (start + end) / 2;
		return this.tree[nodeN] = init(start, mid, nodeN*2) + init(mid+1, end, nodeN*2 + 1);
	}
	public long sum(int start, int end, int nodeN, int left, int right) {
		if(left > end || right < start) return 0;
		if(left <= start && end <= right)return this.tree[nodeN];
		int mid = (start + end) / 2;
		return sum(start, mid, nodeN *2, left, right) + sum(mid+1, end, nodeN*2+1, left, right);
	}
	public void update(int start, int end, int nodeN, int idx, long diff) {
		if(idx < start || idx > end) return;
		this.tree[nodeN] += diff;
		if(start == end) return;
		int mid = (start + end) / 2;
		update(start, mid, nodeN*2, idx, diff);
		update(mid+1, end, nodeN*2+1, idx, diff);
	}
	public long getNumValue(int idx) {
		return this.num[idx];
	}
	public void setNumValue(int idx, long value) {
		this.num[idx] = value;
	}

}
