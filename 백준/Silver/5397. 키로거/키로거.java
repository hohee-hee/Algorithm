import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++) {
            String log = br.readLine();

            ArrayDeque<Character> left = new ArrayDeque<>();
            ArrayDeque<Character> right = new ArrayDeque<>();

            for(int i = 0 ; i < log.length() ; i++) {
                char ch = log.charAt(i);
                if(ch == '<') {
                    if(left.isEmpty()) continue;

                    char tmp = left.pollLast();
                    right.offerFirst(tmp);
                } else if(ch == '>') {
                    if(right.isEmpty()) continue;

                    char tmp = right.pollFirst();
                    left.offerLast(tmp);
                } else if(ch == '-') {
                    if(left.isEmpty()) continue;

                    left.pollLast();
                } else {
                    left.offerLast(ch);
                }
            }


            while(!left.isEmpty()) sb.append(left.pollFirst());
            while(!right.isEmpty()) sb.append(right.pollFirst());
            sb.append('\n');

        }

        System.out.println(sb);
    }
}
