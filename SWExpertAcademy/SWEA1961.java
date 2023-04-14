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
			int n = sc.nextInt();
           	int[][] map = new int[n][n];
            for(int i = 0; i < n; i++){
             	for(int j = 0; j < n; j++){
                 	map[i][j] = sc.nextInt();   
                }
            }
            int[][] r90 = rotate90(n, map);
            int[][] r180 = rotate90(n, r90);
            int[][] r270 = rotate90(n, r180);
            StringBuffer sb = new StringBuffer();
            System.out.println("#"+test_case);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    sb.append(r90[i][j]);
                }
                sb.append(" ");
                for(int j = 0; j < n; j++){
                    sb.append(r180[i][j]);
                }
                sb.append(" ");
                for(int j = 0; j < n; j++){
                    sb.append(r270[i][j]);
                }
                if(i != n-1){
	                sb.append("\n");
                }
             }
            System.out.println(sb.toString());
		}
	}
    public static int[][] rotate90(int n, int[][] map){
    	int[][] rotate = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                rotate[i][j] = map[n-j-1][i];
            }
        }
        return rotate;
    }
}