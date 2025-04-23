import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

public class AnalogClock extends Clock {
    private final List<ClockHand> hands = List.of(new HourHand(), new MinuteHand(), new SecondHand());

    @Override
    public void setTime(int hour, int minute, int second) {
        super.setTime(hour, minute, second);
        LocalTime time = LocalTime.of(hour, minute, second);
        hands.forEach(hand -> hand.setTime(time));
    }

    public void toSvg(String filePath) throws IOException {
        StringBuilder svgContent = new StringBuilder("""
            <svg xmlns="http://www.w3.org/2000/svg" width="200" height="200">
                <circle cx="100" cy="100" r="90" stroke="black" stroke-width="2" fill="none"/>
        """);
        hands.forEach(hand -> svgContent.append(hand.toSvg()));
        svgContent.append("</svg>");
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(svgContent.toString());
        }
    }
}