package componentsGUI;


import br.com.andersonsilva.weather_forecast.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Accordion;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class Screen {
    public Screen() {
    }
    public void ActionMenuItem(Accordion AccordionMain, MenuItem exit, MenuItem minimize){
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(actionEvent.getEventType());
                System.exit(1);
            }
        });
        minimize.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(actionEvent.getEventType());
                Stage stage= (Stage) AccordionMain.getScene().getWindow();
                stage.setIconified(true);
            }
        });


    }
}
