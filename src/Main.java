import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main
{
    //javac -d ./out ./src/*.java

    //jar cfm ./bin/app.jar ./src/manifest.mf -C ./out .
    //"C:\Program Files\Java\jdk-24\bin\jar.exe" cfm ./bin/app.jar ./src/manifest.mf -C ./out .

    //java -jar ./bin/app.jar
    public static void main(String[] args) throws InterruptedException {
        //N1
        {
            System.out.println("N1");
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
        Thread.sleep(1000);
        //N2
        {
            System.out.println("\nN2");
            System.out.print("input orders count: ");
            Scanner s = new Scanner(System.in);
            int n = Integer.parseInt(s.nextLine());
            ShoeWarehouse sw = new ShoeWarehouse();

            Thread addThread = new Thread
            (
                () ->
                {
                    Random r = new Random();
                    for(int i = 0; i < n; i++)
                    {
                        ShoeWarehouse.Order ord = new ShoeWarehouse.Order();
                        ord.id = r.nextInt();
                        ord.type = r.nextInt();
                        ord.amount = r.nextInt();
                        try {
                            sw.receiveOrder(ord);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            );

            Thread remThread = new Thread
            (
                () ->
                {
                    for(int i = 0; i < n; i++)
                    {
                        try {
                            sw.fulfillOrder();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            );

            addThread.start();
            remThread.start();
        }
        Thread.sleep(1000);
        //N3
        {
            System.out.println("\nN3");
            System.out.print("input orders count: ");
            Scanner s = new Scanner(System.in);
            int n = Integer.parseInt(s.nextLine());
            ShoeWarehouse sw = new ShoeWarehouse();

            ExecutorService ex = Executors.newFixedThreadPool(2);

            ex.submit
            (
                () ->
                {
                    Random r = new Random();
                    for(int i = 0; i < n; i++)
                    {
                        ShoeWarehouse.Order ord = new ShoeWarehouse.Order();
                        ord.id = r.nextInt();
                        ord.type = r.nextInt();
                        ord.amount = r.nextInt();
                        try {
                            sw.receiveOrder(ord);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            );

            ex.submit
            (
                () ->
                {
                    for(int i = 0; i < n; i++)
                    {
                        try {
                            sw.fulfillOrder();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            );

            ex.shutdown();
        }
    }
}