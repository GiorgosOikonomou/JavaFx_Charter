package jobCharts.lineXY;

/**
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A chart in which lines connect a series of data points. Useful for viewing
 * data trends over time.
 *
 * @see javafx.scene.chart.LineChart
 * @see javafx.scene.chart.Chart
 * @see javafx.scene.chart.Axis
 * @see javafx.scene.chart.NumberAxis
 * @related charts/area/AreaChart
 * @related charts/scatter/ScatterChart
 */
public class LineChartPetrol extends Application {

    private void init(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        primaryStage.setScene(new Scene(root));
        NumberAxis xAxis = new NumberAxis("Values for X-Axis", 0, 3, 1);
        NumberAxis yAxis = new NumberAxis("Values for Y-Axis", 0, 3, 1);
        LineChart lineChart=createChart();
        root.getChildren().add(lineChart);
        AnchorPane.setRightAnchor(lineChart,0d);
        AnchorPane.setLeftAnchor(lineChart, 0d);
        AnchorPane.setTopAnchor(lineChart, 0d);
        AnchorPane.setBottomAnchor(lineChart, 500d);

        primaryStage.setWidth(800d);
        primaryStage.setHeight(1000d);


    }






    public LineChart<String, Number> createChart() {

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<String, Number> lc = new LineChart<String, Number>(xAxis, yAxis);
        // setup chart
        lc.setTitle("Petrol");
        xAxis.setLabel("Technology");
        yAxis.setLabel("g/km");
        yAxis.setPadding(Insets.EMPTY);

        // add starting data
        XYChart.Series<String, Number> seriesCO = new XYChart.Series<String, Number>();
        seriesCO.setName("CO");
        seriesCO.getData().addAll(new XYChart.Data("Euro 1",2.72));
        seriesCO.getData().addAll(new XYChart.Data("Euro 2",2.2));
        seriesCO.getData().addAll(new XYChart.Data("Euro 3",2.3));
        seriesCO.getData().addAll(new XYChart.Data("Euro 4",1));
        seriesCO.getData().addAll(new XYChart.Data("Euro 5",1));
        seriesCO.getData().addAll(new XYChart.Data("Euro 6",1));


        XYChart.Series<String, Number> seriesNOX = new XYChart.Series<String, Number>();
        seriesNOX.setName("NOx");
        seriesNOX.getData().addAll(new XYChart.Data("Euro 3", 0.15));
        seriesNOX.getData().addAll(new XYChart.Data("Euro 4",0.08));
        seriesNOX.getData().addAll(new XYChart.Data("Euro 5",0.06));
        seriesNOX.getData().addAll(new XYChart.Data("Euro 6",0.06));


        XYChart.Series<String, Number> seriesPM = new XYChart.Series<String, Number>();
        seriesPM.setName("PM");
        seriesPM.getData().addAll(new XYChart.Data("Euro 5",0.005));
        seriesPM.getData().addAll(new XYChart.Data("Euro 6", 0.005));

        XYChart.Series<String, Number> seriesHC = new XYChart.Series<String, Number>();
        seriesHC.setName("HC");
        seriesHC.getData().addAll(new XYChart.Data("Euro 3", 0.2));
        seriesHC.getData().addAll(new XYChart.Data("Euro 4", 0.1));
        seriesHC.getData().addAll(new XYChart.Data("Euro 5",0.1));
        seriesHC.getData().addAll(new XYChart.Data("Euro 6",0.1));


        lc.getData().add(seriesCO);
        lc.getData().add(seriesNOX);
        lc.getData().add(seriesPM);
        lc.getData().add(seriesHC);
        return lc;
    }










    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}



