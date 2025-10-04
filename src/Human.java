import java.util.Random;

public class Human
{
    String fn;
    String sn;
    int age;
    Human()
    {
        Random randomGenerator = new Random();
        age = randomGenerator.nextInt(5);
        fn = randomGenerator.nextInt(5) + "";
        sn = randomGenerator.nextInt(5) + "";
    }

    @Override
    public String toString() {
        return "{" + fn + ", " + sn + ", " + age + "}";
    }
}