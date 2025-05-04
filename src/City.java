import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City
{
    String name;
    double timezone;
    double latitude;
    String NS;
    double longitude;
    String WE;

    public City(String name, double timezone, double latitude, String NS, double longitude, String WE) {
        this.name = name;
        this.timezone = timezone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.NS=NS;
        this.WE=WE;
    }

    private static City parseLine(String line)
    {
        String[] parts=line.split(",", -1);
        String name=parts[0];
        double timezone=Double.parseDouble(parts[1].trim());
        String[] NS_=parts[2].split(" ");
        String[] WE_=parts[3].trim().split(" ");
        double latitude=Double.parseDouble(NS_[0]);
        double longitude=Double.parseDouble(WE_[0]);
        String NS=NS_[1];
        String WE=WE_[1];
        return new City(name, timezone, latitude, NS, longitude, WE);
    }

    public static Map<String, City> parseFile(String path)
    {
        Map<String, City>miasta= new HashMap<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            bf.readLine();
            String line;
            while((line=bf.readLine())!=null)
            {
                City c = City.parseLine(line);
                miasta.put(c.name, c);
            }
            return miasta;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", timezone=" + timezone +
                ", latitude=" + latitude +
                " " + NS + '\'' +
                ", longitude=" + longitude +
                " " + WE + '\'' +
                '}';
    }

    public LocalTime localMeanTime(LocalTime time)
    {
        int hour= (int) (longitude/15);
        int minute= (int) (longitude/(15*60));
        int second= (int) (longitude/(15*3600));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime tt=LocalTime.from(formatter.parse(String.format("%s:%s:%s",hour,minute,second)));
        return tt;
    }

    public static void generateAnalogClosksSvg(List<City> cities, AnalogClock analogClock)
    {
        for(City city : cities)
        {
            analogClock.setCity(city);
            analogClock.toSvg(String.format("Katalog/%s.svg", city.name));
        }

    }
}
