import java.util.ArrayList;

public class OddEvenSeparator
{
    public OddEvenSeparator()
    {
        no = new ArrayList<Integer>();
        ne = new ArrayList<Integer>();
    }

    public void addNumber(int number)
    {
        if ((number % 2) == 1)
            no.add(number);
        else
            ne.add(number);
    }

    public void even()
    {
        if (ne.isEmpty())
            return;
        System.out.print(ne.get(0));
        for (int i = 1; i < ne.size(); i++)
        {
            System.out.print(", " + ne.get(i));
        }
    }

    public void odd()
    {
        if (no.isEmpty())
            return;
        System.out.print(no.get(0));
        for (int i = 1; i < no.size(); i++)
        {
            System.out.print(", " + no.get(i));
        }
    }

    private ArrayList<Integer> no;
    private ArrayList<Integer> ne;
}