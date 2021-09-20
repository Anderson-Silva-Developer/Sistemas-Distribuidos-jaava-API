package br.com.andersonsilva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class WeatheForecastApplication {
	@Bean
	public WebClient webClientWeatheForecast(WebClient.Builder builder) {
		return builder
				.baseUrl("http://apiadvisor.climatempo.com.br/api/v1/locale/city?name=São Paulo&state=SP&token=8071302ef1d9956a32287f0bdefc9a3e")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatheForecastApplication.class, args);
	}

}
