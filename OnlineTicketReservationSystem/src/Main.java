import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage s;
    public static Parent frontRoot;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        frontRoot = FXMLLoader.load(getClass().getResource("FXML/FrontUI.fxml"));
        primaryStage.setScene(new Scene(frontRoot, 1180, 790));
        primaryStage.setTitle("RAPID RESERVE 404");
        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(800);
        primaryStage.show();
        primaryStage.resizableProperty().set(false);
        s = primaryStage;
    }
}

