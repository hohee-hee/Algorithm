import java.io.*;
import java.util.*;

public class Main {

    public static int INF = 300_000 * 8 + 2;
    public static int ROOT = 1;
    public static int wIdx = 2;
    public static int[][] next = new int[INF][26];
    public static boolean[] isLeaf = new boolean[INF];
    public static char[][] grid;
    public static boolean[][] isVisited = new boolean[4][4];
    public static int[] dr = {-1,0,1,0,-1,1,1,-1};
    public static int[] dc = {0,1,0,-1,1,1,-1,-1};
    public static TreeSet<String> words = new TreeSet<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() == o2.length()) return o1.compareTo(o2);
            return o2.length() - o1.length();
        }
    });

    public static class Node {
        int r;
        int c;
        String word;

        Node(int r, int c, String word) {
            this.r = r;
            this.c = c;
            this.word = word;
        }
    }

    public static void insert(String word) {
        int curr = ROOT;
        for(int i = 0 ; i < word.length() ; i++) {
            if(next[curr][word.charAt(i) - 'A'] == -1) next[curr][word.charAt(i) - 'A'] = wIdx++;
            curr = next[curr][word.charAt(i) - 'A'];
        }
        isLeaf[curr] = true;
    }

    public static int find(String word){
        // -1 : 단어 없음, 0 : 단어는 있으나 리프노드가 아님, 1: 단어도 있고 리프노드임
        int curr = ROOT;
        for(int i = 0 ; i < word.length() ; i++) {
            if(next[curr][word.charAt(i) - 'A'] == -1) return -1;
            curr = next[curr][word.charAt(i) - 'A'];
        }
        if(isLeaf[curr]) return 1;
        return 0;
    }

    public static void dfs(Node cn) {
        if(cn.word.length() == 8) {
            return;
        }

        for(int dir = 0 ; dir < 8 ; dir++) {
            int nr = cn.r + dr[dir];
            int nc = cn.c + dc[dir];

            if(nr < 0 || nr >= 4 || nc < 0 || nc >= 4) continue;
            if(isVisited[nr][nc]) continue;

            String nWord = cn.word + grid[nr][nc];

            int findRes = find(nWord);
            if(findRes == -1) continue;
            if(findRes == 1) words.add(nWord);

            isVisited[nr][nc] = true;
            dfs(new Node(nr,nc,nWord));
            isVisited[nr][nc] = false;
        }
    }

    public static int lenToScore(int len) {
        switch(len){
            case 1:
            case 2:
                return 0;
            case 3:
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            case 7:
                return 5;
            default:
                return 11;
        }
    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < INF ; i++) Arrays.fill(next[i], -1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int W = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < W ; i++) {
            String word = br.readLine();
            insert(word);
        }

        br.readLine();
        int B = Integer.parseInt(br.readLine());
        for(int b = 0 ; b < B ; b++) {
            grid = new char[4][4];

            for(int r = 0 ; r < 4 ; r++) {
                String row = br.readLine();
                for(int c = 0 ; c < 4 ; c++) {
                    grid[r][c] = row.charAt(c);
                }
            }

            // dfs
            words.clear();
            for(int r = 0 ; r < 4 ; r++) {
                for(int c = 0 ; c < 4 ; c++) {
                    for(int i = 0 ; i < 4 ; i++) Arrays.fill(isVisited[i], false);
                    String str = "" + grid[r][c];
                    isVisited[r][c] = true;
                    dfs(new Node(r,c,str));
                }
            }

            int max = 0;
            int cnt = words.size();

            Iterator it = words.iterator();
            String longest = it.next().toString();
            max += lenToScore(longest.length());

            while(it.hasNext()) max += lenToScore(it.next().toString().length());

            sb.append(max + " " + longest + " " + cnt).append("\n");

            if(b != B-1) br.readLine();
        }

        System.out.println(sb);
    }
}