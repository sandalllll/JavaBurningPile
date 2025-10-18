import java.util.ArrayList;
import java.util.List;

public class ShoeWarehouse
{
    public class Order
    {
        public int id;
        public int type;
        public int amount;
    }

    List<Order> queue;

    public ShoeWarehouse()
    {
        queue = new ArrayList<Order>();
    }

    public void receiveOrder(Order order) throws InterruptedException
    {
        if (queue.size() >= 10)
            wait();
        queue.addLast(order);
        notifyAll();
    }

    public void fulfillOrder() throws InterruptedException
    {
        if (queue.isEmpty())
            wait();
        queue.removeFirst();
        notifyAll();
    }
}
