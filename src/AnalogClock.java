import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalogClock extends Clock
{
    private final List<ClockHand> wskazowki=new ArrayList<>();
    public AnalogClock(City c)
    {
        super(c);
        wskazowki.add(new SecondHand());
        wskazowki.add(new MinuteHand());
        wskazowki.add(new HourHand());
    }




    public void toSvg(String path)
    {
        try{
            FileWriter fw=new FileWriter(path);
            StringBuilder sb=new StringBuilder();
            sb.append("<svg width=\"200\" height=\"200\" viewBox=\"-100 -100 200 200\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                    "  <!-- Tarcza zegara -->\n" +
                    "  <circle cx=\"0\" cy=\"0\" r=\"90\" fill=\"none\" stroke=\"black\" stroke-width=\"2\" />\n" +
                    "  <g text-anchor=\"middle\">\n" +
                    "    <text x=\"0\" y=\"-80\" dy=\"6\">12</text>\n" +
                    "    <text x=\"80\" y=\"0\" dy=\"4\">3</text>\n" +
                    "    <text x=\"0\" y=\"80\" dy=\"6\">6</text>\n" +
                    "    <text x=\"-80\" y=\"0\" dy=\"4\">9</text>\n" +
                    "  </g>\n");

            for(ClockHand w : wskazowki)
            {
                w.setTime(time);
                sb.append(w.toSvg(""));
            }
            sb.append("</svg>");
            fw.write(sb.toString());
            fw.close();

        }catch (IOException e)
        {
            System.err.println("can't write to file: "+path);
        }
    }
}
