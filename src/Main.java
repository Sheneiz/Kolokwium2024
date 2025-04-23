public class Main {
    public static void main(String[] args) {
        DigitalClock clock24 = new DigitalClock(DigitalClock.Mode.TWENTY_FOUR_HOUR);
        clock24.setTime(13, 45, 30);
        System.out.println("24-hour format: " + clock24);

        DigitalClock clock12 = new DigitalClock(DigitalClock.Mode.TWELVE_HOUR);
        clock12.setTime(13, 45, 30);
        System.out.println("12-hour format: " + clock12);
    }
}