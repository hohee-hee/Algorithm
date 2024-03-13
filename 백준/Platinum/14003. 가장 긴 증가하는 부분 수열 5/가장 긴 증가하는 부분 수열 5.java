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
            int idx = Arrays.binarySearch(len, arr[i]);

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

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int curr = answer - 1;
        for(int i = N-1 ; i >=0 ; i--) {
            if(rec[i] != curr) continue;
            stack.offerFirst(arr[i]);
            curr--;
        }

        while(!stack.isEmpty()) sb.append(stack.pollFirst() +  " ");
        System.out.println(sb);
    }
}