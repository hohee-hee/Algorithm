import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(0);
            return;
        }

        // 1. 소수 구하기
        boolean[] prime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            if (prime[i]) continue;
            for (int j = 2; j * i <= N; j++) {
                if (prime[j * i]) continue;
                prime[j * i] = true;
            }
        }

        // 2. 투포인터
        ArrayList<Integer> sum = new ArrayList<>();
        sum.add(0);
        int prev = 0;
        for(int i = 2 ; i < N+1 ; i++) {
            if(prime[i]) continue;

            sum.add(prev + i);
            prev += i;
        }

        int lp = 0 ;
        int rp = 1;
        int answer = 0;
        while(lp <= rp && lp < sum.size() && rp < sum.size()) {
            int curr = sum.get(rp) - sum.get(lp);
            if(curr >= N) {
                if(curr == N) answer++;
                lp++;
            } else {
                rp++;
            }
        }
        System.out.println(answer);
    }

}

