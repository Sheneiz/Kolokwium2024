public class DigitalClock extends Clock {
    public enum Mode {
        TWENTY_FOUR_HOUR, TWELVE_HOUR
    }

    private final Mode mode;

    public DigitalClock(Mode mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        if (mode == Mode.TWENTY_FOUR_HOUR) {
            return super.toString();
        } else {
            int hour = getHour();
            String period = hour < 12 ? "AM" : "PM";
            hour = hour % 12;
            if (hour == 0) hour = 12;
            return String.format("%d:%02d:%02d %s", hour, getMinute(), getSecond(), period);
        }
    }
}