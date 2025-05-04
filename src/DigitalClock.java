public class DigitalClock extends Clock
{
    boolean mode =true; //true - 24h


    public DigitalClock(City city, boolean mode) {
        super(city);
        this.mode=mode;
    }
    @Override
    public String toString() {
        if(mode)
        {
            return super.toString();
        }
        return String.format("%d:%d:%d %s", time.getHour()>11 ? time.getHour()-12 : time.getHour(), time.getMinute(), time.getSecond(), time.getHour()>11 ? "PM" : "AM");
    }
}
