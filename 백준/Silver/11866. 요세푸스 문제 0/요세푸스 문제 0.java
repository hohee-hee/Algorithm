import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 1 ; i <= N ; i++){
            q.offerLast(i);
        }

        while(!q.isEmpty()) {
            for(int i = 0 ; i < K-1 ; i++) {
                int num = q.pollFirst();
                q.offerLast(num);
            }

            sb.append(q.pollFirst());
            if(!q.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
