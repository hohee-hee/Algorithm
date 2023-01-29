
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int answer = 0; //정답을 저장할 변수
        int N = sc.nextInt(); //N을 받을 변수
        int K = sc.nextInt(); //K를 받을 변수
        int num = 2; //
        
        int[] nums = new int[N -1]; // 2부터 N까지의 수를 저장할 배열       
        //nums에 2부터 N까지를 저장
        //2가 시작이므로 인데스인 i에 +2를 더한다.
        for(int i = 0 ; i < N-1 ; i++){
        	nums[i] = i+2;
        }
        
        int P = 0; //아직 지우지 않은 수 중 가장 작은 수 P
        int cnt = 0; //K번째임을 확인할 지표
        // 숫자를 지워갈 반복문
        outer : for(int i = 0 ; i < N-1 ; i++) {
        	//아직 숫자가 지워지지 않았다면(0이 아니라면)P에 저장 후 숫자 지우기
        	if(nums[i] != 0) {
       			P = nums[i];
       			int multi = 1; //곱할 수
           		for(int j = i ; j < N-1 ;j++) {
           			/*
           			 * P의 배수임을 확인하는 조건문
          			 * : nums[j]가 P의 배수이면
           			 * 1. nums[j]를 answer에 저장
           			 * 2. 그리고 nums[j]는 지워주기(0으로 만들기)
           			 * 3. 카운팅을위해 cnt에 1을 더해주기
           			 * : nums[j]가 p*multi보다 크면
           			 * 1. 다음 p의 배수로 넘어가기
           			 */
           			if(P * multi == nums[j]) { 
           				answer = nums[j];           				
           				nums[j] = 0;
           				cnt++;
           				multi++;
           				if(cnt == K)
           					break outer;
           			}
           			else if(P*multi < nums[j]) {
           				multi++;
           			}
           		}
       		}
       	}
        System.out.println(answer);
    }
}
