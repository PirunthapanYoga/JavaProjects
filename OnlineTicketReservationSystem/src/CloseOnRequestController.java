import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CloseOnRequestController implements Initializable {


    public static Button reserve;
    public Button close;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        close.setOnAction(e -> {
            popUpClose();
            windowClose();
        });
    }

    private void popUpClose() {
        Stage s = (Stage) close.getScene().getWindow();
        s.close();
    }

    private void windowClose() {
        ControllerRes.againBook();
        Stage s = (Stage) reserve.getScene().getWindow();
        s.close();
    }
}
