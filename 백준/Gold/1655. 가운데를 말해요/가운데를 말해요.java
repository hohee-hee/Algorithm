import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        PriorityQueue<Integer> right = new PriorityQueue<>();

        int lSize = 0;
        int rSize = 0;

        for(int r = 0 ; r < N ; r++){
            int x = Integer.parseInt(br.readLine());
            if(left.isEmpty() || x < left.peek()) {
                left.offer(x);
                lSize++;
            } else {
                right.offer(x);
                rSize++;
            }

            if(lSize > rSize+1) {
                right.offer(left.poll());
                rSize++; lSize--;
            } else if(rSize > lSize+1) {
                left.offer(right.poll());
                lSize++; rSize--;
            }

            if(lSize >= rSize) sb.append(left.peek());
            else sb.append(right.peek());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}