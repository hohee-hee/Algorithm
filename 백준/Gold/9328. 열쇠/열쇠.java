import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T ; tc++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] map= new char[h][w];
            for(int i = 0 ; i < h ; i++) map[i] = br.readLine().toCharArray();

            boolean[] hasKey = new boolean[26];
            String keys = br.readLine();
            if(!keys.equals("0")) {
                for(int i = 0 ; i < keys.length() ; i++) hasKey[keys.charAt(i) - 'a'] = true;
            }

            int[] dr = {-1,0,1,0};
            int[] dc = {0,1,0,-1};

            ArrayDeque<int[]> q = new ArrayDeque<>();
            boolean[][] isVisited = new boolean[h][w];
            ArrayList<int[]>[] doors = new ArrayList[26];
            for(int i = 0 ; i < 26 ; i++) doors[i] = new ArrayList<>();

            int answer = 0;
            for(int r = 0 ; r < h ; r++) {
                for(int c = 0 ; c < w ; c++) {
                    if((r != 0 && r != h-1) && (c != 0 && c != w-1)) continue;
                    if(map[r][c] == '*' || isVisited[r][c]) continue;

                    if(map[r][c] - 'a' >= 0 && map[r][c] - 'a' < 26) hasKey[map[r][c] - 'a'] = true;
                    else if(map[r][c] - 'A' >= 0 && map[r][c] - 'A' < 26 && !hasKey[map[r][c] - 'A']) {
                        doors[map[r][c] - 'A'].add(new int[]{r,c});
                        continue;
                    }
                    else if(map[r][c] == '$') answer++;

                    q.offerLast(new int[]{r,c});
                    isVisited[r][c] = true;
                    while(!q.isEmpty()) {
                        int cr = q.peekFirst()[0];
                        int cc = q.pollFirst()[1];

                        for(int dir = 0 ; dir < 4 ; dir++) {
                            int nr = cr + dr[dir];
                            int nc = cc + dc[dir];

                            if(nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
                            if(isVisited[nr][nc] || map[nr][nc] == '*') continue;
                            if(map[nr][nc] - 'A' >= 0 && map[nr][nc] - 'A' < 26 && !hasKey[map[nr][nc] - 'A']) {
                                doors[map[nr][nc] - 'A'].add(new int[]{nr,nc});
                                continue;
                            }

                            if(map[nr][nc] == '$') answer++;
                            if(map[nr][nc] - 'a' >= 0 && map[nr][nc] - 'a' < 26 && !hasKey[map[nr][nc] - 'a']) {
                                hasKey[map[nr][nc] - 'a'] = true;
                                for(int[] loc : doors[map[nr][nc] - 'a']) {
                                    isVisited[loc[0]][loc[1]] = true;
                                    q.offerLast(loc);
                                }
                            }

                            isVisited[nr][nc] = true;
                            q.offerLast(new int[]{nr,nc});
                        }
                    }
                }
            }
            sb.append(answer).append("\n");
        }


        System.out.println(sb);
    }
}