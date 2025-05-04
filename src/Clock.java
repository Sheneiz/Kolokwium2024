import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Clock
{
    LocalTime time;
    City city;

    public Clock(City c)
    {
        this.city=c;
    }

    public void setCity(City city) {
        double timezone=this.city.timezone;
        this.city = city;
        timezone=this.city.timezone-timezone;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        int hour= (int) (time.getHour()+timezone);
        if(hour>23)
        {
            hour-=24;
        }
        String SH= hour <10 ? String.format("0%d",hour): String.format("%d",hour);
        String SM=time.getMinute() <10 ? String.format("0%d",time.getMinute()): String.format("%d",time.getMinute());
        String SS=time.getSecond()<10 ? String.format("0%d",time.getSecond()): String.format("%d",time.getSecond());
        time = LocalTime.from(formatter.parse(String.format("%s:%s:%s",SH,SM,SS)));
        //time = LocalTime.from(formatter.parse(String.format("%d:%d:%d",hour , time.getMinute(), time.getSecond())));
    }

    public void setCurrentTime()
    {
        time= LocalTime.now();
    }
    public void setTime(int hour, int minute, int second)
    {
        try
        {
           if(hour>23 || hour<0)
           {
               throw new IllegalArgumentException(String.format(Locale.ENGLISH,"%s nie jest wlasciwa wartoscia dla godzin"));
           }
            if(minute>60 || minute<0)
            {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH,"%s nie jest wlasciwa wartoscia dla minut"));
            }
            if(second>60 || second<0)
            {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH,"%s nie jest wlasciwa wartoscia dla sekund"));
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            time = LocalTime.from(formatter.parse(String.format("%d:%d:%d",hour, minute, second)));
        }catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return time.format(formatter);
    }
}
