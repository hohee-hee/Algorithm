import java.io.*;
import java.util.*;

public class Main {
    public static final int INF = 10000 * 10 + 2;
    public static final int ROOT = 1;
    public static int vIdx;
    public static int[][] next = new int[INF][10];
    public static boolean[] isLeaf;

    public static boolean insert(String word) {
        int curr = ROOT;
        for(int i = 0 ; i < word.length() ; i++) {
            if(next[curr][word.charAt(i) - '0'] == -1) next[curr][word.charAt(i) - '0'] = vIdx++;
            curr = next[curr][word.charAt(i) - '0'];
            if(isLeaf[curr]) return false;
        }        

        if(next[curr][word.charAt(word.length() - 1) - '0'] != -1) return false;
        
        isLeaf[curr] = true;
        return true;
    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++) {
            for(int i = 0 ; i < INF ; i++) Arrays.fill(next[i], -1);
            isLeaf = new boolean[INF];
            vIdx = 2;

            boolean isPos = true;
            int N = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < N ; i++) {
                String str = br.readLine();
                if(isPos)  {
                    if(insert(str)) continue;

                    isPos = false;
                    sb.append("NO").append("\n");
                }
            }

            if(isPos) sb.append("YES").append("\n");
        }


        System.out.println(sb);
    }
}



