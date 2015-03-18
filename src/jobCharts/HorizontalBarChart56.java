package jobCharts;

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

import java.util.Arrays;


public class HorizontalBarChart56 extends Application {
    String[] years=new String[]{

            "AT",
            "BE",
            "BG",
            "CY",
            "CZ",
            "DE",
            "DK",
            "EE",
            "ES",
            "FI",
            "FR",
            "GR",
            "HU",
            "IE",
            "IT",
            "LT",
            "LU",
            "MT",
            "NL",
            "LV",
            "PL",
            "PT",
            "RO",
            "SE",
            "SI",
            "SK",
            "UK",



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

        XYChart.Series<Number,String> series2 = new XYChart.Series<Number,String>();
        yAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(years)));

        series1.setName("Gasoline");
        series2.setName("Diesel");
        loadData(series1);
        loadData2(series2);


        bc.getData().add(series1);
        bc.getData().add(series2);
        return bc;
    }

    private void loadData2(XYChart.Series<Number,String> series){

        double[] data=new double[]{

                28.7,
                38.4,
                53.2,
                41.5,
                27.6,
                30.6,
                26.7,
                23.5,
                32.8,
                33.9,
                30.8,
                49.7,
                0,
                30.0,
                34.0,
                35.7,
                40.3,
                30.9,
                48.4,
                26.6,
                26.0,
                35.2,
                49.2,
                21.6,
                29.6,
                25.9,
                26.2,



        };

        for (int i = 0; i <years.length ; i++) {
            series.getData().add(new XYChart.Data<Number,String>(data[i], years[i]));
        }


    }

    private void loadData(XYChart.Series<Number,String> series){

        double[] data=new double[]{

                26.2,
                33.8,
                54.3,
                45.4,
                30.2,
                27.6,
                18.8,
                24.2,
                31.8,
                34.9,
                20.0,
                44.2,
                23.4,
                24.0,
                23.6,
                35.1,
                40.0,
                23.6,
                37.3,
                28.7,
                27.5,
                28.0,
                47.6,
                20.0,
                25.9,
                25.1,
                19.2,


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