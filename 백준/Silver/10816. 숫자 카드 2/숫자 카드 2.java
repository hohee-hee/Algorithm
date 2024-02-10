import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.parallelSort(arr);

        // 2. 찾기
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        find: for(int i = 0 ; i < M ; i++) {
            int target = Integer.parseInt(st.nextToken());
            int sp = 0;
            int ep = N;
            int mid = (ep+sp) / 2;

            while(sp < ep) {
                if(arr[mid] >= target) ep = mid;
                else sp = mid+1;
                mid = (ep+sp) / 2;
            }
            int minIdx = sp;

            sp = 0;
            ep = N;
            mid = (ep+sp) / 2;
            while(sp < ep) {
                if(arr[mid] > target) ep = mid;
                else sp = mid+1;
                mid = (ep+sp) / 2;
            }
            int maxIdx = sp;
            sb.append(maxIdx - minIdx).append("\n");
        }
        System.out.println(sb);
    }
}