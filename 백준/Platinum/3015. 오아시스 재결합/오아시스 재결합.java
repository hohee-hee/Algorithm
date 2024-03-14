import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long answer = 0;

        ArrayDeque<int[]> stack = new ArrayDeque<>(); // {키, 동일 키 개수}
        for(int i = 0 ; i < N ; i++) {
            int height = Integer.parseInt(br.readLine());

            while(!stack.isEmpty() && stack.peekFirst()[0] < height) {
                answer += stack.pollFirst()[1];
            }

            if(stack.isEmpty()) {
                stack.offerFirst(new int[]{height, 1});
            } else if(stack.peekFirst()[0] == height) {
                answer += stack.peekFirst()[1];
                if(stack.size() > 1) answer++;
                stack.peekFirst()[1]++;
            } else {
                answer++;
                stack.offerFirst(new int[]{height, 1});
            }
        }

        System.out.println(answer);
    }
}