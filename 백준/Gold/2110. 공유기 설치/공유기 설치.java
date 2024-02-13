
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[] house = new long[N];
        for(int i = 0 ; i < N ; i++) house[i] = Integer.parseInt(br.readLine());
        Arrays.sort(house);

        long s = 1;
        long e = house[N-1] - house[0];
        long mid = 0;
        long answer = 0;
        while(s < e) {
            mid = (s + e + 1) / 2;

            // 체크
            long router = 1; // 0번자리엔 무조건 설치하기
            long curr = house[0];
            for(int i = 1 ; i < N ; i ++) {
                if(curr + mid > house[i]) continue;

                curr = house[i];
                router++;
            }

            if(router == 3) answer = mid;

            if(router >= C) {
                s = mid;
            } else {
                e = mid-1;
            }
        }

        System.out.println(s);
    }
}
