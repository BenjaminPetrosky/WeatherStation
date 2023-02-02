public class ForecastDisplay implements Observer, DisplayElement{

    private float oldPressure;
    private float newPressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        if(oldPressure < newPressure){
            System.out.println("Forecast:  Improving weather on the way!");

        }else if(oldPressure > newPressure){
            System.out.println("Forecast:  WATCH OUT FOR COOLER RAINYWEATHER;");
        }else{
            System.out.println("Forecast:  More of the same");
        }

    }

    @Override
    public void update() {

        this.oldPressure = this.newPressure;
        this.newPressure = weatherData.getPressure();
        display();
    }
}
