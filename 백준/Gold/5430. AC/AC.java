import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String array = br.readLine();
            array = array.substring(1, array.length()-1);

            ArrayDeque<String> dq = new ArrayDeque<>();
            if(array.length() != 0) {
                String[] nums =  array.split(",");
                for(int i = 0 ; i < nums.length ; i++) dq.offerLast(nums[i]);
            }

            boolean isAsc = true;
            boolean isError = false;
            for(int i = 0 ; i < p.length() ; i++) {
                char command = p.charAt(i);

                if(command == 'R') {
                    isAsc = !isAsc;
                } else {
                    if(dq.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if(isAsc) dq.pollFirst();
                    else dq.pollLast();
                }
            }

            if(isError) {
                sb.append("error").append("\n");
            } else if(dq.isEmpty()) {
              sb.append("[]").append("\n");
            } else {
                sb.append("[");
                if(isAsc) {
                while(!dq.isEmpty()) sb.append(dq.pollFirst()).append(",");
                sb.deleteCharAt(sb.length() - 1);
                } else {
                while(!dq.isEmpty()) sb.append(dq.pollLast()).append(",");
                sb.deleteCharAt(sb.length() - 1);
                }

                sb.append("]").append("\n");
            }
        }


        System.out.println(sb);
    }
}