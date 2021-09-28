package weather;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComponentsWeatherGUI {

    public static Map<String,Label> resultWeather=new HashMap<>();
    public static ArrayList<Map<String,Label>>  arrayWeather=new ArrayList<>();

    public ComponentsWeatherGUI() {

    }

    public Map<String, Label>  InitiResultWeather(Label city,Label temp,Label date,Label time, Label description, Label currently){
        resultWeather.put("city",city);
        resultWeather.put("temp",temp);
        resultWeather.put("date",date);
        resultWeather.put("time",time);
        resultWeather.put("description",description);
        resultWeather.put("currently",currently);
        return resultWeather;
    }

    public  void arrayWeatherSet(Label weekdayDate,Label max,Label min,Label description){
        description.setMaxWidth(200);
        Map<String,Label>  map=new HashMap<>();
        map.put("weekdayDate",weekdayDate);
        map.put("max",max);
        map.put("min",min);
        map.put("description",description);
        arrayWeather.add(map);

    }
    public ArrayList<Map<String,Label>> getArrayWeather(){
        return arrayWeather;
    }

}
