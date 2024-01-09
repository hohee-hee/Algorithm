import java.io.*;
import java.util.*;

public class Main {

    public static char[][] board; // 보드판
    public static int[] dr = {-1,0,1,0}; // 상우하좌
    public static int[] dc = {0,1,0,-1}; // 상우하좌


    public static void main(String[] args) throws IOException{
        int answer = -1;

        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new char[N][M]; // 판
        int redRow = 0, redCol = 0, blueRow = 0, blueCol = 0; // 빨간 공과 파란 공 좌표는 따로 지정

        for(int r = 0 ; r < N ; r++) {
            String row = br.readLine();
            for(int c = 0 ; c < M ; c++) {
                char ch = row.charAt(c);
                if(ch == 'R') {
                    redRow = r;
                    redCol = c;
                    ch = '.';
                } else if(ch == 'B') {
                    blueRow = r;
                    blueCol = c;
                    ch = '.';
                }
                board[r][c] = ch;
            }
        }

        // 2. BFS
        ArrayDeque<int[]> q = new ArrayDeque<>(); // [0] redRow [1] redCol [2] blueRow [3] blueCol [4] dir [5] 이동 횟수
        q.offerLast(new int[]{redRow, redCol, blueRow, blueCol, -1, 0});

        bfs: while(!q.isEmpty()) {

            int cRedRow = q.peekFirst()[0];
            int cRedCol = q.peekFirst()[1];
            int cBlueRow = q.peekFirst()[2];
            int cBlueCol = q.peekFirst()[3];
            int cDir = q.peekFirst()[4];
            int cnt = q.pollFirst()[5];

            for(int dir = 0 ; dir < 4 ; dir++) {
                if((dir+2) % 4 == cDir) continue; // 들어온 방향과 동일하면 굳이 다시 그 방향으로 갈 필요는 없다.

                // 좌표 이동하기
                int[] redLoc = move(dir, cRedRow, cRedCol);
                int[] blueLoc = move(dir, cBlueRow, cBlueCol);

                // 구명과 만났는지 확인하기
                if(blueLoc[2] == 1) { // 실패
                    continue;
                } else if(redLoc[2] == 1) { // 성공
                    answer = cnt+1;
                    break bfs;
                }

                // 각 변수에 할당
                int nRedRow = redLoc[0];
                int nRedCol = redLoc[1];
                int nBlueRow = blueLoc[0];
                int nBlueCol = blueLoc[1];

                // 도착점이 동일한지 확인
                if(nRedRow == nBlueRow && nRedCol == nBlueCol) {
                    if(isBlueFirst(dir, cRedRow, cRedCol, cBlueRow, cBlueCol)) {
                        nRedRow -= dr[dir];
                        nRedCol -= dc[dir];
                    } else {
                        nBlueRow -= dr[dir];
                        nBlueCol -= dc[dir];
                    }
                }


                // 최종 좌표가 처음과 동일하면 넘어가기
                if(nRedRow == cRedRow && nRedCol == cRedCol && nBlueRow == cBlueRow && nBlueCol == cBlueCol) continue;

                // 만약 새로운 이동횟수가 10 미만이면 큐에 넣기
                if(cnt + 1 < 10) q.offerLast(new int[]{nRedRow, nRedCol, nBlueRow, nBlueCol, dir, cnt + 1});
            }
        }

        // 3. 출력
        System.out.println(answer);
    }

    /**
     * 좌표 이동
     *
     * @return : { 도착점 r좌표, 도착점 c좌표, 구멍 도달 여부(미도달 시 0, 도달 시 1) }
     */
    public static int[] move(int dir, int row, int col) {
        int cr = row;
        int cc = col;

        while(true) {
            int nr = cr + dr[dir];
            int nc = cc + dc[dir];
            if(board[nr][nc] == '#') return new int[]{cr, cc, 0};
            if(board[nr][nc] == 'O') return new int[]{cr, cc, 1};

            cr = nr;
            cc = nc;
        }
    }

    /**
     * B가 더 먼저 이동해야 했는지 체크
     *
     * @param : 방향, 각 공의 좌표들
     * @return : 초기 위치에서 진행 방향을 보고 b가 앞이었다면 true 뒤였다면 false
     */
    public static boolean isBlueFirst(int dir, int redRow, int redCol, int blueRow, int blueCol) {
        if(dir == 0) {
            if(redCol == blueCol && redRow > blueRow) return true;
        } else if(dir == 1) {
            if(redRow == blueRow && redCol < blueCol) return true;
        } else if(dir == 2) {
            if(redCol == blueCol && redRow < blueRow) return true;
        } else if(dir == 3) {
            if(redRow == blueRow && redCol > blueCol) return true;
        }

        return false;
    }

}