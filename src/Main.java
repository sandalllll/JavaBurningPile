import java.util.Objects;
import java.util.Scanner;

public class Main
{
    //javac -d ./out ./src/*.java

    //jar cfm ./bin/app.jar ./src/manifest.mf -C ./out .
    //"C:\Program Files\Java\jdk-24\bin\jar.exe" cfm ./bin/app.jar ./src/manifest.mf -C ./out .

    //java -jar ./bin/app.jar
    public static void main(String[] args)
    {
        System.out.println("What is your name?");
        String name;
        {
            Scanner scanner = new Scanner(System.in);
            name = scanner.nextLine();
        }
        if (Objects.equals(name.toLowerCase(), "sandal"))
            System.out.println("Liar! That's my name!");
        else
            System.out.println("Hi, " + name + '!');
    }
}