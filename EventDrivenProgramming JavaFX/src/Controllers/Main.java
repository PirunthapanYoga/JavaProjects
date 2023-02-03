package Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent rootReg = FXMLLoader.load(getClass().getResource("/FXML/RegForm.fxml"));
        Scene scene = new Scene(rootReg, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            Details d = new Details(RegistrationPageController.detailsList);
            d.write();
        });
    }

}
