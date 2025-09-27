public class Rectangle implements Figure
{
    Rectangle(double width, double height) throws IAreaException
    {
        if ((width <= 0) || (height <= 0)) throw new Figure.IAreaException();
        w = width;
        h = height;
    }

    @Override
    public double area()
    {
        return w * h;
    }

    @Override
    public double perimeter()
    {
        return (w + h) * 2;
    }

    @Override
    public String toString_()
    {
        return "Rectangle " + h + 'x' + w;
    }

    double w, h;
}
