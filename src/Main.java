

public class Main
{
    //javac -d ./out ./src/*.java

    //jar cfm ./bin/app.jar ./src/manifest.mf -C ./out .
    //"C:\Program Files\Java\jdk-24\bin\jar.exe" cfm ./bin/app.jar ./src/manifest.mf -C ./out .

    //java -jar ./bin/app.jar
    public static void main(String[] args)
    {
        //N1
        {
            Thread evenThread = new EvenNumbers();
            Thread oddThread = new Thread(
                () ->
                {
                    for(int i = 1; i < 10; i += 2)
                    {
                        System.out.println(i);
                    }
                }
            );

            evenThread.start();
            oddThread.start();
        }

        //N2
        {

        }
    }
}