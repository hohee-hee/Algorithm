import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if(input.length() == 0) {
            System.out.println(0);
            return;
        }

        // 1. 10, 20 없애기
        String imposTest = input;
        imposTest = input.replaceAll("10", "");
        imposTest = imposTest.replaceAll("20", "");

        // 만약 아직도 0이 남이있다면 불가능한 경우이다.
        if(imposTest.contains("0")) {
            System.out.println(0);
            return;
        }

        int len = input.length();
        if(len <= 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[len+1];
        dp[0] = 1; dp[1] = 1;

        // dp
        for(int i = 2 ; i <= len ; i++) {
            if(input.charAt(i-1) == '0'){
                dp[i-1] = dp[i-2];
                dp[i] = dp[i-1];
            } else if(input.charAt(i-2) == '1' || (input.charAt(i-2) == '2' && input.charAt(i-1) < '7')){
                dp[i] = dp[i-1]+dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }

            dp[i] %= 1000000;
        }

        System.out.println(dp[len]);
    }
}

