package teste;

import br.com.andersonsilva.Main;
import br.com.andersonsilva.model.WeatheForecast;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Teste {


    public Teste() {
    }

    public WeatheForecast Teste_() throws IOException, URISyntaxException {
//        String path = Main.class.getResource("/Jsonteste.json").toURI().getPath();
//        String json
//                = String.join(" ",
//                Files.readAllLines(
//                        Paths.get(path),
//                        StandardCharsets.UTF_8)
//        );
       String  json2="{ \"results\": { \"temp\": 32, \"date\": \"23/09/2021\", \"time\": \"10:05\", \"condition_code\": \"28\", \"description\": \"Tempo nublado\", \"currently\": \"dia\", \"cid\": \"\", \"city\": \"Caxias, MA\", \"img_id\": \"28\", \"humidity\": 36, \"wind_speedy\": \"2.47 km/h\", \"sunrise\": \"05:42 am\", \"sunset\": \"05:49 pm\", \"condition_slug\": \"cloudly_day\", \"city_name\": \"Caxias\", \"forecast\": [ { \"date\": \"23/09\", \"weekday\": \"Qui\", \"max\": 40, \"min\": 21, \"description\": \"Tempo nublado\", \"condition\": \"cloudly_day\" }, { \"date\": \"24/09\", \"weekday\": \"Sex\", \"max\": 39, \"min\": 23, \"description\": \"Parcialmente nublado\", \"condition\": \"cloud\" }, { \"date\": \"25/09\", \"weekday\": \"Sáb\", \"max\": 40, \"min\": 22, \"description\": \"Parcialmente nublado\", \"condition\": \"cloudly_day\" }, { \"date\": \"26/09\", \"weekday\": \"Dom\", \"max\": 40, \"min\": 21, \"description\": \"Tempo limpo\", \"condition\": \"clear_day\" }, { \"date\": \"27/09\", \"weekday\": \"Seg\", \"max\": 40, \"min\": 21, \"description\": \"Tempo limpo\", \"condition\": \"clear_day\" }, { \"date\": \"28/09\", \"weekday\": \"Ter\", \"max\": 38, \"min\": 23, \"description\": \"Parcialmente nublado\", \"condition\": \"cloudly_day\" }, { \"date\": \"29/09\", \"weekday\": \"Qua\", \"max\": 41, \"min\": 21, \"description\": \"Tempo limpo\", \"condition\": \"clear_day\" }, { \"date\": \"30/09\", \"weekday\": \"Qui\", \"max\": 39, \"min\": 23, \"description\": \"Chuvas esparsas\", \"condition\": \"rain\" }, { \"date\": \"01/10\", \"weekday\": \"Sex\", \"max\": 37, \"min\": 23, \"description\": \"Chuvas esparsas\", \"condition\": \"rain\" }, { \"date\": \"02/10\", \"weekday\": \"Sáb\", \"max\": 40, \"min\": 21, \"description\": \"Chuvas esparsas\", \"condition\": \"rain\" } ] } }";
//        System.out.println(json);
        WeatheForecast weatheForecast= new Gson().fromJson(json2, WeatheForecast.class);
//        Gson gson=new Gson();
//        String json1 = gson.toJson(weatheForecast.getResults());
//        JsonObject convertedObject = new Gson().fromJson(json1, JsonObject.class);
//        System.out.println(convertedObject.get("temp"));

        return weatheForecast;


    }

}
