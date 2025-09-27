public class Cylinder
{
    class IVolumeException extends Throwable
    {
        IVolumeException() {}
    }

    public Cylinder(double r, double h) throws IVolumeException
    {
        if (h <= 0) throw new IVolumeException();
        this.f = new Circle(r);
        this.h = h;
    }

    public double volume()
    {
        return f.area() * h;
    }

    Figure f;
    double h;
}
