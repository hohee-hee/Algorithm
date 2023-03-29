import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
   
	static int N; //입력 받을 N
	static int[][] dist, stairs; //거리, 계단
	static int[] per; //가능한 수열
	static int ppl, min; //사람 수, 최솟값
   
	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   int T = sc.nextInt();
	   for(int tc = 1 ; tc <= T ; tc++) {
		   //0. 필요한 변수
		   ArrayList<int[]> people = new ArrayList<>(); //사람 위치 저장
		   stairs = new int[2][3]; //계단 정보 저장
		   int sidx = 0; //stairs idx
		   
		   
		   //1. 입력받기
		   N = sc.nextInt();         
		   for(int i = 0 ; i < N ; i++) {
			   for(int j = 0 ; j < N ; j++) {
				   int num = sc.nextInt();
				   if(num == 0) continue;
				   else if(num == 1) people.add(new int[] {i,j});
				   else stairs[sidx++] = new int[]{i,j,num};
			   }
		   }
		   
		   //2. dist 구해서 저장하기
		   ppl = people.size();
		   dist = new int[ppl][2];
		   for(int i = 0 ; i < ppl ; i++) {
			   dist[i][0] = Math.abs(people.get(i)[0] - stairs[0][0]) + Math.abs(people.get(i)[1] - stairs[0][1]);
			   dist[i][1] = Math.abs(people.get(i)[0] - stairs[1][0]) + Math.abs(people.get(i)[1] - stairs[1][1]);
		   }
//		   for(int[] d : dist)
//		   System.out.println(Arrays.toString(d));
		   //3. 백트래킹
		   per = new int[ppl];
		   min = Integer.MAX_VALUE;
		   BackTracking(0);
		   
		   //4. 출력
		   System.out.println("#" + tc + " " + min);
	   }
   }

   private static void BackTracking(int depth) {
	   if(depth == ppl) {
         //시간검사
//		 System.out.println(Arrays.toString(per));
		 int check =  timeCheck();
         min = Math.min(min, check);
//         System.out.println(min);  
         return;
	   }
	   
	   per[depth] = 0;
	   BackTracking(depth+1);
	   
	   per[depth] = 1;
	   BackTracking(depth+1);
   }

   private static int timeCheck() {
	   //1. 카운트 배열 만들기
	   int[] cnt0 = new int[(N-1) * 2];
	   int[] cnt1 = new int[(N-1) * 2];
	   for(int i = 0 ; i < ppl ; i++) {
		   if(per[i] == 0) cnt0[dist[i][0]]++;
		   else cnt1[dist[i][1]]++;
	   }
	   
	   //2. 시간 계산하기
	   int time0 = 0;
	   int time1 = 0;
	   int time = 0;
	   ArrayList<Integer> q0 = new ArrayList<>();
	   ArrayList<Integer> q1 = new ArrayList<>();
//	   int c = 0;
//	   System.out.println("hello");
	   while(true){
		   //방 안 사람이 모두 최소 계단에는 도착 했을 때
		   if(!isPerson(cnt0) && !isPerson(cnt1)) break;
		   
		   time++;
		   //아직 방 안에 사람이 있을 때
		   //1. 큐에 있는 사람들 모두 1씩 시간 올리기
		   for(int i = 0 ; i < q0.size(); i++) {
			   int t = q0.get(i);
			   q0.add(i, ++t);
			   q0.remove(i+1);
		   }
		   for(int i = 0 ; i < q1.size(); i++) {
			   int t = q1.get(i);
			   q1.add(i, ++t);
			   q1.remove(i+1);
		   }
		   while(!q0.isEmpty() && q0.get(0) == stairs[0][2]+1) {
			   q0.remove(0);
		   }
		   while(!q1.isEmpty() && q1.get(0) == stairs[1][2]+1) {
			   q1.remove(0);
		   }
		   
//		   System.out.println(q0.toString());
//		   System.out.println(q1.toString());
//		   System.out.println("--------");
		   //2. 이동시켜서 큐에 넣기
		   for(int i = 0 ; i < cnt0.length ; i++) {
			   if(i > time) break;
			   if(q0.size() == 3 && q1.size() == 3) break;
			   
			   while(cnt0[i] > 0 && q0.size() < 3) {
				   cnt0[i]--;
				   if(i == time) q0.add(0);
				   else q0.add(1);
			   }		   
			   
			   while(cnt1[i] > 0 && q1.size() < 3) {
				   cnt1[i]--;
				   if(i == time) q1.add(0);
				   else q1.add(1);
			   }			   
		   }		   
//		   System.out.println(q0.toString());
//		   System.out.println(q1.toString());
//		   
//		   System.out.println();
	   }
//	   System.out.println();
//	   System.out.println("time : " + time);
//		   System.out.println(q0.toString());
//		   System.out.println(q1.toString());
	   int plus = 0;
	   for(int i = 0 ; i < q0.size(); i++) {
		   plus = Math.max(stairs[0][2]+1 - q0.get(i), plus);
	   }
	   for(int i = 0 ; i < q1.size(); i++) {
		   plus = Math.max(stairs[1][2]+1 - q1.get(i), plus);
	   }
	   
	   return time+plus;
	}
   
   
   //사람여부 체크
	private static boolean isPerson(int[] cnt){
		for(int i = 1 ; i < cnt.length ; i++){
			if(cnt[i] != 0) return true;
		}
		return false;
	}
}