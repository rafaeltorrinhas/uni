import java.util.*;

public class WeatherStation {
    public double temp;
    public List<Observer> observers = new ArrayList<>();

    public void attach(Observer o) {
        observers.add(o);
    }

    public void setState() {
        for (Observer o : observers) {
            o.update(this.temp);
        }
    }

    public double getState() {
        return temp;
    }

    public void changeTemp(double temp) { // não é preciso (só iniciar outro weather station para mudar a tempratura)
        this.temp = temp;
    }

    public WeatherStation(double temp) {
        this.temp = temp;
    }
}