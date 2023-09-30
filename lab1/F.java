package lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// nth Prime number - SieveOfEratosthenes

public class F {
    public static void main(String[] args) {
        int MAX_SIZE = 100000;
        ArrayList<Integer> primeList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int nthPrime = scan.nextInt();
        boolean [] checkPrime = new boolean[MAX_SIZE];

        Arrays.fill(checkPrime,true);

        for(int i = 2;i * i < MAX_SIZE; i++){
            if(checkPrime[i]) {
                for (int j = i * i; j < MAX_SIZE; j+=i){
                    checkPrime[j] = false;
                }
            }
        }
        for(int i = 2; i < MAX_SIZE;i++){
            if(checkPrime[i]){
                primeList.add(i);
            }
        }

        System.out.println(primeList.get(nthPrime - 1));

    }
}
