package jobCharts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


/**
 * Created by oikonomou on 3/11/2015.
 */
public class ChartConsumptionsIncrease extends Application {
    StackedBarChart chart;
    Stage primaryStage;

    private void init(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        primaryStage.setScene(new Scene(root));
        String[] years = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        CategoryAxis xAxis = CategoryAxisBuilder.create()
                .categories(FXCollections.<String>observableArrayList(years)).build();
        NumberAxis yAxis = NumberAxisBuilder.create()
                .label("Fuel \n consumption")
                .lowerBound(0.0d)
                .upperBound(10000.0d)
                .tickUnit(1000.0d).build();


        ObservableList<StackedBarChart.Series> barChartData = FXCollections.observableArrayList(
                new StackedBarChart.Series("Type approval", FXCollections.observableArrayList(
                        new StackedBarChart.Data(years[0], 7.6),
                        new StackedBarChart.Data(years[1], 0),
                        new StackedBarChart.Data(years[2], 0),
                        new StackedBarChart.Data(years[3], 0),
                        new StackedBarChart.Data(years[4], 0),
                        new StackedBarChart.Data(years[5], 0),
                        new StackedBarChart.Data(years[6], 0),
                        new StackedBarChart.Data(years[7], 0)
                )),
                new StackedBarChart.Series("Real world", FXCollections.observableArrayList(
                        new StackedBarChart.Data(years[0], 0),
                        new StackedBarChart.Data(years[1], 8.8),
                        new StackedBarChart.Data(years[2], 8.8),
                        new StackedBarChart.Data(years[3], 8.8),
                        new StackedBarChart.Data(years[4], 8.8),
                        new StackedBarChart.Data(years[5], 8.8),
                        new StackedBarChart.Data(years[6], 8.8),
                        new StackedBarChart.Data(years[7], 0)
                )),
                new StackedBarChart.Series("Air-Conditioning", FXCollections.observableArrayList(
                        new StackedBarChart.Data(years[0], 0),
                        new StackedBarChart.Data(years[1], 0),
                        new StackedBarChart.Data(years[2], 9.7 - 8.8),
                        new StackedBarChart.Data(years[3], 0),
                        new StackedBarChart.Data(years[4], 0),
                        new StackedBarChart.Data(years[5], 0),
                        new StackedBarChart.Data(years[6], 0),
                        new StackedBarChart.Data(years[7], 0)
                )),
                new StackedBarChart.Series("Additional load", FXCollections.observableArrayList(
                        new StackedBarChart.Data(years[0], 0),
                        new StackedBarChart.Data(years[1], 0),
                        new StackedBarChart.Data(years[2], 0),
                        new StackedBarChart.Data(years[3], 9.3 - 8.8),
                        new StackedBarChart.Data(years[4], 0),
                        new StackedBarChart.Data(years[5], 0),
                        new StackedBarChart.Data(years[6], 0),
                        new StackedBarChart.Data(years[7], 0)
                )),
                new StackedBarChart.Series("Aggressive driving", FXCollections.observableArrayList(
                        new StackedBarChart.Data(years[0], 0),
                        new StackedBarChart.Data(years[1], 0),
                        new StackedBarChart.Data(years[2], 0),
                        new StackedBarChart.Data(years[3], 0),
                        new StackedBarChart.Data(years[4], 10.1 - 8.8),
                        new StackedBarChart.Data(years[5], 0),
                        new StackedBarChart.Data(years[6], 0),
                        new StackedBarChart.Data(years[7], 0)
                )),
                new StackedBarChart.Series("Roof rack", FXCollections.observableArrayList(
                        new StackedBarChart.Data(years[0], 0),
                        new StackedBarChart.Data(years[1], 0),
                        new StackedBarChart.Data(years[2], 0),
                        new StackedBarChart.Data(years[3], 0),
                        new StackedBarChart.Data(years[4], 0),
                        new StackedBarChart.Data(years[5], 9.7 - 8.8),
                        new StackedBarChart.Data(years[6], 0),
                        new StackedBarChart.Data(years[7], 0)
                )),
                new StackedBarChart.Series("Combined", FXCollections.observableArrayList(
                        new StackedBarChart.Data(years[0], 0),
                        new StackedBarChart.Data(years[1], 0),
                        new StackedBarChart.Data(years[2], 0),
                        new StackedBarChart.Data(years[3], 0),
                        new StackedBarChart.Data(years[4], 0),
                        new StackedBarChart.Data(years[5], 0),
                        new StackedBarChart.Data(years[6], (0.3138 + 1) * (0.0942 + 1) * 8.8 - 8.8),
                        new StackedBarChart.Data(years[7], 0)
                ))
//                new StackedBarChart.Series("Combined", FXCollections.observableArrayList(
//                        new StackedBarChart.Data(years[0], 0),
//                        new StackedBarChart.Data(years[1], 0),
//                        new StackedBarChart.Data(years[2], 0),
//                        new StackedBarChart.Data(years[3], 0),
//                        new StackedBarChart.Data(years[4], 0),
//                        new StackedBarChart.Data(years[5], 0),
//                        new StackedBarChart.Data(years[6], 0),
//                                new StackedBarChart.Data(years[7], 12.27)
//                        ))
        );


        chart = new StackedBarChart(xAxis, yAxis, barChartData, 25.0d);

        final ContextMenu contextMenu = new ContextMenu();
        MenuItem saveImage = new MenuItem("Export image");
        contextMenu.getItems().addAll(saveImage);
        saveImage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ChartConsumptionsIncrease.this.saveImage();
            }
        });

        chart.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {


                if (event.isSecondaryButtonDown()) {
                    contextMenu.show(chart, event.getScreenX(), event.getScreenY());
                }
            }
        });


        root.getChildren().add(chart);

        AnchorPane.setTopAnchor(root, 0.0);
        AnchorPane.setRightAnchor(root, 0.0);
        AnchorPane.setLeftAnchor(root, 0.0);
        AnchorPane.setBottomAnchor(root, 0.0);

        AnchorPane.setTopAnchor(chart, 0.0);
        AnchorPane.setBottomAnchor(chart, 0.0);
        AnchorPane.setLeftAnchor(chart, 0.0);
        AnchorPane.setRightAnchor(chart, 0.0);


        yAxis.tickLabelFontProperty().set(Font.font(18));

        chart.setStyle(".chart-title {\n" +
                "  -fx-text-fill: #4682b4;\n" +
                "  -fx-font-size: 1.6em;\n" +
                "}\n" +
                " \n" +
                ".axis-label {\n" +
                "  -fx-text-fill: #4682b4;\n" +
                "}\n" +
                " \n" +
                ".chart-legend {\n" +
                "   -fx-background-color:  transparent;\n" +
                "   -fx-padding: 16px;\n" +
                "}\n" +
                " ");

    }

    private void saveImage() {
        if (chart != null) {
            WritableImage image = chart.snapshot(new SnapshotParameters(), null);
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save diagram as png file. . .");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );
            File file = fileChooser.showSaveDialog(primaryStage);
            if (file != null) {
                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                } catch (IOException e) {
                }
            }
            SnapshotParameters snapshotParameters = new SnapshotParameters();
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
        primaryStage.setTitle("Charter");
        primaryStage.setWidth(800);
        primaryStage.setMinHeight(600);
        this.primaryStage = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
