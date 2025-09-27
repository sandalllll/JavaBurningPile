public class Circle implements Figure
{
    public Circle(double r) throws IAreaException
    {
        if (r <= 0) throw new Figure.IAreaException();
        this.r = r;
    }

    @Override
    public double area()
    {
        return r * r * 3.14159265358979323846;
    }

    @Override
    public double perimeter()
    {
        return r * 2 * 3.14159265358979323846;
    }

    @Override
    public String toString_()
    {
        return "Circle " + r;
    }

    double r;
}