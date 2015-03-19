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
public class LineChartDiesel extends Application {

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        NumberAxis xAxis = new NumberAxis("Values for X-Axis", 0, 3, 1);
        NumberAxis yAxis = new NumberAxis("Values for Y-Axis", 0, 3, 1);
        LineChart lineChart=createChart();
        lineChart.setPadding(Insets.EMPTY);
        root.getChildren().add(lineChart);
    }






    public LineChart<String, Number> createChart() {

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<String, Number> lc = new LineChart<String, Number>(xAxis, yAxis);
        // setup chart
        lc.setTitle("Diesel");
        xAxis.setLabel("Technology");
        yAxis.setLabel("g/km");
        yAxis.setPadding(Insets.EMPTY);

        // add starting data
        XYChart.Series<String, Number> seriesCO = new XYChart.Series<String, Number>();
        seriesCO.setName("CO");
        seriesCO.getData().addAll(new XYChart.Data("Euro 1",2.72d));
        seriesCO.getData().addAll(new XYChart.Data("Euro 2",1d));
        seriesCO.getData().addAll(new XYChart.Data("Euro 2",1d));
        seriesCO.getData().addAll(new XYChart.Data("Euro 3",0.64d));
        seriesCO.getData().addAll(new XYChart.Data("Euro 4",0.5d));
        seriesCO.getData().addAll(new XYChart.Data("Euro 5",0.5d));
        seriesCO.getData().addAll(new XYChart.Data("Euro 6",0.5d));


        XYChart.Series<String, Number> seriesNOX = new XYChart.Series<String, Number>();
        seriesNOX.setName("NOx");
        seriesNOX.getData().addAll(new XYChart.Data("Euro 3",0.5d));
        seriesNOX.getData().addAll(new XYChart.Data("Euro 4",0.25d));
        seriesNOX.getData().addAll(new XYChart.Data("Euro 5",0.18d));
        seriesNOX.getData().addAll(new XYChart.Data("Euro 6",0.08d));


        XYChart.Series<String, Number> seriesPM = new XYChart.Series<String, Number>();
        seriesPM.setName("PM");
        seriesPM.getData().addAll(new XYChart.Data("Euro 1",0.14d));
        seriesPM.getData().addAll(new XYChart.Data("Euro 2",0.08d));
        seriesPM.getData().addAll(new XYChart.Data("Euro 2",0.1d));
        seriesPM.getData().addAll(new XYChart.Data("Euro 3",0.05d));
        seriesPM.getData().addAll(new XYChart.Data("Euro 4",0.025d));
        seriesPM.getData().addAll(new XYChart.Data("Euro 5",0.005d));
        seriesPM.getData().addAll(new XYChart.Data("Euro 6", 0.005d));




        lc.getData().add(seriesCO);
        lc.getData().add(seriesNOX);
        lc.getData().add(seriesPM);
        return lc;
    }










    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}



