import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc  = 0 ; tc < T ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            }); // 중요도 저장
            ArrayDeque<int[]> printQ = new ArrayDeque<>(); // [0] 중요도 [1] id값
            for(int i = 0 ; i < N ; i++) {
                int rate = Integer.parseInt(st.nextToken());
                printQ.offerFirst(new int[]{rate,i});
                pq.offer(rate);
            }

            // 시뮬레이션
            int answer = 0;
            while(true) {
                int rate = printQ.peekLast()[0];
                int dIdx = printQ.pollLast()[1];

                if(rate != pq.peek()) {
                    printQ.offerFirst(new int[]{rate, dIdx});
                    continue;
                }

                answer++;
                pq.poll();
                if(dIdx == M) break;
            }

            sb.append(answer).append("\n");

        }

        System.out.println(sb);
    }
}
