package weather;

import cities.GetCities;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import consumer.Consumer;
import consumer.CurrentConsumer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class Weather {
    private GetCities citiesList;
    private Consumer consumer;
    private Map<String,String> urlConsumedList=new HashMap<>();


    public GetCities getCitiesList() {
        return citiesList;
    }

    public void setCitiesList(GetCities citiesList) {
        this.citiesList = citiesList;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    private Weather(GetCities citiesList,Consumer consumer,Map<String,String> urlConsumedList) {
        this.citiesList = citiesList;
        this.consumer=consumer;
        this.urlConsumedList=urlConsumedList;
    }

    public static class WeatherBuilder {
        private GetCities citiesList;
        private Consumer consumer;
        private Map<String,String> urlConsumedList=new HashMap<>();

        public WeatherBuilder() {
        }
        public WeatherBuilder citiesList(GetCities citiesList){
            this.citiesList=citiesList;
            return this;
        }
        public WeatherBuilder consumer(Consumer consumer){
            this.consumer=consumer;
            return this;
        }
        public WeatherBuilder urlConsumedList(Map<String,String> urlConsumedList){
            this.urlConsumedList=urlConsumedList;
            return this;
        }
        public Weather createWeather(){
            return new Weather(citiesList,consumer,urlConsumedList);
        }
    }

    public void  setCurrentConsume(){
        this.consumer=new CurrentConsumer().createConsumer();
        this.getConsumer()
                .getHttpGet()
                .setURI(URI.create(this.urlConsumedList.get("weatherPerCityState")));

    }
    public void searchWeather(String city) throws IOException {
        String url=this.urlConsumedList.get("weatherPerCityState")+city+"/"+this.getCitiesList().getState();
        this.getConsumer()
                .getHttpGet()
                .setURI(URI.create(url));

        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(final HttpResponse httpResponse) throws ClientProtocolException, IOException {
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = httpResponse.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status:" + status);
                }

            }
        };

        this.getConsumer().setResponseBody(this.getConsumer().getHttpClient()
                .execute(this.getConsumer().getHttpGet(), responseHandler));


    }

}