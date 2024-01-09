import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        for(int tc = 0 ; tc < N ; tc++) {
            String str = br.readLine();

            if(str.length() % 2 == 1) continue;

            ArrayDeque<Character> stack = new ArrayDeque<>();

            for(int i = 0 ; i < str.length() ; i++){
                if(!stack.isEmpty() && stack.peekFirst() == str.charAt(i)) {
                    stack.pollFirst();
                    continue;
                }

                stack.offerFirst(str.charAt(i));
            }

            if(stack.isEmpty()) answer++;
        }

        System.out.println(answer);
    }
}