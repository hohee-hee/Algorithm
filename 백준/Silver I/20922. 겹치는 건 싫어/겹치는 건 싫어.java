import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        int target = 0; int lp = 0; int rp = 0;
        int[] dup = new int[100001];
        int answer = 0;
        while(lp <= rp && rp < N) {
            if(dup[arr[rp]] < K) {
                dup[arr[rp++]]++;
            } else {
                answer = Math.max(answer, rp-lp);
                dup[arr[lp++]]--;
            }
        }

        if(rp == N) answer = Math.max(answer, rp-lp);

        System.out.println(answer);
    }
}