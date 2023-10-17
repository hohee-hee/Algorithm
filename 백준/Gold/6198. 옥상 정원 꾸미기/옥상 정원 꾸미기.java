import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 빌딩 개수
        int[] height = new int[N]; // 빌딩의 높이를 저장할 배열

        // 높이 저장하기
        for(int i = 0 ; i < N ; i++) height[i] = Integer.parseInt(br.readLine());

        // 2. 필요한 자료구조 선언
        ArrayDeque<Integer> stack = new ArrayDeque<>(); // 높이 체크를 도와줄 스택
        long answer = 0; // 답 저장

        // 3. 순회
        for(int i = 0 ; i < N ; i++) {
            while(!stack.isEmpty() && stack.peekLast() <= height[i]) {
                stack.pollLast();
            }
            // 비어있든, 그렇지 않든 무조건 자기 자신은 넣기
            answer += stack.size();
            stack.offerLast(height[i]);
        }


        System.out.println(answer);
    }
}

