public class Balance
{
    public Balance()
    {
        l = r = 0;
    }

    public void addRight(int v)
    {
        r += v;
    }

    public void addLeft(int v)
    {
        l += v;
    }

    public char result()
    {
        return (r == l) ? '=' : ((r > l) ? 'R' : 'L');
    }

    private int l, r;
}