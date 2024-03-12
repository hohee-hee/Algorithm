import java.util.*;
import java.io.*;

public class Main{
    public static final int INF = 1_000_002;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] LIS = new int[N];
        Arrays.fill(LIS, INF);

        int answer = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int idx = Arrays.binarySearch(LIS, arr[i]);
            if(idx >= 0) continue;
            idx = -idx - 1;
            LIS[idx] = arr[i];
            if(idx+1 > answer) answer = idx+1;
        }

        System.out.println(answer);
    }
}