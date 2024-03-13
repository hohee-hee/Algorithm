import java.util.*;
import java.io.*;

public class Main{
    public static final int INF = 1_000_002;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] len = new int[N];
        int[] rec = new int[N];
        Arrays.fill(len, Integer.MAX_VALUE);

        int answer = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int idx = Arrays.binarySearch(len, 0, answer + 1, arr[i]);

            
            if(idx >= 0) {
                rec[i] = idx;
                continue;
            }

            idx = -idx - 1;
            len[idx] = arr[i];
            rec[i] = idx;
            if(idx+1 > answer) answer = idx+1;
        }

        sb.append(answer).append("\n");

        int curr = answer-1;
        int[] LIS = new int[answer];
        for(int i = N-1 ; i >=0 ; i--) {
            if(rec[i] == curr) LIS[curr--] = arr[i];
        }
        for(int i = 0 ; i < answer ; i++) sb.append(LIS[i] + " ");
        System.out.println(sb);
    }
}