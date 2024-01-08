import java.io.*;
import java.util.*;

public class Main {

    public static int[] DEQUE = new int[20002];
    public static int FRONT = 10000;
    public static int BACK = 10001;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < N ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command) {
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(pop_front()).append("\n");
                    break;
                case "pop_back":
                    sb.append(pop_back()).append("\n");
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
            }
        }

        System.out.println(sb);
    }

    public static void push_front(int x) {
        DEQUE[FRONT] = x;
        FRONT--;
    }

    public static void push_back(int x) {
        DEQUE[BACK] = x;
        BACK++;
    }

    public static int pop_front(){
        if(FRONT == (BACK - 1)) return -1;
        return DEQUE[++FRONT];
    }

    public static int pop_back(){
        if(FRONT == (BACK - 1)) return -1;
        return DEQUE[--BACK];
    }

    public static int size() {
        if(FRONT == (BACK - 1)) return 0;
        return BACK - FRONT - 1;
    }

    public static int empty() {
        if(FRONT == (BACK - 1)) return 1;
        else return 0;
    }

    public static int front() {
        if(FRONT == (BACK - 1)) return -1;
        return DEQUE[FRONT+1];
    }

    public static int back() {
        if(FRONT == (BACK - 1)) return -1;
        return DEQUE[BACK-1];
    }


}
