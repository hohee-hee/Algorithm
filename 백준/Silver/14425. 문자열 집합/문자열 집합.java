// 1. 해시풀이
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            set.add(str);
        }

        int answer = 0;
        for(int i = 0 ; i < M ; i++) {
            if(set.contains(br.readLine())) answer++;
        }

        System.out.println(answer);
    }
}