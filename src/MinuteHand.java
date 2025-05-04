import java.time.LocalTime;
import java.util.Locale;

public class MinuteHand extends ClockHand
{
    int y=-70;
    String color="black";
    int width=2;
    double angle;

    public void setTime(LocalTime time)
    {
        this.time=time;
        angle=time.getMinute()*6+(time.getSecond()*6)/60;
    }
    @Override
    public String toSvg(String param)
    {
        return super.toSvg(String.format(Locale.ENGLISH, "y2=\"%d\" stroke=\"%s\" stroke-width=\"%d\" transform=\"rotate(%f)\"",y,color,width,angle));
    }
}
