import java.time.LocalTime;
import java.util.Locale;

public class HourHand extends ClockHand
{
    int y=-50;
    String color="black";
    int width=4;
    double angle;

    public void setTime(LocalTime time)
    {
        this.time=time;
        angle=(time.getMinute()+(time.getMinute()/60)+(time.getSecond()/3600))*15;
    }
    @Override
    public String toSvg(String param)
    {
        return super.toSvg(String.format(Locale.ENGLISH, "y2=\"%d\" stroke=\"%s\" stroke-width=\"%d\" transform=\"rotate(%f)\"",y,color,width,angle));
    }
}
