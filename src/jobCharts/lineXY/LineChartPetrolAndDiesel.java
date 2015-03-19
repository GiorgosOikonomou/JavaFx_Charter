package jobCharts.lineXY;

/**
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jobCharts.ExportToPng;

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
public class LineChartPetrolAndDiesel extends Application {

    private void init(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        primaryStage.setScene(new Scene(root));



        //exportToPng
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {


                if (event.isSecondaryButtonDown()) {
                    ExportToPng.exportToPng(primaryStage);
                }
            }
        });


        root.setBackground(Background.EMPTY);






        //chart objects
        LineChart lineChartPetrol=createChartPetrol();
        LineChart lineChartDiesel=createChartDiesel();

        root.getChildren().add(lineChartPetrol);
        AnchorPane.setRightAnchor(lineChartPetrol, 0d);
        AnchorPane.setLeftAnchor(lineChartPetrol, 0d);
        AnchorPane.setTopAnchor(lineChartPetrol, 500d);
        AnchorPane.setBottomAnchor(lineChartPetrol, 0d);
        lineChartPetrol.setMaxHeight(500d);


        lineChartDiesel.setMaxHeight(500d);
        root.getChildren().add(lineChartDiesel);
        AnchorPane.setRightAnchor(lineChartDiesel, 0d);
        AnchorPane.setLeftAnchor(lineChartDiesel, 0d);
        AnchorPane.setTopAnchor(lineChartDiesel, 0d);
        AnchorPane.setBottomAnchor(lineChartDiesel, 500d);

        primaryStage.setWidth(800d);
        primaryStage.setHeight(1000d);


        lineChartDiesel.setLegendVisible(false);
        lineChartPetrol.setStyle(".chart-legend {\n" +
                "   -fx-background-color:  transparent;\n" +
                "   -fx-padding: 0px;\n" +
                " -fx-font-size:18 }");

        lineChartDiesel.setStyle(".chart-legend {\n" +
                "   -fx-background-color:  transparent;\n" +
                "   -fx-padding: 0px;\n" +
                " -fx-font-size:18 }");
        lineChartPetrol.getXAxis().setTickLabelFont(Font.font("Arial",16));
        lineChartPetrol.getYAxis().setTickLabelFont(Font.font("Arial",16));
        lineChartDiesel.getXAxis().setTickLabelFont(Font.font("Arial",16));
        lineChartDiesel.getYAxis().setTickLabelFont(Font.font("Arial",16));


    }






    public LineChart<String, Number> createChartPetrol() {

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<String, Number> lc = new LineChart<String, Number>(xAxis, yAxis);
        // setup chart
        lc.setTitle("Petrol");
        xAxis.setLabel("");
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


    public LineChart<String, Number> createChartDiesel() {

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



