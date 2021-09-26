package br.com.andersonsilva.weather_forecast;

import ConfigurationCitiesDefault.ConfigurationCitiesDefault;
import cities.GetCities;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import componentsGUI.ComboBoxCities;
import configurationState.ActionStates;
import configurationState.SetStateName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import javafx.scene.shape.SVGPath;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import  org.apache.http.util.EntityUtils;
import  org.apache.http.impl.client.HttpClients;
import com.google.gson.Gson;
import searches.SearchesCites;

public class Controller {
    @FXML
    private Accordion searchCityWeather;
    @FXML
    private Accordion accordionWeather;
    @FXML
    private AnchorPane anchorPaneMaps;
    @FXML
    private ComboBox<String> cities;

    ComboBoxCities comboBoxCities=new ComboBoxCities();
    GetCities getCities=new ConfigurationCitiesDefault().createCityDefaul();
    SearchesCites searchesCites=new SearchesCites();

    @FXML
    void initialize() throws IOException {
        getCities.setCurrentConsume();
        getCities.searchCities();
        comboBoxCities.Fill(cities,
                new Gson().fromJson(getCities.getConsumer().getResponseBody(), JsonArray.class));

        SetStateName setStateName=new SetStateName.SetStateNameBuilder()
                .listName(new HashMap<>())
                .createSetStateName();

        ActionStates actionStates=new ActionStates.ActionStatesBuilder()
                .anchorPaneMaps(anchorPaneMaps)
                .listStateName(setStateName.getNameStates())
                .createActionStates();

        actionStates.SetActionStates();

    }

    private void list() {
        try{

            accordionWeather.getPanes().stream().forEach(titledPane -> {
                titledPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        titledPane.setCollapsible(true);
                        titledPane.setCursor(Cursor.WAIT);
                        titledPane.setExpanded(true);
                    }
                });
            });

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void search(ActionEvent actionEvent) throws IOException {
        CloseableHttpClient  closeableHttpClient = HttpClients.createDefault();

        String responseBody=null;
        try {
//            HttpGet httpGet = new HttpGet("http://localhost:8080/search/weather/Caxias/MA");
            HttpGet httpGet = new HttpGet("https://servicodados.ibge.gov.br/api/v1/localidades/estados/MA/municipios");

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
            responseBody = closeableHttpClient.execute(httpGet, responseHandler);
            Gson gson=new Gson();
            JsonArray jsonArray = new Gson().fromJson(responseBody, JsonArray.class);
            AtomicInteger count= new AtomicInteger();

            jsonArray.forEach(city-> {
                JsonObject jsonObject=new Gson().fromJson(city, JsonObject.class);
                System.out.println(jsonObject.get("nome"));
                this.cities.getItems().add(jsonObject.get("nome").toString().replace("\"", ""));


                count.getAndIncrement();
            });
            System.out.println("-------------------- "+count);


        }catch (Exception e){
            System.out.println("Erro "+e.getMessage());
        }


    }
    @FXML
    void searchCities(MouseEvent event) throws IOException {
        if(event.getSource().getClass().getSimpleName().equals("SVGPath")){
            SVGPath  svgPath= (SVGPath) event.getSource();
            System.out.println(svgPath.getId());
            getCities.setState(svgPath.getId());
            cities.setDisable(true);
            boolean search=searchesCites.searchCities(comboBoxCities,getCities,cities);
            cities.setDisable(!search?true:false);
            searchCityWeather.getPanes().get(0).setText("Cities of the "+svgPath.getId());

        }
        if(event.getSource().getClass().getSimpleName().equals("Label")){
            Label label= (Label) event.getSource();
            System.out.println(label.getText());
            getCities.setState(label.getText());
            cities.setDisable(true);
            boolean search=searchesCites.searchCities(comboBoxCities,getCities,cities);
            cities.setDisable(!search?true:false);
            searchCityWeather.getPanes().get(0).setText("Cities of the "+label.getText());

        }

    }

}