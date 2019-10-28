import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

public class PrimeFactorization {

    public static void main(String[] args) {

    }
    public static List<BigInteger> primeFactorization(BigInteger number){
        List<BigInteger> factors = new LinkedList<>();
        List<Integer> primes = Primes.getPrimes(Integer.parseInt(number.sqrt().toString()));

        while(number.compareTo(BigInteger.valueOf(1)) > 0) { // TODO
            boolean isPrimeNumber = true;
            for (int prime : primes) {
                if (number.mod(BigInteger.valueOf(prime)).compareTo(BigInteger.ZERO) == 0) {
                    isPrimeNumber = false;
                    number = number.divide(BigInteger.valueOf(prime));
                    factors.add(BigInteger.valueOf(prime));
                    break;
                }
            }
            if (isPrimeNumber) {
                factors.add(number);
                break;
            }
        }

        return factors;
    }
}
