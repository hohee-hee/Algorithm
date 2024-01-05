import java.io.*;
import java.util.*;

public class Main {

    public static LinkedList<Integer> STACK = new LinkedList<>();

    public static int HEAD;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HEAD = -1;

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command) {
                case "push" :
                    int x = Integer.parseInt(st.nextToken());
                    push(x);
                    break;
                case "pop" :
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty" :
                    sb.append(empty()).append("\n");
                    break;
                default:
                    sb.append(top()).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void push(int x) {
        HEAD++;
        STACK.add(x);
    }

    public static int pop() {
        if(HEAD == -1) return -1;

        int num = STACK.get(HEAD);
        STACK.remove(HEAD);
        HEAD--;

        return num;
    }

    public static int size() {
        return STACK.size();
    }

    public static int empty() {
        if(HEAD == -1) return 1;
        else return 0;
    }

    public static int top(){
        if(HEAD == -1) return -1;
        return STACK.getLast();
    }
}
