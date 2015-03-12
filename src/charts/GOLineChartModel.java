package charts;

import javafx.beans.property.SimpleDoubleProperty;

/**
 * Created by giorgos on 27/2/2015.
 */
public class GOLineChartModel {
    private final SimpleDoubleProperty xAxis;
    private final SimpleDoubleProperty yAxis;


    public GOLineChartModel(SimpleDoubleProperty xAxis, SimpleDoubleProperty yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public double getxAxis() {
        return xAxis.get();
    }

    public SimpleDoubleProperty xAxisProperty() {
        return xAxis;
    }

    public void setxAxis(double xAxis) {
        this.xAxis.set(xAxis);
    }

    public double getyAxis() {
        return yAxis.get();
    }

    public SimpleDoubleProperty yAxisProperty() {
        return yAxis;
    }

    public void setyAxis(double yAxis) {
        this.yAxis.set(yAxis);
    }
}
