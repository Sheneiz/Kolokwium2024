import java.time.LocalTime;
import java.util.Locale;

public class SecondHand extends ClockHand
{
    int y=-80;
    String color="red";
    int width=1;
    int angle;

    public void setTime(LocalTime time)
    {
        this.time=time;
        angle=time.getSecond()*6;
    }
    @Override
    public String toSvg(String param)
    {
        return super.toSvg(String.format(Locale.ENGLISH, "y2=\"%d\" stroke=\"%s\" stroke-width=\"%d\" transform=\"rotate(%d)\"",y,color,width,angle));
    }
}
