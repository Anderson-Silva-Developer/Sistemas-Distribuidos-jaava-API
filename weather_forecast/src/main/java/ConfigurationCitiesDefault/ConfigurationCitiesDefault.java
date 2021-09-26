package ConfigurationCitiesDefault;

import cities.GetCities;

public class ConfigurationCitiesDefault {
    public ConfigurationCitiesDefault() {
    }
    public GetCities createCityDefaul(){
        GetCities getCities=new GetCities.GetCityBuilder().state("SP").createGetcity();
        return getCities;
    }
}
