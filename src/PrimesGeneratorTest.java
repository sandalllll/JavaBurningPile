import java.util.Arrays;
import java.util.Iterator;

public class PrimesGeneratorTest
{
    public PrimesGeneratorTest()
    {

    }

    public  void Check(int[] primes)
    {
        Iterator<Integer> iterator = Arrays.stream(primes).iterator();

        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + " ");
        }
        System.out.print('\n');

        for (int i = 0; i < primes.length/2; i++)
        {
            int a = primes[i];
            primes[i] = primes[primes.length - 1 - i];
            primes[primes.length - 1 - i] = a;
        }

        iterator = Arrays.stream(primes).iterator();

        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + " ");
        }
        System.out.print('\n');

        for (int i = 0; i < primes.length/2; i++)
        {
            int a = primes[i];
            primes[i] = primes[primes.length - 1 - i];
            primes[primes.length - 1 - i] = a;
        }
    }
}