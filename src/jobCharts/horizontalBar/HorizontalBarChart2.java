package jobCharts.horizontalBar;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jobCharts.ExportToPng;

import java.util.Arrays;


public class HorizontalBarChart2 extends Application {
    String[] years=new String[]{

            "SE",
            "EE",
            "SK",
            "PL",
            "UK",
            "LV",
            "DK",
            "CZ",
            "AT",
            "SI",
            "IE",
            "DE",
            "FR",
            "MT",
            "ES",
            "FI",
            "IT",
            "PT",
            "LT",
            "BE",
            "LU",
            "CY",
            "NL",
            "RO",
            "GR",
            "BG",
            "HU",
    };

    private void init(Stage primaryStage) {
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        AnchorPane root = new AnchorPane();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {


                if (event.isSecondaryButtonDown()) {
                    ExportToPng.exportToPng(primaryStage);
                }
            }
        });

        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(450);
        primaryStage.setHeight(800);

        BarChart barChart=createChart();
        root.getChildren().add(barChart);
        AnchorPane.setTopAnchor(barChart, 0d);
        AnchorPane.setBottomAnchor(barChart, 0d);
        AnchorPane.setLeftAnchor(barChart, 0d);
        AnchorPane.setRightAnchor(barChart, 0d);

    }

    protected BarChart<Number, String> createChart() {
        final CategoryAxis yAxis = new CategoryAxis();
        final NumberAxis xAxis = new NumberAxis();
        final BarChart<Number,String> bc = new BarChart<Number,String>(xAxis,yAxis);

        bc.setTitle("Percentage Over");
        bc.setBarGap(0);
        bc.setCategoryGap(5);


        yAxis.setLabel("Country");
        xAxis.setLabel("CO2 emissions [g/km] difference");

        yAxis.setTickLabelGap(10);
        yAxis.setTickLabelRotation(0);
        yAxis.setTickLabelGap(10d);

        yAxis.setTickLabelFont(Font.font("Arial", 15));
        yAxis.setStyle("-fx-font-size: 20;");

        xAxis.setTickLabelFont(Font.font("Arial", 15));
        xAxis.setStyle("-fx-font-size: 20;");



        XYChart.Series<Number,String> series1 = new XYChart.Series<Number,String>();
        yAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(years)));

        series1.setName("Diesel");
        loadData(series1);


        bc.getData().add(series1);
        return bc;
    }



    private void loadData(XYChart.Series<Number,String> series){

        double[] data=new double[]{

                21.6,
                23.5,
                25.9,
                26.0,
                26.2,
                26.6,
                26.7,
                27.6,
                28.7,
                29.6,
                30.0,
                30.6,
                30.8,
                30.9,
                32.8,
                33.9,
                34.0,
                35.2,
                35.7,
                38.4,
                40.3,
                41.5,
                48.4,
                49.2,
                49.7,
                53.2,
                0,


        };

        for (int i = 0; i <years.length ; i++) {
            series.getData().add(new XYChart.Data<Number,String>(data[i], years[i]));
        }


    }

    private void displayLabelForData(BarChart.Data<String, Number> data) {
        final Node node = data.getNode();
        final Text dataText = new Text(data.getYValue() + "");
        node.parentProperty().addListener(new ChangeListener<Parent>() {
            @Override public void changed(ObservableValue<? extends Parent> ov, Parent oldParent, Parent parent) {
                Group parentGroup = (Group) parent;
                parentGroup.getChildren().add(dataText);
            }
        });

        node.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
            @Override public void changed(ObservableValue<? extends Bounds> ov, Bounds oldBounds, Bounds bounds) {
                dataText.setLayoutX(
                        Math.round(
                                bounds.getMinX() + bounds.getWidth() / 2 - dataText.prefWidth(-1) / 2
                        )
                );
                dataText.setLayoutY(
                        Math.round(
                                bounds.getMinY() - dataText.prefHeight(-1) * 0.5
                        )
                );
            }
        });
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();

    }
    public static void main(String[] args) { launch(args); }
}