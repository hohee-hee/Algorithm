import java.util.*;
import java.io.*;

public class Main{

    public static int[] arr, per;
    public static boolean[] isUsed;
    public static int max = 0;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        per = new int[N];
        isUsed = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        bt(0, N);

        System.out.println(max);
    }

    public static void bt(int cnt, int N) {
        if(cnt == N) {
            int sum = 0;
            for(int i = 0 ; i < N-1 ; i++) {
                sum += Math.abs(arr[per[i]] - arr[per[i+1]]);
            }

            if(max < sum) max = sum;
            return;
        }

        for(int i = 0 ; i < N ; i++) {
            if(isUsed[i]) continue;
            per[cnt] = i;
            isUsed[i] = true;
            bt(cnt+1, N);
            isUsed[i] = false;
        }
    }
}