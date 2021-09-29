package configurationState;

import br.com.andersonsilva.weather_forecast.Main;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;

import java.net.URL;
import java.util.Map;
import java.util.stream.Stream;

public class ActionStates {
    private AnchorPane anchorPaneMaps;
    private Map<String,String> listStateName;

    public AnchorPane getAnchorPaneMaps() {
        return anchorPaneMaps;
    }

    public void setAnchorPaneMaps(AnchorPane anchorPaneMaps) {
        this.anchorPaneMaps = anchorPaneMaps;
    }

    public Map<String,String>  getListStateName() {
        return listStateName;
    }

    public void setListStateName(Map<String,String> listStateName) {
        this.listStateName = listStateName;
    }

    private ActionStates(AnchorPane anchorPaneMaps,Map<String,String>  listStateName) {
        this.anchorPaneMaps = anchorPaneMaps;
        this.listStateName = listStateName;
    }
    public static class ActionStatesBuilder{

        private AnchorPane anchorPaneMaps;
        private Map<String,String>  listStateName;

        public ActionStatesBuilder() {}
        public ActionStatesBuilder anchorPaneMaps(AnchorPane anchorPaneMaps){
            this.anchorPaneMaps=anchorPaneMaps;
            return this;
        }
        public ActionStatesBuilder listStateName(Map<String,String> listStateName){
            this.listStateName=listStateName;
            return this;
        }
        public ActionStates createActionStates(){
            return new ActionStates(anchorPaneMaps,listStateName);
        }
    }


    public void SetActionStates(){

        Stream<Node> listState = anchorPaneMaps.getChildren().stream().filter(node -> node.getClass().getSimpleName().equals("SVGPath"));
        Stream<Node> listFlagName = anchorPaneMaps.getChildren().stream().filter(node -> node.getClass().getSimpleName().equals("Label"));


        listFlagName.forEach(node -> {

            String strName = node.getId();
            String name=strName.split("name")[1];
            String url = "/img/flags/" + name.toLowerCase() + ".png";
            try {

                Image flag = new Image(Main.class.getResourceAsStream(url), 40, 25, false, false);
                ((Label) node).getTooltip().setGraphic(new ImageView(flag));
                ((Label) node).getTooltip().setText(  listStateName.get(strName.split("name")[1]));
                ((Label) node).getTooltip().setStyle("-fx-font: normal bold 14 Langdon; "
                        + "-fx-base: #AE3522; "
                        + "-fx-text-fill:green;"


                );


            } catch (Exception e) {
                System.out.println(e.getMessage());

            }

        });



    }
}
