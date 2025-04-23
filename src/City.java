import java.time.LocalTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class City {
    private String name;
    private double longitude; // Długość geograficzna
    private int timezoneOffset; // Przesunięcie strefy czasowej w godzinach

    public City(String name, double longitude, int timezoneOffset) {
        this.name = name;
        this.longitude = longitude;
        this.timezoneOffset = timezoneOffset;
    }

    public LocalTime localMeanTime(LocalTime standardTime) {
        double offset = (longitude / 180.0) * 12.0; // Przeliczenie długości geograficznej na przesunięcie godzinowe
        int secondsOffset = (int) (offset * 3600); // Przesunięcie w sekundach
        return standardTime.plusSeconds(secondsOffset);
    }

    public String getName() {
        return name;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getTimezoneOffset() {
        return timezoneOffset;
    }

    public static Comparator<City> worstTimezoneFit(LocalTime standardTime) {
            return (city1, city2) -> {
                long diff1 = Math.abs(city1.localMeanTime(standardTime).toSecondOfDay() -
                                      standardTime.plusHours(city1.getTimezoneOffset()).toSecondOfDay());
                long diff2 = Math.abs(city2.localMeanTime(standardTime).toSecondOfDay() -
                                      standardTime.plusHours(city2.getTimezoneOffset()).toSecondOfDay());
                return Long.compare(diff2, diff1); // Sortowanie malejące
            };
        }
        public static void generateAnalogClocksSvg(List<City> cities, AnalogClock clock) throws IOException {
                File directory = new File(clock.toString());
                if (!directory.exists()) {
                    directory.mkdir();
                }
                for (City city : cities) {
                    clock.setTime(12, 0, 0); // Przykładowy czas
                    clock.toSvg(directory.getPath() + "/" + city.getName() + ".svg");
                }
            }
    }