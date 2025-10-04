import java.util.Comparator;

public class HumanLastNameComp implements Comparator<Human>
{
    @Override
    public int compare(Human o1, Human o2)
    {
        return (int)o1.sn.charAt(0) - (int)o2.sn.charAt(0);
    }
}