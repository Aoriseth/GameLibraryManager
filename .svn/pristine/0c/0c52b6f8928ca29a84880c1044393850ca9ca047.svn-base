import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    //global variables
    private Stage primaryStage;
    private MainMenuController MainMenu_Controller;


    //methods
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Games Manager");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image("Icon.png"));
        showMainMenu();
    }

    public void showSetup() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Setup.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Find Games");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            SetupController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setParent(MainMenu_Controller);

            // Show the dialog and wait until the user closes it
            dialogStage.show();

        } catch (IOException x) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Error while loading the setup menu");
            alert.setContentText(x.toString());
            alert.showAndWait();
        }

    }

    void showMainMenu() {
        AnchorPane MainMenu;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("MainMenu.fxml"));
            MainMenu = loader.load();

            Scene scene = new Scene(MainMenu);
            primaryStage.setScene(scene);
            primaryStage.show();

            MainMenu_Controller = loader.getController();
            MainMenu_Controller.setMainApp(this);

        } catch (IOException x) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Error while loading the main menu");
            alert.setContentText(x.toString());
            alert.showAndWait();
        }
    }

    public void showSearchMove() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Search&Move.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Search");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            SearchMove_controller controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setParent(MainMenu_Controller);

            // Show the dialog and wait until the user closes it
            dialogStage.show();

        } catch (IOException x) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Error while loading the search menu");
            alert.setContentText(x.toString());
            alert.showAndWait();
        }

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void showCompare() {
        // TODO Auto-generated method stub
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Comparison.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Compare Libraries");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            ComparisonController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setParent(MainMenu_Controller);

            // Show the dialog and wait until the user closes it
            dialogStage.show();

        } catch (IOException x) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Error while loading the setup menu");
            alert.setContentText(x.toString());
            alert.showAndWait();
        }
    }

}

