import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] num = new int[26];

        for(int i = 0 ; i < str.length() ; i++) num[str.charAt(i) - 'a']++;

        for(int i = 0 ; i < 26 ; i++) sb.append(num[i]).append(" ");

        System.out.println(sb);
    }
}
