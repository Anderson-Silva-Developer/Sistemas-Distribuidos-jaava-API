package searches;

import cities.GetCities;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import componentsGUI.ComboBoxCities;
import javafx.scene.control.ComboBox;

import java.io.IOException;

public class SearchesCites {
    public SearchesCites() {
    }
    public boolean searchCities(ComboBoxCities comboBoxCities, GetCities getCities, ComboBox<String> cities) throws IOException {
        try {
            getCities.setCurrentConsume();
            getCities.searchCities();
            comboBoxCities.Fill(cities,
                    new Gson().fromJson(getCities.getConsumer().getResponseBody(), JsonArray.class));

            return true;
        }catch (Exception e){
            System.out.println("Error Search");

        }
        return false;
    }
}
