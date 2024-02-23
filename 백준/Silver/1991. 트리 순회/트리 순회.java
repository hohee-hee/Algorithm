import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        char node;
        char l;
        char r;

        Node(char node, char l, char r) {
            this.node = node;
            this.l = l;
            this.r = r;
        }
    }
    public static StringBuilder sb = new StringBuilder();
    public static Node[] graph;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new Node[N];
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            graph[node-'A'] = new Node(node, l, r);
        }

        preorder(graph[0]);
        sb.append("\n");
        inorder(graph[0]);
        sb.append("\n");
        postorder(graph[0]);

        System.out.println(sb);
    }

    public static void preorder(Node curr){
        sb.append(curr.node);
        if(curr.l != '.') preorder(graph[curr.l - 'A']);
        if(curr.r != '.') preorder(graph[curr.r - 'A']);
    }

    public static void inorder(Node curr){
        if(curr.l != '.') inorder(graph[curr.l - 'A']);
        sb.append(curr.node);
        if(curr.r != '.') inorder(graph[curr.r - 'A']);}

    public static void postorder(Node curr){
        if(curr.l != '.') postorder(graph[curr.l - 'A']);
        if(curr.r != '.') postorder(graph[curr.r - 'A']);
        sb.append(curr.node);
    }
}
