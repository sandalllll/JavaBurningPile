class Bell
{
    public Bell()
    {
        isDong = false;
    }

    public void sound()
    {
        if (isDong)
            System.out.println("Dong!");
        else
            System.out.println("Ding!");
        isDong = !isDong;
    }

    private boolean isDong;
}