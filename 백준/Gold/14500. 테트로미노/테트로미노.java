import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());

       int[][] paper = new int[N][M];
       for(int r = 0 ; r < N ; r++) {
           st = new StringTokenizer(br.readLine());
           for(int c = 0 ; c < M ; c++) {
               paper[r][c] = Integer.parseInt(st.nextToken());
           }
       }

       // 모양 dr dc
       int[][] dr = {
               {0,0,0,0},{0,1,2,3},{0,0,1,1},
               {0,1,2,2},{0,0,0,1},{0,0,1,2},
               {0,0,0,-1},{0,1,1,2},{0,1,1,0},
               {0,0,0,1},{0,-1,0,1},{0,0,1,2},
               {0,1,1,1},{0,1,2,2},{0,0,0,1},
               {0,1,1,2},{0,0,1,1},{0,-1,0,0},{0,1,2,1}};
       int[][] dc = {
               {0,1,2,3},{0,0,0,0},{0,1,0,1},
               {0,0,0,1},{0,1,2,0},{0,1,1,1},
               {0,1,2,2},{0,0,1,1},{0,-1,0,1},
               {0,1,2,1},{0,1,1,1},{0,1,0,0},
               {0,0,1,2},{0,0,0,-1},{0,1,2,2},
               {0,0,-1,-1},{0,1,1,2},{0,1,1,2},{0,0,0,1}};

       // 브루트포스
       int answer = 0;
       for(int r = 0 ; r < N ; r++) {
           for(int c = 0 ; c < M ; c++) {
               for(int num = 0 ; num < 19 ; num++) {
                   boolean isPos = false;
                   int sum = 0;
                   for(int dir = 0 ; dir < 4 ; dir++) {
                    int nr = r + dr[num][dir];
                    int nc = c + dc[num][dir];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M) break;

                    isPos = true;
                    sum += paper[nr][nc];
                   }

                   if(!isPos) continue;
                   if(answer < sum) answer = sum;
               }
           }
       }

       System.out.println(answer);
   }
}
