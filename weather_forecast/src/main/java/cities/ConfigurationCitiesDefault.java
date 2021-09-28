package cities;

import cities.GetCities;
import configurationConsumer.ConfigurationUrlConsumed;

public class ConfigurationCitiesDefault {
    public ConfigurationCitiesDefault() {
    }
    public GetCities createCityDefaul(){
        ConfigurationUrlConsumed configurationUrlConsumed=new ConfigurationUrlConsumed();
        configurationUrlConsumed.InitUrlListConsumed();
        GetCities getCities=new GetCities.GetCityBuilder()
                .state("SP")
                .urlConsumedList(configurationUrlConsumed.getUrlConsumedList())
                .createGetcity();
        return getCities;
    }
}
