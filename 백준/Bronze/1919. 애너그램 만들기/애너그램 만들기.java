import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word1 = br.readLine().toCharArray();
        char[] word2 = br.readLine().toCharArray();

        Arrays.parallelSort(word1);
        Arrays.parallelSort(word2);

        boolean[] chk1 = new boolean[word1.length];
        boolean[] chk2 = new boolean[word2.length];

        int pt1 = 0;
        int pt2 = 0;

        while(pt1 < word1.length && pt2 < word2.length) {
            if(word1[pt1] < word2[pt2]) {
                pt1++;
            } else if(word1[pt1] > word2[pt2]) {
                pt2++;
            } else {
                chk1[pt1++] = true;
                chk2[pt2++] = true;
            }
        }

        int answer = 0;

        for(int i = 0 ; i < word1.length ; i++) {
            if(chk1[i]) continue;
            answer++;
        }

        for(int i = 0 ; i < word2.length ; i++) {
            if(chk2[i]) continue;
            answer++;
        }

        System.out.println(answer);
    }
}
