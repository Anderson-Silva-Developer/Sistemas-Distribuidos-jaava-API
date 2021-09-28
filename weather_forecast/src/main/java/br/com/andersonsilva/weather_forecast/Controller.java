package br.com.andersonsilva.weather_forecast;

import cities.ConfigurationCitiesDefault;
import cities.GetCities;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import componentsGUI.ComboBoxCities;
import componentsGUI.PaneWeather;
import configurationState.ActionStates;
import configurationState.SetStateName;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Accordion;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import searches.SearchesCities;
import searches.SearchesWeather;
import weather.ComponentsWeatherGUI;
import weather.ConfigurationWeatherDefault;
import weather.Weather;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    @FXML
    private  Label city,temp,date,time,description,currently;
    @FXML
    private ImageView img_id_;
    @FXML
    private Label p1_weekdayDate,p2_weekdayDate,p3_weekdayDate,p4_weekdayDate,p5_weekdayDate,p6_weekdayDate ;
    @FXML
    private Label  p1_max,p2_max,p3_max,p4_max,p5_max,p6_max,p1_min,p2_min,p3_min,p4_min,p5_min,p6_min;
    @FXML
    private Label p1_description,p2_description,p3_description,p4_description,p5_description,p6_description;
    @FXML
    private Accordion searchCityWeather;
    @FXML
    private Accordion accordionWeather;
    @FXML
    private Accordion AccordionMain;
    @FXML
    private AnchorPane anchorPaneMaps;
    @FXML
    private ComboBox<String> cities;
    @FXML
    private SVGPath imgteste;

    ComboBoxCities comboBoxCities=new ComboBoxCities();
    PaneWeather paneWeather=new PaneWeather();
    GetCities getCities=new ConfigurationCitiesDefault().createCityDefaul();
    SearchesCities searchesCites=new SearchesCities();
    SearchesWeather searchesWeather=new SearchesWeather();
    Weather weather=new ConfigurationWeatherDefault().createWeatherDefault();
    public static ComponentsWeatherGUI componentsWeatherGUI=new ComponentsWeatherGUI();
    public  static Map<String,Label>   resultWeather;
    public static ArrayList<Map<String,Label>> arrayWeather;

    public static ImageView img_id;
    @FXML
    void initialize() throws IOException{
         img_id=img_id_;
         resultWeather=componentsWeatherGUI.InitiResultWeather(city,temp,date,time,description,currently);
         componentsWeatherGUI.arrayWeatherSet(p1_weekdayDate,p1_max,p1_min,p1_description);
        componentsWeatherGUI.arrayWeatherSet(p2_weekdayDate,p2_max,p2_min,p2_description);
        componentsWeatherGUI.arrayWeatherSet(p3_weekdayDate,p3_max,p3_min,p3_description);
        componentsWeatherGUI.arrayWeatherSet(p4_weekdayDate,p4_max,p4_min,p4_description);
        componentsWeatherGUI.arrayWeatherSet(p5_weekdayDate,p5_max,p5_min,p5_description);
        componentsWeatherGUI.arrayWeatherSet(p6_weekdayDate,p6_max,p6_min,p6_description);

        arrayWeather= componentsWeatherGUI.getArrayWeather();

        imgteste.setFill(Color.BLUE);
        AccordionMain.getPanes().get(0).setGraphic(imgteste);

        getCities.setCurrentConsume();
        getCities.searchCities(getCities.getState());
        comboBoxCities.Fill(cities,
                new Gson().fromJson(getCities.getConsumer().getResponseBody(), JsonArray.class));
        weather.setCitiesList(getCities);
        weather.setCurrentConsume();


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

    @FXML
    void searchCities(MouseEvent event) throws IOException, URISyntaxException {
        if(event.getSource().getClass().getSimpleName().equals("SVGPath")){
            SVGPath  svgPath= (SVGPath) event.getSource();
            getCities.setState(svgPath.getId());
            cities.setDisable(true);
            boolean search=searchesCites.searchCities(comboBoxCities,getCities,cities);
            cities.setDisable(!search?true:false);
            searchCityWeather.getPanes().get(0).setText("Cities of the "+svgPath.getId());

        }
        if(event.getSource().getClass().getSimpleName().equals("Label")){
            Label label= (Label) event.getSource();
            getCities.setState(label.getText());
            cities.setDisable(true);
            boolean search=searchesCites.searchCities(comboBoxCities,getCities,cities);
            cities.setDisable(!search?true:false);
            searchCityWeather.getPanes().get(0).setText("Cities of the "+label.getText());

        }

    }
    @FXML
    public void searchWeather(){
        try {
            if(this.cities.getValue()!=null) {
                String city = URLEncoder.encode(this.cities.getValue(), "UTF-8");
                boolean search=searchesWeather.searchesWeather(paneWeather,weather,cities);
                if(search){
                    this.AccordionMain.getPanes().get(1).setExpanded(true);

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}