import java.io.*;

import java.util.*;

public class Main {

    

    public static void main(String[] args) throws IOException{

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        

        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        

        HashMap<String, Integer> pokemons = new HashMap<>();

        HashMap<Integer, String> nums = new HashMap<>();

        for(int i = 1 ; i <= N ; i++){

            String pokemon = br.readLine();

            pokemons.put(pokemon, i);

            nums.put(i, pokemon);

        }

        for(int i = 0 ; i < M ; i++){

            String q = br.readLine();

            if(q.charAt(0) - '0' > 0 && q.charAt(0) - '0' <= 9) {

                int num = Integer.parseInt(q);

                sb.append(nums.get(num)).append("\n");

            } else {

                sb.append(pokemons.get(q)).append("\n");

            }

        }

        System.out.println(sb);

    }

}