import java.io.FileReader;

public class FileAnalyzer
{
    private static int chk(FileReader r)
    {
        try
        {
            return r.read();
        }
        catch (java.io.IOException a)
        {
            return -1;
        }
    }

    public static FileStat analyze(String path)
    {
        FileStat stat = new FileStat();
        FileReader f;
        try
        {
            f = new FileReader(path);
        }
        catch (java.io.FileNotFoundException a )
        {
            return null;
        }
        stat.lines = 1;
        int c;
        boolean prevR = false, prevC = false;
        while ((c = chk(f)) != -1)
        {
            if ((c == '\r') || (c == '\n') || (c == ' '))
            {
                if (prevC)
                    stat.words++;
                if (c == '\r')
                    stat.symbols++;
                else if (c == '\n')
                {
                    if (prevR)
                        stat.symbols--;
                    stat.lines++;
                }
            }
            else
                stat.symbols++;

            if (c == '\r')
            {
                prevR = true;
                prevC = false;
            }
            else if ((c != '\n') && (c != ' '))
            {
                prevC = true;
                prevR = false;
            }
            else
            {
                prevC = false;
                prevR = false;
            }
        }
        if ((stat.symbols == 0) && (stat.lines == 1))
            stat.lines = 0;
        try
        {
            f.close();
        }
        catch (java.io.IOException a)
        {

        }
        return stat;
    }
}
