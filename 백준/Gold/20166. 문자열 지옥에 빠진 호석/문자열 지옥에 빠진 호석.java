import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, K;
    public static long cnt;
    public static char[][] grid;
    public static LinkedHashMap<String, Long> answer;
    public static int[] dr = {-1,0,1,0,-1,1,1,-1};
    public static int[] dc = {0,1,0,-1,1,1,-1,-1};

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new char[N+1][M+1];

        for(int r = 1 ; r <= N ; r++) {
            String row = br.readLine();
            for(int c = 1 ; c <= M ;c++) {
                grid[r][c] = row.charAt(c-1);
            }
        }

        answer = new LinkedHashMap<>();

        for(int i = 0 ; i < K ; i++) {
            cnt = 0;
            String target = br.readLine();

            if(answer.containsKey(target)) {
                sb.append(answer.get(target)).append("\n");
                continue;
            }

            for(int r = 1 ; r <= N ; r++) {
                for(int c = 1 ; c <= M ; c++) {
                    String currStr = "" + grid[r][c];
                    dfs(target, currStr, r, c);
                }
            }

            answer.put(target, cnt);
            sb.append(answer.get(target)).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(String target, String currStr, int cr, int cc) {
        if(currStr.length() == target.length()) {
            if(currStr.equals(target)) cnt++;
            return;
        }

        for(int dir = 0 ; dir < 8 ; dir++) {
            int nr = cr + dr[dir];
            int nc = cc + dc[dir];

                int[] cor = rangeChk(dir, nr, nc);
                nr = cor[0]; nc = cor[1];

            dfs(target, currStr+grid[nr][nc], nr, nc);
        }

    }

    public static int[] rangeChk(int type, int nr, int nc) {
        switch(type) {
            case 0:
                if(nr < 1) nr = N;
                break;
            case 1:
                if(nc > M) nc = 1;
                break;
            case 2:
                if(nr > N) nr = 1;
                break;
            case 3:
                if(nc < 1) nc = M;
                break;
            case 4:
                if(nr < 1) nr = N;
                if(nc > M) nc = 1;
                break;
            case 5:
                if(nc > M) nc = 1;
                if(nr > N) nr = 1;
                break;
            case 6:
                if(nr > N) nr = 1;
                if(nc < 1) nc = M;
                break;
            default:
                if(nr < 1) nr = N;
                if(nc < 1) nc = M;
                break;
        }

        return new int[]{nr,nc};
    }
}