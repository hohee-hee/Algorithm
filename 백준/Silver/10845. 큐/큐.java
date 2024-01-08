import java.io.*;
import java.util.*;

public class Main {
    public static int[] queue = new int[10001];
    public static int head = 0;
    public static int cur = 0;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < N ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command) {
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
                default: // push
                    int x = Integer.parseInt(st.nextToken());
                    push(x);
                    break;
            }
        }


        System.out.println(sb);
    }

    public static void push(int x) {
        queue[cur] = x;
        cur++;
    }

    public static int pop() {
        if(head == cur) return -1;

        int num = queue[head++];
        return num;
    }

    public static int size() {
        return cur - head;
    }

    public static int empty() {
        if(head == cur) return 1;
        return 0;
    }

    public static int front() {
        if(head == cur) return -1;
        return queue[head];
    }

    public static int back() {
        if(head == cur) return -1;
        return queue[cur-1];
    }
}
