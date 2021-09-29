package componentsGUI;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ScreenAction {

    public ScreenAction() {
    }

    public void actionScreen(Accordion AccordionMain,TitledPane aba01, TitledPane aba02){


        AccordionMain.setPrefWidth(80);
        AccordionMain.setPrefHeight(100);
        aba01.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage stage= (Stage) AccordionMain.getScene().getWindow();

                if(!aba01.isExpanded()&&!aba02.isExpanded()) {

                    stage.getScene().getWindow().setWidth(80);
                    stage.getScene().getWindow().setHeight(100);

                }else{

                    stage.getScene().getWindow().setWidth(950);
                    stage.getScene().getWindow().setHeight(625);
                    stage.getScene().getWindow().centerOnScreen();

                }


            }
        });
        aba02.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage stage= (Stage) AccordionMain.getScene().getWindow();


                if(!aba01.isExpanded()&&!aba02.isExpanded()) {

                    stage.getScene().getWindow().setWidth(80);
                    stage.getScene().getWindow().setHeight(100);

                }else{

                    stage.getScene().getWindow().setWidth(950);
                    stage.getScene().getWindow().setHeight(625);
                    stage.getScene().getWindow().centerOnScreen();


                }

            }
        });

    }
}
