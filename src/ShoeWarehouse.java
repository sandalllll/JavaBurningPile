import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ShoeWarehouse
{
    public static class Order
    {
        public int id;
        public int type;
        public int amount;
        public Order()
        {
            id = type = amount = 0;
        }
    }

    public int[] itemTypes;
    private List<Order> orders;

    private List<Order> queue;

    public ShoeWarehouse()
    {
        itemTypes = null;
        orders = null;

        queue = new ArrayList<Order>();
    }

    public synchronized void receiveOrder(Order order) throws InterruptedException
    {
        if (queue.size() >= 10)
            wait();
        queue.addLast(order);
        System.out.println("Added");
        notifyAll();
    }

    public synchronized void fulfillOrder() throws InterruptedException
    {
        if (queue.isEmpty())
            wait();
        queue.removeFirst();
        System.out.println("Removed");
        notifyAll();
    }
}
