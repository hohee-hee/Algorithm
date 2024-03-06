// 2. 트라이 풀이

import java.io.*;
import java.util.*;

public class Main {
    public static final int INF = 10000 * 500 + 2;
    public static final int ROOT = 1;
    public static int vIdx = 2;
    public static int[][] next = new int[INF][26];
    public static boolean[] isLeaf = new boolean[INF];

    public static void insert(String word) {
        int curr = ROOT;
        for(int i = 0 ; i < word.length() ; i++) {
            if(next[curr][word.charAt(i) - 'a'] == -1) next[curr][word.charAt(i) - 'a'] = vIdx++;
            curr = next[curr][word.charAt(i) - 'a'];
        }
        isLeaf[curr] = true;
    }

    public static boolean findPre(String word) {
        int curr = ROOT;
        for(int i = 0 ; i < word.length() ; i++) {
            if(next[curr][word.charAt(i) - 'a'] == -1) return false;
            curr = next[curr][word.charAt(i) - 'a'];
        }

        return true;
    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < INF ; i++) Arrays.fill(next[i], -1);
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            insert(str);
        }

        int answer = 0;
        for(int i = 0 ; i < M ; i++) {
            String str = br.readLine();
            if(findPre(str)) answer++;
        }

        System.out.println(answer);
    }
}



