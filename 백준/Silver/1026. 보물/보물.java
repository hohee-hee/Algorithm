import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> A = new PriorityQueue<>();
        PriorityQueue<Integer> B = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        StringTokenizer ast = new StringTokenizer(br.readLine());
        StringTokenizer bst = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            A.offer(Integer.parseInt(ast.nextToken()));
            B.offer(Integer.parseInt(bst.nextToken()));
        }

        int S = 0;
        while(!A.isEmpty()) {
            S += A.poll() * B.poll();
        }

        System.out.println(S);
    }
}

