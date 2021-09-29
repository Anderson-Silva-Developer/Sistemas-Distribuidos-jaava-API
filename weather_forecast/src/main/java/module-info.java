module br.com.andersonsilva.weather_forecast {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.httpcomponents.httpcore;
    requires org.apache.httpcomponents.httpclient;
    requires com.google.gson;
    requires java.desktop;


    opens br.com.andersonsilva.weather_forecast to javafx.fxml;
    exports br.com.andersonsilva.weather_forecast;
}