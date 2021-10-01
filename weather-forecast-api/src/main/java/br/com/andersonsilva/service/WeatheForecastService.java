package br.com.andersonsilva.service;
import br.com.andersonsilva.model.WeatheForecast;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import teste.Teste;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class WeatheForecastService {
    @Autowired
    WebClient webClient;
    Gson gson=new Gson();
    public WeatheForecast getWeatherForecast(String country,String state) throws IOException {
//     //key EM https://hgbrasil.com/
        String url="weather?key="+System.getenv("KEY_WEATHER")+"&city_name="+country+","+state;

        System.out.println(url);

        Mono<WeatheForecast> fluxWeathForecast = webClient.method(HttpMethod.GET)
                .uri(url)
                .retrieve()
                .bodyToMono(WeatheForecast.class);
        System.out.println(fluxWeathForecast.block());
        String json = gson.toJson(fluxWeathForecast.block().getResults());
        JsonObject convertedObject = new Gson().fromJson(json, JsonObject.class);
        System.out.println(fluxWeathForecast.block());//
        return fluxWeathForecast.block();
//        Teste teste=new Teste();
//        try {
//            return  teste.Teste_();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        return null;
    }
}
