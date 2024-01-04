import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        ArrayDeque<Integer> Josephus = new ArrayDeque<>();

        for(int i = 1 ; i <= N ; i++) dq.offerLast(i);

        int pt = 0;
        while(!dq.isEmpty()) {
            pt++;
            int num = dq.pollFirst();

            if(pt == K) {
                Josephus.offerLast(num);
                pt = 0;
            } else {
                dq.offerLast(num);
            }
        }

        sb.append("<");
        while(!Josephus.isEmpty()) {
            sb.append(Josephus.pollFirst());
            if(!Josephus.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
