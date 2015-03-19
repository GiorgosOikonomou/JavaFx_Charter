package jobCharts;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by oikonomou on 3/17/2015.
 */
public class SceneToPng {

    public static void exportSceneToPng(Stage primaryStage){
        WritableImage image = primaryStage.getScene().snapshot(null);
        FileChooser fileChooser = new FileChooser();


        String currentDir = System.getProperty("user.home") + "/Desktop";
        File file = new File(currentDir);
        fileChooser.setInitialDirectory(file);
        fileChooser.setInitialFileName("export");

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

}
