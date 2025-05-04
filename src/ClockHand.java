import java.time.LocalTime;
import java.util.Locale;

public abstract class ClockHand
{
    LocalTime time;

    public void setTime(LocalTime time)
    {
        this.time=time;
    }

    public String toSvg(String param)
    {
        return String.format(Locale.ENGLISH,"<line x1=\"0\" y1=\"0\" x2=\"0\" %s />\n", param);
    }
}
