import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        String REGEXP = "(100+1+|01)+";
        // eof를 만날 때까지
        while (str != null && !str.equals("")){
            boolean chk = Pattern.matches(REGEXP, str);
            sb.append(chk ? "SUBMARINE" : "NOISE").append("\n");
            str = br.readLine();
        }
        System.out.println(sb);
    }
}
