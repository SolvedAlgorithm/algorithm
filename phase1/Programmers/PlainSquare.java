import java.lang.Math;
class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        long weight = Math.max(w, h);
        long height = Math.min(w, h);
        long gcd = gcd(weight, height);
        long wq = weight;
        long hq = height;
        if(gcd != 1){
            wq /= gcd;
            hq /= gcd;
        }
        answer = weight * height - (wq + hq - 1) * gcd;
        return answer;
    }
    public static long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}