
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] spaces = new int[N][M];
        ArrayList<Integer>[] spaces_sorted = new ArrayList[N];

        for(int i = 0 ; i < N ; i++) {
            TreeSet<Integer> set = new TreeSet<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++) {
                spaces[i][j] = Integer.parseInt(st.nextToken());
                set.add(spaces[i][j]);
            }
            spaces_sorted[i] = new ArrayList<>(set);
        }

        int[][] rank = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                rank[i][j] = Collections.binarySearch(spaces_sorted[i], spaces[i][j]);
            }
        }

        int answer = 0;
        for(int i = 0 ; i < N-1 ; i++) {
            for(int j = i+1 ; j < N ; j++) {
                if(Arrays.equals(rank[i],rank[j])) answer++;
            }
        }

        System.out.println(answer);
    }
}