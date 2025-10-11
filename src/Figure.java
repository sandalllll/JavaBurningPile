public interface Figure
{
    class IAreaException extends Throwable
    {
        IAreaException() {}
    }

    public double area();
    public double perimeter();
    public String toString_();
}