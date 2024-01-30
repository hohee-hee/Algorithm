import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= i ; j++) {
                int num = Integer.parseInt(st.nextToken());
                tri[i][j] = Math.max(tri[i-1][j-1], tri[i-1][j]) + num;
            }
        }

        int answer = 0;
        for(int i = 1 ; i <= n ; i++) {
            if(answer < tri[n][i]) answer = tri[n][i];
        }

        System.out.println(answer);
    }
}

