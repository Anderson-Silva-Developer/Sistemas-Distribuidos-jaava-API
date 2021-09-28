package searches;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import componentsGUI.PaneWeather;
import javafx.scene.control.ComboBox;
import weather.Weather;

import java.net.URLEncoder;

public class SearchesWeather {

    public SearchesWeather() {
    }
    public boolean searchesWeather(PaneWeather paneWeather,Weather weather, ComboBox<String> cities) {

        try {
            weather.searchWeather(URLEncoder.encode(cities.getValue(), "UTF-8"));
            System.out.println(weather.getConsumer().getResponseBody());
            paneWeather.paneWeatherFill(
                    new Gson().fromJson(weather.getConsumer().getResponseBody(), JsonObject.class));

            return true;

        }catch (Exception e){
            System.out.println("Error Search weather");
        }

        return false;
    }
}
