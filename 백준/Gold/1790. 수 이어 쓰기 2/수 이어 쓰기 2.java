import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N_str = st.nextToken();
        int N_len = N_str.length();
        int N = Integer.parseInt(N_str);
        int K = Integer.parseInt(st.nextToken());

        // 1. 길이 구하기
        int[] maxLen = new int[N_len];
        int len = 0;
        int ten = 10;
        int prev = 0;
        int K_range = 0;
        for(int i = 1 ; i < N_len ; i++) {
            maxLen[i] = (ten-1-prev) * i;
            prev = ten-1;
            ten *= 10;
            len += maxLen[i];
             if(K_range == 0 && K <= len) K_range = i;
        }
        len += (N - prev) * N_len;
        if(K > len) {
            System.out.println(-1);
            return;
        }


        if(K_range == 0) K_range = N_len;

        // 2. 숫자 찾기
        ten = 1;
        for(int i = 1 ; i < K_range ; i++) {
            K -= maxLen[i];
            ten *= 10;
        }
        int targetNum = K % K_range == 0 ? K / K_range + (ten-1) : K / K_range + (ten-1)+1;

        int digit = K % K_range == 0 ? K_range : K % K_range;
        for(int i = K_range ; i > digit ; i--) targetNum /= 10;
        int answer = targetNum % 10;
        System.out.println(answer);
    }
}