import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static final int INF = 100000 * 10 + 2;
    public static final int ROOT = 1;
    public static int vIdx = 2;
    public static int[][] next = new int[INF][26];
    public static int[] leafCnt = new int[INF];

    public static int insert(String word) {
        boolean hasAlias = false;
        int curr = ROOT;
        String pre = "";
        for(int i = 0 ; i < word.length() ; i++) {
            if(!hasAlias) pre += word.charAt(i);

            if(next[curr][word.charAt(i) - 'a'] == -1) {
                if(!hasAlias) {
                    hasAlias = true;
                    sb.append(pre).append("\n");
                }
                next[curr][word.charAt(i) - 'a'] = vIdx++;
            }

            curr = next[curr][word.charAt(i) - 'a'];
        }

        leafCnt[curr]++;
        return hasAlias ? -1 : curr;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < INF ; i++) Arrays.fill(next[i], -1);
        for(int i = 0 ; i < N ; i++) {
            String name = br.readLine();
            int curr = insert(name);
            if(curr == -1) continue;

            if(leafCnt[curr] == 1) sb.append(name);
            else sb.append(name).append(leafCnt[curr]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}



