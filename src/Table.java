public class Table
{
    public Table(int height, int width)
    {
        elements = new int[height * width];
        this.width = width;
    }

    public int getValue(int row, int col)
    {
        return elements[row * width + col];
    }

    public void setValue(int row, int col, int value) { elements[row * width + col] = value; }

    public int rows()
    {
        return elements.length / width;
    }

    public int cols()
    {
        return width;
    }

    public String toString_()
    {
        StringBuilder o = new StringBuilder();
        int height = rows();
        int wid = width - 1;
        for (int y = 0 ; y < height; y++)
        {
            for (int x = 0 ; x < wid; x++)
            {
                o.append(getValue(y, x)).append(' ');
            }
            o.append(getValue(y, wid)).append('\n');
        }
        return o.toString();
    }

    public float average()
    {
        long s = 0;
        for (int element : elements) {
            s += element;
        }
        return (float)((double)s / (double)elements.length);
    }

    private int width;
    private int[] elements;
}
