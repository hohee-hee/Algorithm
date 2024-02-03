import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        HashSet<Integer>[] isPos = new HashSet[N+1];
        for(int i = 1 ; i <= N ; i++) {
            isPos[i] = new HashSet<>();
            if(i != 1) isPos[i].add(i-1);
            isPos[i].add(i);
            if(i != N) isPos[i].add(i+1);
        }

        int pt = 1;
        for(int i = 1 ; i <= M ; i++) {
            int vip = Integer.parseInt(br.readLine());
            if(vip != 1) isPos[vip-1].remove(vip);
            isPos[vip].remove(vip-1);
            isPos[vip].remove(vip+1);
            if(vip != N) isPos[vip+1].remove(vip);
        }


        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = isPos[1].size();
        for(int i = 2 ; i <= N ; i++) {
            if(isPos[i].size() == 3) dp[i] = dp[i-1] + dp[i-2];
            else if(isPos[i].size() <= isPos[i-1].size()) dp[i] = dp[i-1];
            else dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }
}

