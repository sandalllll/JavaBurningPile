import java.util.Scanner;

public class Main
{
    //javac -d ./out ./src/*.java

    //jar cfm ./bin/app.jar ./src/manifest.mf -C ./out .
    //"C:\Program Files\Java\jdk-24\bin\jar.exe" cfm ./bin/app.jar ./src/manifest.mf -C ./out .

    //java -jar ./bin/app.jar
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //N1
        System.out.println("No 1. Button.");
        {
            Button button = new Button();
            System.out.println("Print enter to continue or something else to break.");
            while (true)
            {
                String in = scanner.nextLine();
                if (!in.isEmpty())
                    break;
                button.click();
            }
            System.out.println("Clicked " + button.getClicksCount() + " times.");
        }

        //N2
        System.out.println("\nNo 2. Balance.");
        {
            Balance balance = new Balance();
            System.out.println("Print \"R <value>\" to add right, \"L <value>\" to add left or something else to break.");
            while (true)
            {
                String in = scanner.nextLine();
                if (!((in.length() >= 3) && (in.charAt(1) == ' ') && ((in.charAt(0) == 'R') || (in.charAt(0) == 'L'))))
                    break;
                boolean toL = (in.charAt(0) == 'L');
                in = in.substring(2);
                int valToAdd;
                try
                {
                    valToAdd = Integer.parseInt(in);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Error, number not recognized.");
                    continue;
                }
                if (toL)
                    balance.addLeft(valToAdd);
                else
                    balance.addRight(valToAdd);
            }
            System.out.println("Biggest is: " + balance.result() + '.');
        }

        //N3
        System.out.println("\nNo 3. Bell.");
        {
            Bell bell = new Bell();
            System.out.println("Print enter to continue or something else to break.");
            while (true)
            {
                String in = scanner.nextLine();
                if (!in.isEmpty())
                    break;
                bell.sound();
            }
        }

        //N4
        System.out.println("\nNo 4. OddEvenSeparator.");
        {
            OddEvenSeparator oddEvenSeparator = new OddEvenSeparator();
            System.out.println("Print \"V <value>\" to add or something else to break.");
            while (true)
            {
                String in = scanner.nextLine();
                if (!((in.length() >= 3) && (in.charAt(1) == ' ') && (in.charAt(0) == 'V')))
                    break;
                boolean toL = (in.charAt(0) == 'L');
                in = in.substring(2);
                int valToAdd;
                try
                {
                    valToAdd = Integer.parseInt(in);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Error, number not recognized.");
                    continue;
                }
                oddEvenSeparator.addNumber(valToAdd);
            }
            System.out.print("Evens: ");
            oddEvenSeparator.even();
            System.out.print(".\nOdds: ");
            oddEvenSeparator.odd();
            System.out.print(".\n");
        }

        //N5
        System.out.println("\nNo 5. Table.");
        {
            System.out.println("Table(2, 4)");
            Table t = new Table(2, 4);
            System.out.println("setValue(0, 0, -3)");
            t.setValue(0, 0, -3);
            System.out.println("setValue(1, 1, 2)");
            t.setValue(1, 1, 2);
            System.out.println("setValue(0, 2, 5)");
            t.setValue(0, 2, 5);
            System.out.println("getValue(0, 1)");
            System.out.println(t.getValue(0, 1));
            System.out.println("getValue(0, 2)");
            System.out.println(t.getValue(0, 2));
            System.out.println(t.toString_());
            System.out.println("average: " + t.average());
        }

        //N6
        System.out.println("\nNo 6. Shapes.");
        {
            try
            {
                Circle c = new Circle(4.25);
                System.out.println("Shape: " + c.toString_());
                System.out.println("Area: " + c.area());
                System.out.println("Perimeter: " + c.perimeter());
            }
            catch (Figure.IAreaException a)
            {
                System.out.println("err while create circle");
            }

            try
            {
                Rectangle r = new Rectangle(6.17, 3.08);
                System.out.println("Shape: " + r.toString_());
                System.out.println("Area: " + r.area());
                System.out.println("Perimeter: " + r.perimeter());
            }
            catch (Figure.IAreaException a)
            {
                System.out.println("err while create rectangle");
            }

            try
            {
                Rectangle r = new Rectangle(6.17, -3.08);
                System.out.println("Shape: " + r.toString_());
                System.out.println("Area: " + r.area());
                System.out.println("Perimeter: " + r.perimeter());
            }
            catch (Figure.IAreaException a)
            {
                System.out.println("err while create rectangle");
            }


            try
            {
                Cylinder c = new Cylinder(2.01, 4.65);
                System.out.println("Cylinder(2.01, 4.65) volume: " + c.volume());
            }
            catch (Cylinder.IVolumeException a)
            {
                System.out.println("err while create cylinder");
            }

            try
            {
                Cylinder c = new Cylinder(2.01, -4.65);
                System.out.println("Cylinder(2.01, 4.65) volume: " + c.volume());
            }
            catch (Cylinder.IVolumeException a)
            {
                System.out.println("err while create cylinder");
            }
        }

        //N7
        System.out.println("\nNo 7. FileAnalyzer.");
        {
            System.out.println("File: statTest");
            FileStat stats = FileAnalyzer.analyze(".\\statTest");
            if (stats == null)
                System.out.println("can not open file");
            else
            {
                System.out.println("lines: " + stats.lines);
                System.out.println("words: " + stats.words);
                System.out.println("symbols: " + stats.symbols);
            }
        }
        scanner.close();
    }
}