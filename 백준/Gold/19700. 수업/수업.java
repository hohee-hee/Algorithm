import java.io.*;
import java.util.*;

public class Main {
    public static class Student {
        int height;
        int rank;

        Student(int height, int rank) {
            this.height = height;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "height=" + height +
                    ", rank=" + rank +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<Student> stu = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.height == o2.height) return o1.rank - o2.rank;
                return o2.height-o1.height;
            }
        });

        StringTokenizer st;
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            stu.add(new Student(h, k));
        }

        TreeMap<Integer, LinkedList<Integer>> teamSize = new TreeMap<>();
        int tNum = 0;

        while(!stu.isEmpty()) {
            Student curr = stu.first();
            if(teamSize.floorKey(curr.rank-1) == null) {
                if(!teamSize.containsKey(1)) teamSize.put(1, new LinkedList<>());
                LinkedList<Integer> list = teamSize.remove(1);
                list.add(++tNum);
                teamSize.put(1, list);
                stu.remove(curr);
            } else {
                int tKey = teamSize.floorKey(curr.rank-1);
                LinkedList<Integer> list = teamSize.remove(tKey);
                int team = list.removeFirst();
                if(!list.isEmpty()) teamSize.put(tKey, list);
                if(!teamSize.containsKey(tKey+1)) teamSize.put(tKey+1, new LinkedList<>());
                list = teamSize.remove(tKey+1);
                list.add(team);
                teamSize.put(tKey+1, list);
                stu.remove(curr);
            }
        }

        System.out.println(tNum);
    }
}