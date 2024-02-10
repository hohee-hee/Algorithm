import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] two = new int[N*N];
        int tIdx = 0;
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for(int j = i ; j >= 0 ; j--) {
                two[tIdx++] = arr[i] + arr[j];
            }
        }

        Arrays.parallelSort(arr);
        Arrays.parallelSort(two);

        for(int i = N-1 ; i >= 0 ; i--) {
            for(int j = 0 ; j < i ; j++) {
                if(Arrays.binarySearch(two, arr[i] - arr[j]) >= 0) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}