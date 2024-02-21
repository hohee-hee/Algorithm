import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            Integer.parseInt(br.readLine());
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for(int i = 0 ; i < N ; i++) {
            int card = Integer.parseInt(br.readLine());
            pq.offer(card);
        }

        int answer = 0;
        while(!pq.isEmpty()) {
            int A = pq.poll();
            int B = pq.poll();
            answer += A+B;
            if(pq.isEmpty()) break;
            pq.offer(A+B);
        }

        System.out.println(answer);
    }
}