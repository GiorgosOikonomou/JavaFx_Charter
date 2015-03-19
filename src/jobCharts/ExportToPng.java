package jobCharts;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by giorgos on 18/3/2015.
 */
public class ExportToPng {

    public static void exportToPng(Stage primaryStage) {
        WritableImage image = primaryStage.getScene().snapshot(null);
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

    public static void setExporter(Stage primaryStage,AnchorPane theElmentToSetRightClick){
        final ContextMenu contextMenu = new ContextMenu();
        MenuItem saveImage = new MenuItem("Export image");
        contextMenu.getItems().addAll(saveImage);
        saveImage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WritableImage image = primaryStage.getScene().snapshot(null);
                FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialFileName(getClass().getName());

                String currentDir = System.getProperty("user.home") + "/Desktop";
                File file = new File(currentDir);
                fileChooser.setInitialDirectory(file);
                fileChooser.setInitialFileName(getClass().getName());


                fileChooser.setTitle("Save diagram as png file. . .");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("PNG", "*.png")
                );
                file = fileChooser.showSaveDialog(primaryStage);
                if (file != null) {
                    try {
                        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                    } catch (IOException e) {
                    }
                }
                SnapshotParameters snapshotParameters = new SnapshotParameters();
            }
        });

        theElmentToSetRightClick.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isSecondaryButtonDown()) {
                    contextMenu.show(theElmentToSetRightClick, event.getScreenX(), event.getScreenY());
                }
            }
        });
    }
}


