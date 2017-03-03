package Chapter6;

/**
 * Created by bresai on 2017/2/23.
 */
public class SieveOfEratosthenes {
    public void primes(){
        final int limit = 1000000;
        boolean[] crossed = new boolean[limit + 1];
        int prime = 2;
        while (prime * prime < limit){
            System.out.print(prime + " ");

            for (int i = prime * prime ; i < crossed.length; i +=prime){
                crossed[i] = true;
            }

            prime ++;
            while (prime < crossed.length){
                if (crossed[prime]) {
                    prime++;
                }else{
                    break;
                }
            }


        }
    }

    public void recursive(){

    }

    public static void main(String[] args) {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        sieveOfEratosthenes.primes();
    }
}
