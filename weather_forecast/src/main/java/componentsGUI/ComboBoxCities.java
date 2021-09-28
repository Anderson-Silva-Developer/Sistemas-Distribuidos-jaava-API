package componentsGUI;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ComboBox;

import java.text.Collator;

public class ComboBoxCities {
    public ComboBoxCities() {
    }
    public ComboBox Fill(ComboBox comboBox, JsonArray jsonArray ){
        final ObservableList<String> comboBoxItems = FXCollections.observableArrayList();
        jsonArray.forEach(city-> {
            JsonObject jsonObject=new Gson().fromJson(city, JsonObject.class);
            String str=jsonObject.get("nome").toString().replace("\"", "");
            comboBoxItems.add(str);
        });
        comboBox.setItems(new SortedList<String>(comboBoxItems, Collator.getInstance()));

        return comboBox;
    }
}
