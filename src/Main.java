import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args)
    {
        Map<String, City> miasta = City.parseFile("strefy.csv");
        System.out.println(miasta.get("Warszawa"));
        DigitalClock clock = new DigitalClock(miasta.get("Warszawa"),false);
        clock.setCurrentTime();
        System.out.println(clock.toString());
        clock.setCity(miasta.get("Kijów"));
        System.out.println(clock.toString());



        AnalogClock analogClock=new AnalogClock(miasta.get("Warszawa"));
        analogClock.setCurrentTime();
        analogClock.toSvg("z.svg");


        List<City> lista_miast=new ArrayList<>();
        lista_miast.add(miasta.get("Warszawa"));
        //System.out.println(miasta.get("Warszawa").localMeanTime(clock.time));
        for(City c : miasta.values())
        {
            lista_miast.add(c);
        }
        City.generateAnalogClosksSvg(lista_miast, analogClock);
    }
}