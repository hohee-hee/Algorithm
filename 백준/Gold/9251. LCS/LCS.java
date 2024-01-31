import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int r = 1 ; r <= str1.length() ; r++) {
            for(int c = 1 ; c <= str2.length() ; c++) {
                if(str1.charAt(r-1) == str2.charAt(c-1)) dp[r][c] = dp[r-1][c-1] + 1;
                else dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
    }
}

