package cities;

import configurationConsumer.ConfigurationUrlConsumed;
import consumer.Consumer;
import consumer.CurrentConsumer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;

public class GetCities {
    private  String name;
    private  String state;
    private Consumer consumer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    private GetCities(String name, String state, Consumer consumer) {
        this.name=name;
        this.state = state;
        this.consumer = consumer;
    }
    public static class GetCityBuilder{
        private  String name;
        private  String state;
        private Consumer consumer;

        public GetCityBuilder() {}

        public  GetCityBuilder state(String state){
            this.state=state;
            return this;
        }
        public GetCities createGetcity(){
            return new GetCities(name,state,consumer);
        }

    }
    public void  setCurrentConsume(){
        ConfigurationUrlConsumed getUrlconsumed = new ConfigurationUrlConsumed();
        this.consumer=new CurrentConsumer().createConsumer();
        getUrlconsumed.InitUrlListConsumed();
        this.getConsumer()
                .getHttpGet()
                .setURI(URI.create(getUrlconsumed
                .getUrlConsumedList().get("CityPerState")+this.state+"/municipios"));
    }

    public void searchCities() throws IOException {

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
