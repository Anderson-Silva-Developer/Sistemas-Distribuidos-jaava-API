package componentsGUI;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javafx.scene.control.ComboBox;

import java.util.concurrent.atomic.AtomicInteger;

public class ComboBoxCities {
    public ComboBoxCities() {
    }
    public ComboBox Fill(ComboBox comboBox, JsonArray jsonArray ){
        AtomicInteger count= new AtomicInteger();

        jsonArray.forEach(city-> {
            JsonObject jsonObject=new Gson().fromJson(city, JsonObject.class);
            System.out.println(jsonObject.get("nome"));
            comboBox.getItems().add(jsonObject.get("nome").toString().replace("\"", ""));
            count.getAndIncrement();
        });
        return comboBox;
    }
}
