import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        int[] doyeon = {};
        for(int i = 0 ; i < N ; i++) {
            String line = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                switch(line.charAt(j)){
                    case 'X':
                        map[i][j] = -1;
                        break;
                    case 'P':
                        map[i][j] = 1;
                        break;
                    case 'I':
                        doyeon = new int[]{i,j};
                        break;
                    default:
                        break;
                }
            }
        }
        
        int answer = 0;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][M];
        q.offerLast(doyeon);
        isVisited[doyeon[0]][doyeon[1]] = true;

        while(!q.isEmpty()) {
            int cr = q.peekFirst()[0];
            int cc = q.pollFirst()[1];

            for(int dir = 0 ; dir < 4 ; dir++){
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(isVisited[nr][nc] || map[nr][nc] == -1) continue;
                if(map[nr][nc] == 1) answer++;

                q.offerLast(new int[]{nr,nc});
                isVisited[nr][nc] = true;
            }
        }


        if(answer == 0) System.out.println("TT");
        else System.out.println(answer);
    }
}