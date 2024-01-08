import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++) queue.add(i);

        st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> target = new ArrayDeque<>();
        for(int i = 0 ; i < M ; i++) target.offerLast(Integer.parseInt(st.nextToken()));

        int answer = 0;

        while(!target.isEmpty()) {
            int tNum = target.pollFirst();
            int tIdx = queue.indexOf(tNum);

            if(tIdx < queue.size() - tIdx) { // 왼쪽
                for(int i = 0 ; i < tIdx ; i++) {
                    queue.add(queue.remove());
                    answer++;
                }
            } else { // 오른쪽
                for(int i = 0 ; i < queue.size() - tIdx ; i++) {
                    queue.add(0, queue.removeLast());
                    answer++;
                }
            }

            queue.remove();
        }

        System.out.println(answer);
    }
}