import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(m == 0) {
            System.out.println(0);
            return;
        }

        // 분자의 2와 5의 개수
        int numeTwo = count(n, 2);
        int numeFive = count(n, 5);
        int numeTen = Math.min(numeTwo, numeFive);

        // 분모의 2와 5의 개수
        int denoTwo = count(m, 2) + count(n-m, 2);
        int denoFive = count(m, 5) + count(n-m, 5);
        int denoTen = Math.min(denoTwo, denoFive);

        // 약분하기
        int finalTwo = Math.max(0, numeTwo-denoTwo);
        int finalFive = Math.max(0, numeFive-denoFive);

        System.out.println(Math.min(finalFive, finalTwo));
    }

    public static int count(int num, int target) {
        int answer = 0;
        long multi = target;
        while(multi <= num) {
            answer += num/multi;
            multi *= target;
        }
        return answer;
    }
}