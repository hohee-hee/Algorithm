import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < K ; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) stack.pollFirst();
            else stack.offerFirst(num);
        }

        int answer = 0;
        while(!stack.isEmpty()) answer += stack.pollFirst();

        System.out.println(answer);
    }
}
