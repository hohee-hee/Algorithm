import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashSet<Integer> coinSet = new HashSet<>();
        for(int i = 0 ; i < N ; i++) coinSet.add(Integer.parseInt(br.readLine()));

        ArrayList<Integer> coins = new ArrayList<>(coinSet);
        Collections.sort(coins);

        int[] dp = new int[K+1];
        Arrays.fill(dp, K+2);
        for(int i = 1 ; i <= K ; i++) {
            for(int price : coins) {
                if(i - price < 0) break;
                if(i - price == 0) dp[i] = 1;
                else dp[i] = Math.min(dp[i], dp[i-price] + 1);
            }
        }

        if(dp[K] == K+2) System.out.println(-1);
        else System.out.println(dp[K]);
    }
}