import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] info = new int[2][N+1];
        PriorityQueue<Integer>[] solve = new PriorityQueue[N+1];
        for(int i = 1 ; i <= N ; i++) solve[i] = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return info[1][o2] - info[1][o1];
            }
        });


        StringTokenizer st;
        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            info[0][i] = D;
            info[1][i] = R;
            solve[D].add(i);
        }

        int answer = 0;
        PriorityQueue<Integer> rest = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return info[1][o2] - info[1][o1];
            }
        });

        for(int time = N ; time > 0 ; time--) {
            if(solve[time].isEmpty() && rest.isEmpty()) continue;

            while(!solve[time].isEmpty()) rest.offer(solve[time].poll());

            answer += info[1][rest.poll()];
        }

        System.out.println(answer);
    }
}