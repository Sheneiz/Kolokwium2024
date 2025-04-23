import java.time.LocalTime;

public class HourHand extends ClockHand {
    private double angle;

    @Override
    public void setTime(LocalTime time) {
        this.angle = (time.getHour() % 12) * 30 + time.getMinute() * 0.5; // 360 stopni / 12 godzin
    }

    @Override
    public String toSvg() {
        return String.format(
            "<line x1=\"100\" y1=\"100\" x2=\"100\" y2=\"40\" stroke=\"black\" stroke-width=\"4\" transform=\"rotate(%f, 100, 100)\"/>",
            angle
        );
    }
}

