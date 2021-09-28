package componentsGUI;

import br.com.andersonsilva.weather_forecast.Controller;
import br.com.andersonsilva.weather_forecast.Main;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javafx.scene.image.Image;

import java.net.URISyntaxException;
import java.util.concurrent.atomic.AtomicInteger;

public class PaneWeather {
    Gson gson=new Gson();
    public PaneWeather() {
    }
    public void paneWeatherFill(JsonObject jsonObject ) throws URISyntaxException {

        String  json=gson.toJson(jsonObject);
        JsonObject resultsJson = new Gson().fromJson(json, JsonObject.class);
        String  json1=gson.toJson(resultsJson.get("results"));
        JsonObject resultsjson1 = new Gson().fromJson(json1, JsonObject.class);
        //preencher weather main
        Controller.resultWeather.forEach((s, label) -> {
           label.setText(resultsjson1.get(s).toString().replace("\"", ""));
        });

       try {
           String nameImg_id=clear(resultsjson1.get("img_id").toString())+".png";
           Image img=new Image(Main.class.getResource("/imgWeather/"+nameImg_id).toURI().toURL().toString());
           Controller.img_id.setImage(img);
       }catch (Exception e){
           System.out.println("Erro "+e.getMessage());

       }
       try{

           String  jsonforescast=gson.toJson(resultsjson1.get("forecast"));
           JsonArray forecastJson = new Gson().fromJson(jsonforescast, JsonArray.class);

           AtomicInteger count= new AtomicInteger();
           Controller.arrayWeather.forEach(map -> {
               String strforecast=gson.toJson(forecastJson.get(count.get()));
               JsonObject forecastResult = new Gson().fromJson(strforecast, JsonObject.class);
               map.get("weekdayDate").setText(clear(forecastResult.get("weekday").toString())+" - "+clear(forecastResult.get("date").toString()));
               map.get("max").setText(forecastResult.get("max").toString());
               map.get("min").setText(forecastResult.get("min").toString());
               map.get("description").setText(clear(forecastResult.get("description").toString()));


               count.getAndIncrement();

           });


       }catch (Exception e){
           System.out.println("Erro "+e.getMessage());
       }


    }
    public String clear(String str){

        return str.toString().replace("\"", "");

    }

}
