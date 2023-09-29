import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    static class MyWord implements Comparable<MyWord> {
        String word;
        int len, frequency;

        public MyWord(String word, int frequency) {
            this.word = word;
            this.len = word.length();
            this.frequency = frequency;
        }

        @Override
        public int compareTo(MyWord o) {
            int f = Integer.compare(o.frequency, this.frequency);
            if (f == 0) {
                int l = Integer.compare(o.len, this.len);
                if (l == 0) {
                    return this.word.compareTo(o.word);
                }
                return l;
            }
            return f;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int N = Integer.parseInt(inArr[0]);     // N : 단어 개수
        int M = Integer.parseInt(inArr[1]);     // M : 단어 길이 기준
        HashMap<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            dict.put(str, dict.getOrDefault(str, 0) + 1);
        }
        // end input

        PriorityQueue<MyWord> PQ = new PriorityQueue<>();
        for (String key : dict.keySet()) {
            if (key.length() < M) {
                continue;
            }
            PQ.add(new MyWord(key, dict.get(key)));
        }
        StringBuilder sb = new StringBuilder();
        while (!PQ.isEmpty()) {
            MyWord word = PQ.poll();
            sb.append(word.word).append("\n");
        }
        System.out.println(sb);
    }
}
