package jobCharts.bubble;
/**
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * A chart that plots bubbles for a series of data points. Bubbles are plotted
 * according to three numeric parameters: value on x axis, value on y axis,
 * and radius of the bubble.
 *
 * @see javafx.scene.chart.BubbleChart
 * @see javafx.scene.chart.Chart
 * @see javafx.scene.chart.Axis
 * @see javafx.scene.chart.NumberAxis
 */
public class BublChart5 extends Application {
//jfxrt.jar!/com/sun/javafx/scene/control/skin/caspian/caspian.css
    private void init(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        primaryStage.setScene(new Scene(root));
        NumberAxis xAxis = new NumberAxis("RPM [% of max]", 000d, 109d, 10d);

        NumberAxis yAxis = new NumberAxis("Engine Torque [% of max]",000d, 109d, 10d);

        ObservableList<BubbleChart.Series> bubbleChartData = FXCollections.observableArrayList(
                new BubbleChart.Series("Series 1", FXCollections.observableArrayList(
                        new XYChart.Data(  100d / 6300d *   3095.6d   ,    100d /157d *   65.33d   ,    5d / 12.41d *  16.6d),
                        new XYChart.Data(  100d / 6300d *   3080.5d   ,    100d /157d *   97.55d   ,    5d / 12.41d *  10.74d),
                        new XYChart.Data(  100d / 6300d *   2637.92d  ,    100d /157d *   42.50d   ,    5d / 12.41d *  10.21d),
                        new XYChart.Data(  100d / 6300d *   2673.47d  ,    100d /157d *   80.03d   ,    5d / 12.41d *  9.08d),
                        new XYChart.Data(  100d / 6300d *   2370.54d  ,    100d /157d *   42.33d   ,    5d / 12.41d *  8.41d),
                        new XYChart.Data(  100d / 6300d *   2366.63d  ,    100d /157d *   -0.71d   ,    5d / 12.41d *  8.22d),
                        new XYChart.Data(  100d / 6300d *   3493.38d  ,    100d /157d *   83.49d   ,    5d / 12.41d *  8.04d),
                        new XYChart.Data(  100d / 6300d *   1691.17d  ,    100d /157d *   -1.86d   ,    5d / 12.41d *  7.0d),
                        new XYChart.Data(  100d / 6300d *   3039.13d  ,    100d /157d *   2.29d   ,     5d / 12.41d *  5.63d),
                        new XYChart.Data(  100d / 6300d *   2419.39d  ,    100d /157d *   112.95d   ,   5d / 12.41d *  3.87d),
                        new XYChart.Data(  100d / 6300d *   3347.79d  ,    100d /157d *   129.86d   ,   5d / 12.41d *  3.35d),
                        new XYChart.Data(  100d / 6300d *   1934.34d  ,    100d /157d *   40.17d   ,    5d / 12.41d *  3.25d),
                        new XYChart.Data(  100d / 6300d *   1801.04d   ,   100d /157d *   81.45d   ,    5d / 12.41d *  2.88d),
                        new XYChart.Data(  100d / 6300d *   735.41d  ,     100d /157d *  -5.42d   ,     5d / 12.41d *  2.74d)))
        );


//          setUserAgentStylesheet(STYLESHEET_CASPIAN);

        NumberAxis xAxis2 = new NumberAxis("", 0, 3, 1);
        NumberAxis yAxis2 = new NumberAxis("", 0, 3, 1);
        ObservableList<XYChart.Series<Double,Double>> lineChartData = FXCollections.observableArrayList(
                new AreaChart.Series<Double,Double>("Περιβάλλουσα", FXCollections.observableArrayList(
                        new XYChart.Data<Double,Double>( 100d / 6300d  * 800d,  100d / 157 *  75d),
                        new XYChart.Data<Double,Double>( 100d / 6300d  * 1330d, 100d / 157 *  135d),
                        new XYChart.Data<Double,Double>( 100d / 6300d  * 1600d, 100d / 157 *  157d),
                        new XYChart.Data<Double,Double>( 100d / 6300d  * 3000d, 100d / 157 *  157d),
                        new XYChart.Data<Double,Double>( 100d / 6300d  * 3500d, 100d / 157 *  157d),
                        new XYChart.Data<Double,Double>( 100d / 6300d  * 3600d, 100d / 157 *  156.5d),
                        new XYChart.Data<Double,Double>( 100d / 6300d  * 3700d, 100d / 157 *  156d),
                        new XYChart.Data<Double,Double>( 100d / 6300d  * 3800d, 100d / 157 *  155d),
                        new XYChart.Data<Double,Double>( 100d / 6300d  * 3950d, 100d / 157 *  152.5d),
            new XYChart.Data<Double,Double>( 100d / 6300d  * 6300d, 100d / 157 *  90d)
                ))
        );



        BubbleChart chart = new BubbleChart(xAxis, yAxis, bubbleChartData);
        AreaChart chart2 = new AreaChart(xAxis, yAxis, lineChartData);
        chart2.setCreateSymbols(false);


        root.getChildren().add(chart2);
        root.getChildren().add(chart);


        AnchorPane.setTopAnchor(root, 0.0);
        AnchorPane.setRightAnchor(root, 0.0);
        AnchorPane.setLeftAnchor(root, 0.0);
        AnchorPane.setBottomAnchor(root, 0.0);

        AnchorPane.setTopAnchor(chart, 0.0);
        AnchorPane.setBottomAnchor(chart, 0.0);
        AnchorPane.setLeftAnchor(chart, 0.0);
        AnchorPane.setRightAnchor(chart, 0.0);

        AnchorPane.setTopAnchor(chart2, 0.0);
        AnchorPane.setBottomAnchor(chart2, 0.0);
        AnchorPane.setLeftAnchor(chart2, 0.0);
        AnchorPane.setRightAnchor(chart2, 0.0);


        chart2.setAlternativeColumnFillVisible(false);
        chart2.setAlternativeRowFillVisible(false);

        primaryStage.getScene().getStylesheets().add("jobCharts/styleshhet.css");






        final ContextMenu contextMenu = new ContextMenu();
        MenuItem saveImage = new MenuItem("Export image");
        contextMenu.getItems().addAll(saveImage);
        saveImage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WritableImage image = primaryStage.getScene().snapshot(null);
                FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialFileName(getClass().getName());

                String currentDir = System.getProperty("user.home") + "/Desktop";
                File file = new File(currentDir);
                fileChooser.setInitialDirectory(file);
                fileChooser.setInitialFileName(getClass().getName());


                fileChooser.setTitle("Save diagram as png file. . .");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("PNG", "*.png")
                );
                file = fileChooser.showSaveDialog(primaryStage);
                if (file != null) {
                    try {
                        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                    } catch (IOException e) {
                    }
                }
                SnapshotParameters snapshotParameters = new SnapshotParameters();
            }
        });

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {


                if (event.isSecondaryButtonDown()) {
                    contextMenu.show(chart, event.getScreenX(), event.getScreenY());
                }
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Artemis MW 150");

    }

    public static void main(String[] args) {
        launch(args);
    }

}


