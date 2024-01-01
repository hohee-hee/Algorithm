import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 3 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int bae = 0;
            for(int yut = 0 ; yut < 4 ; yut++) {
                int y = Integer.parseInt(st.nextToken());
                if(y == 0) {
                    bae++;
                }
            }

            switch(bae){
                case 1:
                    sb.append('A').append('\n');
                    break;
                case 2:
                    sb.append('B').append('\n');
                    break;
                case 3:
                    sb.append('C').append('\n');
                    break;
                case 4:
                    sb.append('D').append('\n');
                    break;
                default:
                    sb.append('E').append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}
