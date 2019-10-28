import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        runTimeAnalyses();
    }
    public static void runTimeAnalyses(){
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("primeFactorization.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try {
            out.write("number,time".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        BigInteger n = BigInteger.valueOf(1);
        while(n.compareTo(BigInteger.valueOf(10).pow(16)) < 0){
            n = n.add(BigInteger.valueOf(10).pow(12));
            String data = n.toString() + "," + measureTime(n) + "\n";
            try {
                out.write(data.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static long measureTime(BigInteger N){
        final long start = System.currentTimeMillis();
        PrimeFactorization.primeFactorization(N);
        final long end = System.currentTimeMillis();
        return end -start;
    }


    public static <T> void print(List<T> l){
        for(T n: l){
            System.out.print(n + " ");
        }
    }
}
