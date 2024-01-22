import java.io.*;
import java.util.*;

public class Main {
    public static ArrayDeque<int[]> snakeQ;
    public static boolean[][] board, snake;
    public static int[] head, tail;
    public static int[] dr = {-1,0,1,0};
    public static int[] dc = {0,1,0,-1};
    public static int answer, dir; // 0: 상, 1: 우, 2: 하, 3: 좌

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new boolean[N+1][N+1];

        int K = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < K ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = true;
        }

        snakeQ = new ArrayDeque<>();
        snakeQ.offerFirst(new int[]{1,1});
        snake = new boolean[N+1][N+1];
        snake[1][1] = true;
        head = new int[]{1,1};
        tail = new int[]{snakeQ.peekLast()[0], snakeQ.pollLast()[1]};
        dir = 1; answer = 0;
        boolean gameover = false;
        int L = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < L ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            // dir 바꾸기
            gameover = isFin(N, x);
            if(c == 'L') dir = dir == 0 ? 3 : dir-1;
            else dir = (dir + 1) % 4;

            if(gameover) break;
        }

        // 마지막 이동 하기
        if(!gameover) isFin(N, -1);

        System.out.println(answer);
    }

    public static boolean isFin(int N, int cnt){
        while(answer < cnt || cnt == -1) {
            answer++;

            int nr = head[0] + dr[dir];
            int nc = head[1] + dc[dir];

            if(nr < 1 || nc < 1 || nr > N || nc > N) return true;
            if(snake[nr][nc]) return true;

            snakeQ.offerFirst(new int[]{nr,nc});
            snake[nr][nc] = true;
            head[0] = nr; head[1] = nc;

            if(!board[nr][nc]) {
                snake[tail[0]][tail[1]] = false;
                tail[0] = snakeQ.peekLast()[0];
                tail[1] = snakeQ.pollLast()[1];
            }

            board[nr][nc] = false;
        }

        return false;
    }
}
