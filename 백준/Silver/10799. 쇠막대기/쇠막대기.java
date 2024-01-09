import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int answer = 0;

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0 ; i < str.length() ; i++) {
            char ch = str.charAt(i);

            if(ch == '(') {
                if(i != str.length() - 1 && str.charAt(i+1) == ')') {
                    answer += stack.size();
                    i++;
                } else {
                    stack.offerFirst(ch);
                }
            } else {
                answer++;
                stack.pollFirst();
            }
        }


        System.out.println(answer);
    }
}

