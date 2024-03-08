import java.io.*;
import java.util.*;

public class Main{
    public static class Node {
        int left;
        int right;
        boolean isLeaf;

        Node(){
            left = -1;
            right = -1;
            isLeaf = false;
        }
    }
    public static final int INF = 1000002;
    public static ArrayList<Node> trie = new ArrayList<>();
    public static ArrayList<String>[] list = new ArrayList[INF];

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] len = new int[N];
        int[] sortedLen = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            len[i] = Integer.parseInt(st.nextToken());
            sortedLen[i] = len[i];
        }

        Arrays.parallelSort(sortedLen);

        for(int i = 0 ; i < INF ; i++) {
            trie = new ArrayList<>();
            list[i] = new ArrayList<>();
        }

        trie.add(new Node());

        for(int l : sortedLen) {
            if(!dfs(0, l, 0, "")) {
                System.out.println(-1);
                return;
            }
        }


        sb.append(1).append("\n");
        for(int i = 0 ; i < N ; i++) {
            String str = list[len[i]].remove(0);
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }

    public static boolean dfs(int cl, int maxLen, int curr, String str){
        if(trie.get(curr).isLeaf) return false;

        if(cl == maxLen) {
            trie.get(curr).isLeaf = true;
            list[maxLen].add(str);
            return true;
        }

        // 왼쪽 노드 확인
        if(trie.get(curr).left == -1) {
            trie.add(new Node());
            trie.get(curr).left = trie.size() - 1;
        }

        if(dfs(cl+1, maxLen, trie.get(curr).left, str+'0')) return true;

        // 오른쪽 노드 확인
        if(trie.get(curr).right == -1) {
            trie.add(new Node());
            trie.get(curr).right = trie.size() - 1;
        }

        if(dfs(cl+1, maxLen, trie.get(curr).right, str+'1')) return true;

        return false;
    }
}