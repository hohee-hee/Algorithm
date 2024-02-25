import java.io.*;
import java.util.*;

public class Main {
    public static int[] leftSubtree, subtree;

    public static Node[] tree;
    public static class Node {
        int l, r, level, parent, x, stX;
        Node(int l, int r, int level, int parent, int x, int stX) {
            this.l = l;
            this.r = r;
            this.level = level;
            this.parent = parent;
            this.x = x;
            this.stX = stX;
        }

    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new Node[N+1];
        TreeSet<Integer> findParent = new TreeSet<>();
        for(int i = 1 ; i <= N ; i++) {
            tree[i] = new Node(-1, -1, -1, -1, -1, -1);
            findParent.add(i);
        }


        StringTokenizer st;
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            tree[num].l = l;
            tree[num].r = r;


            if(l != -1) {
                tree[l].parent = num;
                findParent.remove(l);
            }

            if(r != -1) {
                tree[r].parent = num;
                findParent.remove(r);
            }
        }

        int root = findParent.first();
        tree[root].level = 1;
        tree[root].stX = 0;

        // 왼쪽 서브트리의 크기 구하기
        leftSubtree = new int[N+1];
        subtree = new int[N+1];
        inorder(root);

        int[] maxX = new int[N+1];
        int[] minX = new int[N+1];
        Arrays.fill(minX, Integer.MAX_VALUE);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{root, 1});
        boolean[] isVisited = new boolean[N+1];
        isVisited[root] = true;
        while(!q.isEmpty()) {
            int cn = q.peekFirst()[0];
            int cl = q.pollFirst()[1];
            tree[cn].x = tree[cn].stX +leftSubtree[cn];
            maxX[cl] = Math.max(tree[cn].x, maxX[cl]);
            minX[cl] = Math.min(tree[cn].x, minX[cl]);

            if(tree[cn].l != -1) {
                tree[tree[cn].l].stX = tree[cn].stX;
                q.offerLast(new int[]{tree[cn].l, cl+1});
                isVisited[tree[cn].l] = true;
            }

            if(tree[cn].r != -1) {
                tree[tree[cn].r].stX = tree[cn].x;
                q.offerLast(new int[]{tree[cn].r, cl+1});
                isVisited[tree[cn].r] = true;
            }
        }

        int answerLevel = 1;
        int answerWidth = 0;
        for(int i = 2 ; i <= N ; i++) {
            if(maxX[i] - minX[i] > answerWidth) {
                answerWidth = maxX[i] - minX[i];
                answerLevel = i;
            }
        }
        System.out.println(answerLevel + " " + (answerWidth+1));
    }

    public static void inorder(int cn) {

        // 1. 왼쪽 서브 트리의 노드 개수 구하기
        if(tree[cn].l == -1) {
            leftSubtree[cn] += 1;
            subtree[cn] += 1;
        } else {
            inorder(tree[cn].l);
            leftSubtree[cn] = + subtree[tree[cn].l] + 1;
            subtree[cn] += leftSubtree[cn];
        }

        // 2. 오른쪽 순회 후 cn을 루트로 하는 노드의 개수 구하기
        if(tree[cn].r == -1) {
            subtree[cn] = leftSubtree[cn];
        } else {
            inorder(tree[cn].r);
            subtree[cn] = subtree[tree[cn].r] + leftSubtree[cn];
        }
    }
}
