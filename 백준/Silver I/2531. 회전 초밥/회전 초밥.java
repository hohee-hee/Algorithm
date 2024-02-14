import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for(int i = 0 ; i < N ; i++) sushi[i] = Integer.parseInt(br.readLine());

        // 초기 셋팅
        int[] eatenCnt = new int[D+1];
        eatenCnt[C]++;
        int cnt = 1; // 쿠폰
        for(int i = 0 ; i < K ; i++) {
            if(eatenCnt[sushi[i]] == 0) cnt++;
            eatenCnt[sushi[i]]++;
        }
        int answer = cnt;

        int lp = 1;
        int rp = K % N;
        while(lp < N) {
            int prevSushi = sushi[lp-1];
            int newSushi = sushi[rp];

            // 이전 lp 지우기
            eatenCnt[prevSushi]--;
            if(eatenCnt[prevSushi] == 0) cnt--;

            // 현재 rp 더하기
            eatenCnt[newSushi]++;
            if(eatenCnt[newSushi] == 1) cnt++;

            answer = Math.max(answer, cnt);

            lp += 1; rp = (rp+1)%N;
        }
        System.out.println(answer);
    }
}

