package cities;

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
import java.util.concurrent.atomic.AtomicInteger;


public class GetCities {
    private static Map<String,String> name=new HashMap<>();
    private  String state;
    private Consumer consumer;
    private  Map<String,String>  urlConsumedList=new HashMap<>();

    public Map<String, String> getUrlConsumedList() {
        return urlConsumedList;
    }

    public void setUrlConsumedList(Map<String, String> urlConsumedList) {
        this.urlConsumedList = urlConsumedList;
    }

    public Map<String, String> getName() {
        return name;
    }

    public void setName(Map<String, String> name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    private GetCities(Map<String,String> name, String state, Consumer consumer,Map<String,String>  urlConsumedList) {
        this.name=name;
        this.state = state;
        this.consumer = consumer;
        this.urlConsumedList=urlConsumedList;
    }
    public static class GetCityBuilder{
        private Map<String,String> name=new HashMap<>();
        private  String state;
        private Consumer consumer;
        private  Map<String,String>  urlConsumedList=new HashMap<>();

        public GetCityBuilder() {}

        public  GetCityBuilder state(String state){
            this.state=state;
            return this;
        }
        public  GetCityBuilder urlConsumedList(Map<String,String>  urlConsumedList){
            this.urlConsumedList=urlConsumedList;
            return this;
        }
        public GetCities createGetcity(){
            return new GetCities(name,state,consumer,urlConsumedList);
        }

    }
    public void  setCurrentConsume(){
        this.consumer=new CurrentConsumer().createConsumer();
        this.getConsumer()
                .getHttpGet()
                .setURI(URI.create(this.urlConsumedList.get("CityPerState")));
    }

    public void searchCities(String state) throws IOException {
        String url=this.urlConsumedList.get("CityPerState")+state+"/municipios";
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
