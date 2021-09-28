package weather;

import configurationConsumer.ConfigurationUrlConsumed;

public class ConfigurationWeatherDefault {
    public ConfigurationWeatherDefault() {
    }

    public Weather createWeatherDefault(){
        ConfigurationUrlConsumed configurationUrlConsumed=new ConfigurationUrlConsumed();
        configurationUrlConsumed.InitUrlListConsumed();
        Weather weather=new Weather.WeatherBuilder()
                .urlConsumedList(configurationUrlConsumed.getUrlConsumedList())
                .createWeather();
        return weather;
    }
}
