import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticsDisplay implements Observer, DisplayElement{
    private List<Float> allTemps;

    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData){
        this.allTemps = new ArrayList<Float>();
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        float sum = 0.0F;
        for(int i = 0; i < allTemps.size(); i++){
            sum += allTemps.get(i);
        }
        float average = sum / allTemps.size();
        System.out.println("Avg/Max/Min temperature = " + average + "/" + Collections.max(allTemps) + "/" + Collections.min(allTemps));
    }

    @Override
    public void update() {
        allTemps.add(weatherData.getTemperature());
        display();
    }
}
