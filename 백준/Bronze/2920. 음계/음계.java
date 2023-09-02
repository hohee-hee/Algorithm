import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] melody = new int[8];
        for(int i = 0 ; i < 8 ; i++){
            melody[i] = Integer.parseInt(st.nextToken());
        }

        if(melody[0] == 1){
            for(int i = 1 ; i < 8 ; i++){
                if(melody[i] != melody[i-1]+1){
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("ascending");
            return;
        }

        if(melody[0] == 8){
            for(int i = 1 ; i < 8 ; i++){
                if(melody[i] != melody[i-1]-1){
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("descending");
            return;
        }

        System.out.println("mixed");
    }
}
