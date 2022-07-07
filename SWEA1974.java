import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = 9;
            int[][] map = new int[n][n];
            for(int  i = 0 ; i < n; i++){
                for(int j = 0; j < n; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            int answer = 0;
			if(check_horizontal(map)&&check_vertical(map)&&check_quad(map)){
                answer = 1;
            }
            System.out.println("#" + test_case+ " " + answer);
		}
	}
    public static boolean[] init(){
        boolean[] chk = new boolean[10];
        for(int i = 0; i < 10; i++){
            chk[i] = false;
        }
        return chk;
    }
    public static boolean check_horizontal(int[][] map){
        for(int i = 0; i < 9; i++){
            boolean[] chk = init();
            for(int j = 0; j < 9; j++){
                if(chk[map[i][j]]){
                    return false;
                }else{
                    chk[map[i][j]] = true;
                }
            }
        }
        return true;
    }
    public static boolean check_vertical(int[][] map){
        for(int i = 0; i < 9; i++){
            boolean[] chk = init();
            for(int j = 0; j < 9; j++){
                if(chk[map[j][i]]){
                    return false;
                }else{
                    chk[map[j][i]] = true;
                }
            }
        }
        return true;
    }
    public static boolean check_quad(int[][] map){
        int[] idx = {0, 3, 6};
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                boolean[] chk = init();
         		for(int k = 0; k < 3; k++){
                    for(int p = 0; p < 3; p++){
                        int a = map[idx[i]+k][idx[j]+p];
                        if(chk[a]){
                            return false;
                        }else{
                            chk[a] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}