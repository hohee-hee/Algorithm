// 1:07 -

import java.io.*;
import java.util.*;

public class Main{
    public static HashSet<Character> set;
    public static char[][] board;
    public static int R,C,max;
    public static int[] dr = {-1,0,1,0};
    public static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for(int i = 0 ; i < R ; i++) board[i] = br.readLine().toCharArray();

        max = 0;
        set = new HashSet<>();
        set.add(board[0][0]);
        dfs(0, 0);

        System.out.println(max);
    }

    public static void dfs(int cr, int cc){
        for(int dir = 0 ; dir < 4 ; dir++) {
            int nr = cr + dr[dir];
            int nc = cc + dc[dir];

            if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            if(set.contains(board[nr][nc])) continue;

            set.add(board[nr][nc]);
            dfs(nr, nc);
            set.remove(board[nr][nc]);
        }

        max = Math.max(set.size(), max);
    }
}
