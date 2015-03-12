package charts;

import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * Created by oikonomou on 2/26/2015.
 */
public class GOLineChart {

    public LineChart<Number, Number> createChart(ObservableList<GOLineChartModel> data) {

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number, Number> lc = new LineChart<Number, Number>(xAxis, yAxis);
        // setup chart
        lc.setTitle("Basic LineChart");
        xAxis.setLabel("X Axis");
        yAxis.setLabel("Y Axis");
        // add starting data
        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        series.setName("Data Series 1");

        for (GOLineChartModel modelItem : data) {
            series.getData().add(new XYChart.Data<Number, Number>(modelItem.getxAxis(), modelItem.getyAxis()));
        }

        series.setName("Giorgos");
        lc.getData().add(series);
        return lc;
    }



}
