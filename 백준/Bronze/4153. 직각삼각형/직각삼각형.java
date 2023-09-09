import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int[] arr = new int[3];
                int cntZero = 0;

                for(int i = 0 ; i < 3 ; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                    if(arr[i] == 0) cntZero++;
                }
                if(cntZero == 3) break;

                Arrays.parallelSort(arr);

                if(arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]) sb.append("right" + "\n");
                else sb.append("wrong"+ "\n");

            }


            System.out.println(sb);

    }
}
