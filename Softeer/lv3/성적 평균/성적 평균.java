import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());    
        int K  = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int[] score = new int[N+1];
        int[] sum = new int[N+1]; // [0] ~ [i] 까지의 합 저장

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i < N+1 ; i++){
            score[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + score[i];
        }    

        for(int tc = 0 ; tc < K ; tc++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            double avg = (sum[B] - sum[A-1]) / (double) (B-A+1);

            sb.append(String.format("%,.2f", avg) + "\n");
        }

        System.out.println(sb);
    }
}