import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for(int i = 1 ; i < N+1 ; i++) {
            int height = Integer.parseInt(st.nextToken());

            while(true) {
                if(stack.isEmpty()) {
                    sb.append("0 ");
                    stack.offerFirst(new int[]{height, i});
                    break;
                } else if(stack.peekFirst()[0] > height) {
                    sb.append(stack.peekFirst()[1]).append(" ");
                    stack.offerFirst(new int[]{height, i});
                    break;
                } else if(stack.peekFirst()[0] < height) {
                    stack.pollFirst();
                }
            }
        }

        System.out.println(sb);
    }
}
