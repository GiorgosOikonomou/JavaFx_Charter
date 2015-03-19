package jobCharts.bar;

/**
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.util.StringConverter;
import jobCharts.ExportToPng;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * A chart that displays rectangular bars with heights indicating data values
 * for categories. Used for displaying information when at least one axis has
 * discontinuous or discrete data.
 *
 * @see javafx.scene.chart.BarChart
 * @see javafx.scene.chart.Chart
 * @see javafx.scene.chart.Axis
 * @see javafx.scene.chart.CategoryAxis
 * @see javafx.scene.chart.NumberAxis
 *
 */
public class BarChartSample extends Application {

    private void init(Stage primaryStage) {
        primaryStage.setWidth(700d);
        primaryStage.setHeight(700d);



        AnchorPane root = new AnchorPane();
        primaryStage.setScene(new Scene(root));
        String[] years = {
                "ADAC\n",
                "AMS",
                "AR",
                "TCS",
                "A300DB",
                "SMon",
                "All"
        };
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(years));

        NumberAxis yAxis = new NumberAxis("Ratio FC InUse/FC TA - Average\n  ", 0.0d, 50d,10);
        yAxis.setTickLabelFormatter(
                new NumberAxis.DefaultFormatter(yAxis, null, "%")
        );

        ObservableList<BarChart.Series> barChartData = FXCollections.observableArrayList(
                new BarChart.Series("Petrol", FXCollections.observableArrayList(
                        new BarChart.Data(years[0], 9d),
                        new BarChart.Data(years[1], 34d),
                        new BarChart.Data(years[2], 11d),
                        new BarChart.Data(years[3], 6d),
                        new BarChart.Data(years[4], 12d),
                        new BarChart.Data(years[5], 20d),
                        new BarChart.Data(years[6], 15d)
                )),
                new BarChart.Series("Diesel", FXCollections.observableArrayList(
                        new BarChart.Data(years[0], 9d),
                        new BarChart.Data(years[1], 40d),
                        new BarChart.Data(years[2], 18d),
                        new BarChart.Data(years[3], 12d),
                        new BarChart.Data(years[4], 11d),
                        new BarChart.Data(years[5], 17d),
                        new BarChart.Data(years[6], 18d)
                ))

        );





        BarChart chart = new BarChart(xAxis, yAxis, barChartData, 25.0d);

        setUserAgentStylesheet(STYLESHEET_MODENA);
        //setUserAgentStylesheet(STYLESHEET_CASPIAN);
        yAxis.tickLabelFontProperty().set(Font.font(18));
        xAxis.tickLabelFontProperty().set(Font.font(18));
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





        AnchorPane.setTopAnchor(chart, 0d);
        AnchorPane.setBottomAnchor(chart, 0d);
        AnchorPane.setLeftAnchor(chart, 0d);
        AnchorPane.setRightAnchor(chart, 0d);

        root.getChildren().add(chart);
        ExportToPng.setExporter(primaryStage,root);
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }

}