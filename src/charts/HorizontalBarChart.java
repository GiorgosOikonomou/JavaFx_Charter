package charts;

/**
 * Created by oikonomou on 3/17/2015.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import jobCharts.SceneToPng;

public class HorizontalBarChart extends Application {

    private void init(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        primaryStage.setScene(new Scene(root));

        //primaryStage.getScene().getStylesheets().add("jobCharts/styleshhet.css");
        BarChart<Number, String> bc_=createChart();
        AnchorPane.setTopAnchor(bc_, 20.0);
        AnchorPane.setBottomAnchor(bc_, 20.0);
        AnchorPane.setLeftAnchor(bc_, 20.0);
        AnchorPane.setRightAnchor(bc_, 20.0);
        root.getChildren().add(bc_);
        setUserAgentStylesheet(STYLESHEET_CASPIAN);

        final ContextMenu contextMenu = new ContextMenu();
        MenuItem saveImage = new MenuItem("Export image");
        contextMenu.getItems().addAll(saveImage);
        saveImage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                SceneToPng.exportSceneToPng(primaryStage);
            }
        });


        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isSecondaryButtonDown()) {
                    contextMenu.show(root, event.getScreenX(), event.getScreenY());
                }
            }
        });
    }

    protected BarChart<Number, String> createChart() {

        final CategoryAxis yAxis = new CategoryAxis();
        final NumberAxis xAxis = new NumberAxis();
        final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis, yAxis);

        bc.setHorizontalGridLinesVisible(false);

        // setup chart
        bc.setTitle("Horizontal Bar Chart Example");
        yAxis.setLabel("Country");






//        yAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(years)));
        xAxis.setLabel("Difference");
        // add starting data
        XYChart.Series<Number, String> series1 = new XYChart.Series<Number, String>();


        series1.setName("Data Series 1");
        series1.getData().add(new XYChart.Data<Number, String>(18.8 ,"DK" ));
        series1.getData().add(new XYChart.Data<Number, String>(19.1 ,"UK" ));
        series1.getData().add(new XYChart.Data<Number, String>(19.9 ,"SE" ));
        series1.getData().add(new XYChart.Data<Number, String>(20.0 ,"FR" ));
        series1.getData().add(new XYChart.Data<Number, String>(23.4 ,"HU" ));
        series1.getData().add(new XYChart.Data<Number, String>(23.6 ,"MT" ));
        series1.getData().add(new XYChart.Data<Number, String>(23.6 ,"IT" ));
        series1.getData().add(new XYChart.Data<Number, String>(23.9 ,"IE" ));
        series1.getData().add(new XYChart.Data<Number, String>(24.2 ,"EE" ));
        series1.getData().add(new XYChart.Data<Number, String>(25.0 ,"SK" ));
        series1.getData().add(new XYChart.Data<Number, String>(25.8 ,"SI" ));
        series1.getData().add(new XYChart.Data<Number, String>(26.1 ,"AT" ));
        series1.getData().add(new XYChart.Data<Number, String>(27.5 ,"PL" ));
        series1.getData().add(new XYChart.Data<Number, String>(27.6 ,"DE" ));
        series1.getData().add(new XYChart.Data<Number, String>(28.0 ,"PT" ));
        series1.getData().add(new XYChart.Data<Number, String>(28.6 ,"LV" ));
        series1.getData().add(new XYChart.Data<Number, String>(30.2 ,"CZ" ));
        series1.getData().add(new XYChart.Data<Number, String>(31.7 ,"ES" ));
        series1.getData().add(new XYChart.Data<Number, String>(33.7 ,"BE" ));
        series1.getData().add(new XYChart.Data<Number, String>(34.8 ,"FI" ));
        series1.getData().add(new XYChart.Data<Number, String>(35.1 ,"LT" ));
        series1.getData().add(new XYChart.Data<Number, String>(37.2 ,"NL" ));
        series1.getData().add(new XYChart.Data<Number, String>(39.9 ,"LU" ));
        series1.getData().add(new XYChart.Data<Number, String>(44.2 ,"GR" ));
        series1.getData().add(new XYChart.Data<Number, String>(45.4 ,"CY" ));
        series1.getData().add(new XYChart.Data<Number, String>(47.6 ,"RO" ));
        series1.getData().add(new XYChart.Data<Number, String>(54.2 ,"BG" ));
        bc.getData().add(series1);


        yAxis.setTickLabelRotation(0d);
        bc.setCategoryGap(1d);
        return bc;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}