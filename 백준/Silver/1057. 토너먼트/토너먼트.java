import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int answer = 1;
        boolean isPos = false;
        while(true) {
            // 토너먼트 로직 검사
            if(isVersus(a, b)) {
                isPos = true;
                break;
            }

            if(a%2 == 1) a += 1;
            if(b%2 == 1) b += 1;

            a /= 2;
            b /= 2;

            answer++;
        }

        answer = isPos ? answer : -1;
        System.out.println(answer);
    }

    public static boolean isVersus(int a, int b){
        if(a%2 == b%2) return false;
        if(Math.min(a,b)%2 == 0) return false;
        if((a+1)/2 != (b+1)/2) return false;
        return true;
    }
}