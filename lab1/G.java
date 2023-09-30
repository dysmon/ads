package lab1;

import java.util.*;

// nth super Prime number - SieveOfEratosthenes

public class G {
    public static void main(String[] args) {
        int MAX_SIZE = 100000;
        ArrayList<Integer> primeList = new ArrayList<>();
        ArrayList<Integer> superPrime = new ArrayList<>();
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
        for(int i = 2;i < primeList.size();i++){
            if(checkPrime[i]){
                superPrime.add(primeList.get(i - 1));
            }
        }

        System.out.println(superPrime.get(nthPrime - 1));

    }
}
