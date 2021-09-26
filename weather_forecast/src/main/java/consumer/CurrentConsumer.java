package consumer;

import consumer.Consumer;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class CurrentConsumer {
    public CurrentConsumer() {
    }
    public Consumer createConsumer(){
        Consumer consumer =new Consumer.ConsumerCityBuilder()
                .httpGet(new HttpGet())
                .httpClient(HttpClients.createDefault())
                .responseBody(null)
                .createConsumer();
        return consumer;
    }

}
