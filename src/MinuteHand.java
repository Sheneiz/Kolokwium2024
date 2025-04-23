import java.time.LocalTime;

public class MinuteHand extends ClockHand {
    private double angle;

    @Override
    public void setTime(LocalTime time) {
        this.angle = time.getMinute() * 6 + time.getSecond() * 0.1; // 360 stopni / 60 minut
    }

    @Override
    public String toSvg() {
        return String.format(
            "<line x1=\"100\" y1=\"100\" x2=\"100\" y2=\"30\" stroke=\"blue\" stroke-width=\"3\" transform=\"rotate(%f, 100, 100)\"/>",
            angle
        );
    }
}
