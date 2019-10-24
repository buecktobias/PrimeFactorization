import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

public class PrimeFactorization {
    public static void main(String[] args) {
        List<Integer> factors = primeFactorization(27040123);
        print(factors);

    }
    public static <T> void print(List<T> l){
        for(T n: l){
            System.out.print(n + " ");
        }
    }


    public static List<Integer> sieveOfEratosthenes(int upperBound){

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

    public static List<Integer> primeFactorization(long number){
        List<Integer> factors = new LinkedList<>();

        List<Integer> primes = getPrimes((int)sqrt(number));

        while(number > 1) {
            boolean isPrimeNumber = true;
            for (int prime : primes) {
                if (number % prime == 0) {
                    isPrimeNumber = false;
                    number /= prime;
                    factors.add(prime);
                    break;
                }
            }
            if (isPrimeNumber) {
                factors.add((int) number);
                break;
            }
        }
        return factors;
    }
}
