import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int answer = -1;
        ArrayDeque<long[]> q = new ArrayDeque<>();
        q.offerLast(new long[]{A, 1});
        while(!q.isEmpty() && answer == -1) {
            long num = q.peekFirst()[0];
            long cnt = q.pollFirst()[1];

            if(num == B) {
                answer = (int)cnt;
                break;
            }

            if(num << 1 <= B) {
                q.offerLast(new long[]{num << 1, cnt+1});
            }

            if(num * 10 + 1 <= B) {
                q.offerLast(new long[]{num * 10 + 1, cnt+1});
            }
        }
        System.out.println(answer);
    }
}