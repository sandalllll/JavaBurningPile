import java.util.Arrays;
import java.util.Iterator;

public class PrimeGenerator
{
    public int[] primes;

    private static boolean isPrime(int num)
    {
        for (int i = 2; i * i <= num; i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public PrimeGenerator(int s)
    {
        if (s == 0)
        {
            primes = null;
            return;
        }
        primes = new int[s];
        primes[0] = 2;
        int p = 3;
        for (int i = 1; i < s; i++)
        {
            while (!isPrime(p))
            {
                p += 2;
            }
            primes[i] = p;
            p += 2;
        }
    }
}