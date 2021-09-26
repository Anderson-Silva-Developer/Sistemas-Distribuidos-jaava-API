package consumer;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Consumer {
    private HttpGet httpGet;
    private CloseableHttpClient httpClient;
    private String responseBody=null;

    public HttpGet getHttpGet() {
        return httpGet;
    }

    public void setHttpGet(HttpGet httpGet) {
        this.httpGet = httpGet;
    }

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    private Consumer(HttpGet httpGet, CloseableHttpClient httpClient, String responseBody) {
        this.httpGet = httpGet;
        this.httpClient = httpClient;
        this.responseBody = responseBody;
    }
    public static class ConsumerCityBuilder{
        private HttpGet httpGet;
        private CloseableHttpClient httpClient;
        private String responseBody=null;

        public ConsumerCityBuilder() { }
        public ConsumerCityBuilder httpGet(HttpGet httpGet){
            this.httpGet=httpGet;
            return this;
        }
        public ConsumerCityBuilder httpClient(CloseableHttpClient httpClient){
            this.httpClient=httpClient;
            return this;
        }
        public ConsumerCityBuilder responseBody(String responseBody){
            this.responseBody=responseBody;
            return this;
        }

        public Consumer createConsumer(){
            return new Consumer(httpGet,httpClient,responseBody);
        }

    }

}
