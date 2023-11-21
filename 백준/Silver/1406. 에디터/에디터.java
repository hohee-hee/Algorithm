// 09:54 -

import java.util.*;
import java.io.*;

public class Main {
    // 1. 스택 2개 만들기 : 커서 기준 왼 오
    public static ArrayDeque<Character> left, right;


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int test = Integer.parseInt(br.readLine());

        left = new ArrayDeque<Character>();
        right = new ArrayDeque<Character>();

        // 2. 초기 문자열 왼쪽 스택에 넣기
        for(int i = 0 ; i < str.length() ; i++) left.offerLast(str.charAt(i));

        // 3. 옮기기
        for(int t = 0; t < test ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);

            if(command == 'L') L();
            if(command == 'D') D();
            if(command == 'B') B();
            if(command == 'P') P(st.nextToken().charAt(0));
        }

        while(!left.isEmpty()) {
            sb.append(left.pollFirst());
        }
        while(!right.isEmpty()) {
            sb.append(right.pollLast());
        }

        System.out.println(sb);
    }

    public static void L() {
        if(left.isEmpty()) return;

        char ch = left.pollLast();
        right.offerLast(ch);
    }

    public static void D() {
        if(right.isEmpty()) return;

        char ch = right.pollLast();
        left.offerLast(ch);
    }

    public static void B() {
        if(left.isEmpty()) return;

        left.pollLast();
    }

    public static void P(char insert) {
        left.offerLast(insert);
    }
}
