class Button
{
    public Button()
    {
        c = 0;
    }

    public void click()
    {
        c++;
        System.out.println("Clicked! (" + c + ')');
    }

    public int getClicksCount()
    {
        return c;
    }

    private int c;
}