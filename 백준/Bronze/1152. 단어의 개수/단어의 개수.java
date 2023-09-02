import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine().trim();
        if(sentence.isEmpty()){
            System.out.println(0);
        } else {
            String[] str = sentence.split(" ");
            System.out.println(str.length);
        }
    }
}
