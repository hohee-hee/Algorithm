import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        for(int i = 0 ; i < N ; i++) {
            int A = Integer.parseInt(st.nextToken());

            while(!dq.isEmpty() && dq.peekLast()[0] >= A) dq.pollLast();
            dq.offerLast(new int[]{A, i});

            if(dq.peekFirst()[1] <= i-L) dq.pollFirst();
            sb.append(dq.peekFirst()[0] + " ");
        }

        System.out.println(sb);
    }
}