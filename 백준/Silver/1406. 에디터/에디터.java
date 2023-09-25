import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        ArrayDeque<Character> stackLeft = new ArrayDeque<>();
        ArrayDeque<Character> stackRight = new ArrayDeque<>();
        for(int i = 0 ; i < input.length() ; i++) {
            stackLeft.offerLast(input.charAt(i));
        }
        int M = Integer.parseInt(br.readLine());

        int cursor = input.length(); // 커서 위치
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);

            switch (command) {
                case 'L':
                    if(!stackLeft.isEmpty()) {
                        char ch = stackLeft.pollLast();
                        stackRight.offerLast(ch);
                    }
                    break;
                case 'D':
                    if(!stackRight.isEmpty()) {
                        char ch = stackRight.pollLast();
                        stackLeft.offerLast(ch);
                    }
                    break;
                case 'B':
                    if(!stackLeft.isEmpty()) {
                        stackLeft.pollLast();
                    }
                    break;
                case 'P' :
                    stackLeft.offerLast(st.nextToken().charAt(0));
                    break;
            }
        }

        while(!stackLeft.isEmpty()) sb.append(stackLeft.pollFirst());
        while(!stackRight.isEmpty()) sb.append(stackRight.pollLast());

        System.out.println(sb);
    }
}
