import java.util.*;
import java.io.*;

public class Main{
    public static int[] parents;
    public static ArrayList<Integer>[] children;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        children = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) children[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            parents[child] = parent;
            children[parent].add(child);
        }

        // 1. 각 노드 depth 찾기
        int depthA = 0;
        int depthB = 0;
        int rootA = A;
        int rootB = B;
        while(parents[rootA] != 0) {
            rootA = parents[rootA];
            depthA++;
        }
        while(parents[rootB] != 0) {
            rootB = parents[rootB];
            depthB++;
        }

        // 만약 루트노드가 다르면 촌수 X
        if(rootA != rootB) {
            System.out.println(-1);
            return;
        }

        int answer = 0;

        // 루트노트가 같으면 depth 맞추기
        while(depthA != depthB) {
            if(depthA < depthB) {
                depthB--;
                answer++;
                B = parents[B];
            } else {
                depthA--;
                answer++;
                A = parents[A];
            }
        }

        // 공통조상이 있을 때까지 올라가기
        while(A != B) {
            A = parents[A];
            B = parents[B];
            answer += 2;
        }

        System.out.println(answer);
    }
}