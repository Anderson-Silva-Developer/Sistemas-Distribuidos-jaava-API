package br.com.andersonsilva.service;
import br.com.andersonsilva.model.WeatheForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
@Service
public class WeatheForecastService {
    @Autowired
    WebClient webClient;

    public WeatheForecast getWeatheForecast(){

            Mono<WeatheForecast> monoWeathForecast = webClient.method(HttpMethod.GET)
                    .uri("")
                    .retrieve()
                    .bodyToMono(WeatheForecast.class);
            monoWeathForecast.subscribe(weatheForecast -> {
                System.out.println("request sucefull");
            });

        return monoWeathForecast.block();
    }
}
