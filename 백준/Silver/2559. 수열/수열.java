import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sum = new int[N];
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i < K) {
                sum[i] = i > 0 ? sum[i-1] + arr[i] : arr[i];
                if(i == K-1) answer = sum[i];
            } else {
                sum[i] = sum[i-1] + arr[i] - arr[i-K];
                if(sum[i] > answer) answer = sum[i];
            }
        }


        System.out.println(answer);
    }
}