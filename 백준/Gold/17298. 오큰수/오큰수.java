import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) list[i] = Integer.parseInt(st.nextToken());


        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < N ; i++) {
            while (!stack.isEmpty() && list[i] > list[stack.peekLast()]) {
                list[stack.pollLast()] = list[i];
            }

            stack.offerLast(i);
        }

        while (!stack.isEmpty()) {
            list[stack.pollLast()] = -1;
        }

        for(int i = 0 ; i < N ; i++) sb.append(list[i] + " ");

        System.out.println(sb);
    }
}
