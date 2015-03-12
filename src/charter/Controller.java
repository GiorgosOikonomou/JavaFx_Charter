package charter;

import charts.GOLineChart;
import charts.GOLineChartModel;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Controller {
    private Stage stageToRender;
    @FXML
    private AnchorPane anchorRight;
    @FXML
    private Button btn_generate, btn_add;
    @FXML
    private TableView tableView;
    @FXML
    private ChoiceBox choiceBox;

    private ObservableList<GOLineChartModel> data;
    private LineChart lineChart;

    public Controller(final Stage stageToRender) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Controller.fxml"));
        fxmlLoader.setController(this);
        Parent root = (Parent) fxmlLoader.load();
        this.stageToRender = stageToRender;
        stageToRender.setScene(new Scene(root));
        stageToRender.setTitle("Line Chart ~ Giorgos Oikonomou");
        stageToRender.show();

        btn_generate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Controller.this.generateChart();
            }
        });

        this.populateTable();

        btn_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                data.add(new GOLineChartModel(new SimpleDoubleProperty(Math.random() * 100),
                        new SimpleDoubleProperty(Math.random() * 100)));
            }
        });


        final ContextMenu contextMenu = new ContextMenu();
        MenuItem saveImage = new MenuItem("Export image");
        contextMenu.getItems().addAll(saveImage);
        saveImage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Controller.this.saveImage();
            }
        });

        anchorRight.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isSecondaryButtonDown()) {
                    contextMenu.show(anchorRight, event.getScreenX(), event.getScreenY());
                }
            }
        });


    }

    private void populateTable() {
        data = FXCollections.observableArrayList(
                new GOLineChartModel(new SimpleDoubleProperty(1), new SimpleDoubleProperty(1)),
                new GOLineChartModel(new SimpleDoubleProperty(2), new SimpleDoubleProperty(5)),
                new GOLineChartModel(new SimpleDoubleProperty(4), new SimpleDoubleProperty(4))
        );
        tableView.setEditable(true);

        TableColumn firstNameCol = new TableColumn("x Axis");
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<GOLineChartModel, Double>("xAxis"));

        TableColumn lastNameCol = new TableColumn("y Axis");
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<GOLineChartModel, Double>("yAxis"));

        tableView.setItems(data);
        tableView.getColumns().addAll(firstNameCol, lastNameCol);

//        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        firstNameCol.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<GOLineChartModel, Double>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<GOLineChartModel, Double> t) {
//                        ((GOLineChartModel) t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setxAxis(t.getNewValue());
//                    }
//
//                }
//        );
//
//        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        lastNameCol.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<GOLineChartModel, Double>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<GOLineChartModel, Double> t) {
//                        ((GOLineChartModel) t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setyAxis(t.getNewValue());
//                    }
//                }
//        );

        choiceBox.setItems(FXCollections.observableArrayList(
                "First", "Second", "Third")
        );
    }

    private void generateChart() {
        if (!anchorRight.getChildren().isEmpty()) {
            anchorRight.getChildren().clear();
        }
        //generate a chart and fit to parent
        lineChart = new GOLineChart().createChart(data);
        AnchorPane.setTopAnchor(lineChart, 0.0);
        AnchorPane.setRightAnchor(lineChart, 0.0);
        AnchorPane.setLeftAnchor(lineChart, 0.0);
        AnchorPane.setBottomAnchor(lineChart, 0.0);
        //add chart to gui
        anchorRight.getChildren().add(lineChart);


    }

    private void saveImage() {
        if (lineChart != null) {
            WritableImage image = lineChart.snapshot(new SnapshotParameters(), null);
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save diagram as png file. . .");
            File file = fileChooser.showSaveDialog(stageToRender);
            if (file != null) {
                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                } catch (IOException e) {
                }
            }
        }
    }
}
