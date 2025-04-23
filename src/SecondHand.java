import java.time.LocalTime;

public class SecondHand extends ClockHand {
    private double angle;

    @Override
    public void setTime(LocalTime time) {
        this.angle = time.getSecond() * 6; // 360 stopni / 60 sekund
    }

    @Override
    public String toSvg() {
        return String.format(
            "<line x1=\"100\" y1=\"100\" x2=\"100\" y2=\"20\" stroke=\"red\" stroke-width=\"2\" transform=\"rotate(%f, 100, 100)\"/>",
            angle
        );
    }
}