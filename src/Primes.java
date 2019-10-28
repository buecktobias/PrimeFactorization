import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Primes {
    private static List<Integer> sieveOfEratosthenes(int upperBound){

        List<Integer> result = new LinkedList<>();
        boolean[] primes = new boolean[upperBound];
        for(int i= 2; i < primes.length;i++){
            primes[i] = true;
        }
        primes[0] = false;
        primes[1] = false;



        int squareRoot = (int)sqrt(upperBound);
        for(int i = 0; i < squareRoot; i++){
            if(primes[i]){
                for(int number = i*i; number < upperBound; number +=i){
                    primes[number] = false;
                }
            }
        }
        for(int i= 0; i <primes.length; i++){
            if(primes[i]){
                result.add(i);
            }
        }
        return result;
    }
    public static List<Integer> getPrimes(int upperBound){
        return sieveOfEratosthenes(upperBound);
    }
}
