import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] calls = new int[N];
        for(int i = 0 ; i < N ; i++) calls[i] = Integer.parseInt(st.nextToken());

        int Y = yeongsik(N, calls);
        int M = minsik(N, calls);

        if(Y < M) {
            System.out.println("Y " + Y);
        } else if(Y > M) {
            System.out.println("M " + M);
        } else {
            System.out.println("Y M " + Y);
        }
    }

    public static int yeongsik(int N, int[] calls) {
        int price = 0;
        for(int i = 0 ; i < N ; i++) {
            price += (calls[i] / 30 + 1) * 10;
        }
        return price;
    }

    public static int minsik(int N, int[] calls) {
        int price = 0;
        for(int i = 0 ; i < N ; i++) {
            price += (calls[i] / 60 + 1) * 15;
        }
        return price;
    }
}
