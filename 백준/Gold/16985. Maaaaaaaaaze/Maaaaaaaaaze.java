import java.io.*;
import java.util.*;

public class Main {

    // 이동에 사용할 델타 배열
    public static int[][] startpt = {{0,0,0},{0,0,4},{0,4,0},{0,4,4}};
    public static int[][] endpt = {{4,4,4},{4,4,0},{4,0,4},{4,0,0}};
    public static int[] dh = {0,0,0,0,-1,1};
    public static int[] dr = {-1,0,1,0,0,0};
    public static int[] dc = {0,1,0,-1,0,0};

    // 그 외 전역변수
    public static boolean[][][] variation, maze;
    public static boolean[] choose;
    public static int[] shapes;
    public static int answer;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        variation = new boolean[20][5][5];
        maze = new boolean[5][5][5];
        choose = new boolean[5];
        shapes = new int[5];

        for(int i = 0 ; i < 20 ; i += 4) {
            for(int r = 0 ; r < 5 ; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int c = 0 ; c < 5 ; c++) {
                    int n = Integer.parseInt(st.nextToken());
                    if(n == 1) variation[i][r][c] = true;
                }
            }

            for(int r = 0 ; r < 5 ; r++) {
                for(int c = 0 ; c < 5 ; c++){
                    variation[i+1][r][c] = variation[i][4-c][r];
                    variation[i+2][r][c] = variation[i][4-r][4-c];
                    variation[i+3][r][c] = variation[i][c][4-r];
                }
            }
        }

        answer = -1;

        chooseShape(0);

        System.out.println(answer);
    }

    // 어떤 모양을 몇번째에 쌓을지 정하는 함수
    public static void chooseShape(int cnt) {
        if(cnt == 5) {
            buildMaze(0);
            return;
        }

        for(int i = 0 ; i < 5 ; i++) {
           if(choose[i]) continue;

           shapes[cnt] = i;
           choose[i] = true;
           chooseShape(cnt+1);

           choose[i] = false;
        }
    }

    // 여러 varition으로 미로 쌓기
    public static void buildMaze(int idx) {
        if(idx == 5) {
            int cnt = escape();
            if(cnt == -1) return;
            if(answer == -1 || answer > cnt) answer = cnt;
            return;
        }

        for(int i = 0 ; i < 4 ; i++) {
            maze[idx] = variation[shapes[idx] * 4 + i];
            buildMaze(idx+1);
        }
    }

    // 탈출 경로 확인하기
    public static int escape(){
        int value = 0;
        for(int i = 0 ; i < 4; i++) {
            int sh = startpt[i][0];
            int sr = startpt[i][1];
            int sc = startpt[i][2];

            int eh = endpt[i][0];
            int er = endpt[i][1];
            int ec = endpt[i][2];

            if(!maze[sh][sr][sc] || !maze[eh][er][ec]) continue;

            int dist = 0;
            boolean isEsc = false;
            ArrayDeque<int[]> q = new ArrayDeque<>();
            boolean[][][] isVisited = new boolean[5][5][5];
            q.offerLast(new int[]{sh,sr,sc,0});
            isVisited[sh][sr][sc] = true;

            bfs: while(!q.isEmpty()) {
                int ch = q.peekFirst()[0];
                int cr = q.peekFirst()[1];
                int cc = q.peekFirst()[2];
                int cd = q.pollFirst()[3];

                for(int dir = 0 ; dir < 6 ; dir++) {
                    int nh = ch + dh[dir];
                    int nr = cr + dr[dir];
                    int nc = cc + dc[dir];
                    int nd = cd + 1;

                    if(nh < 0 || nr < 0 || nc < 0 || nh >= 5 || nr >= 5 || nc >= 5) continue;
                    if(isVisited[nh][nr][nc]) continue;
                    if(!maze[nh][nr][nc]) continue;
                    if(nh == eh && nr == er && nc == ec) {
                        dist = nd;
                        isEsc = true;
                        break bfs;
                    }

                    q.offerLast(new int[]{nh,nr,nc,nd});
                    isVisited[nh][nr][nc] = true;
                }
            }

            if(isEsc && (value == 0 || dist < value)) value = dist;
        }

        return value == 0 ? -1 : value;
    }
}
