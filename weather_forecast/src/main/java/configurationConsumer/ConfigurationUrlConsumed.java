package configurationConsumer;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationUrlConsumed {
    private  Map<String,String>  urlConsumedList=new HashMap<>();

    public Map<String, String> getUrlConsumedList() {
        return urlConsumedList;
    }

    public void setUrlConsumedList(Map<String, String> urlConsumedList) {
        this.urlConsumedList = urlConsumedList;
    }

    public ConfigurationUrlConsumed() {
    }
    public  void InitUrlListConsumed(){
        urlConsumedList.put("CityPerState","https://servicodados.ibge.gov.br/api/v1/localidades/estados/");
        urlConsumedList.put("weatherPerCityState","http://localhost:8080/search/weather/");
    }
}
