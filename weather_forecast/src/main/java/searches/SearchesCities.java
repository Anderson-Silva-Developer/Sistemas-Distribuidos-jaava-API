package searches;

import cities.GetCities;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import componentsGUI.ComboBoxCities;
import javafx.scene.control.ComboBox;

import java.io.IOException;

public class SearchesCities {
    public SearchesCities() {
    }
    public boolean searchCities(ComboBoxCities comboBoxCities, GetCities getCities, ComboBox<String> cities) throws IOException {
        try {
            getCities.searchCities(getCities.getState());
            comboBoxCities.Fill(cities,
                    new Gson().fromJson(getCities.getConsumer().getResponseBody(), JsonArray.class));

            return true;
        }catch (Exception e){
            System.out.println("Error Search Cities");

        }
        return false;
    }
}
