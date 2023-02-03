package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationPageController implements Initializable {

    public static List<UserDetails> detailsList = new ArrayList<>();
    public static Set<String> userNameset = new HashSet<>();
    private static ObservableList<String> civilStatusList = FXCollections.observableArrayList("Married", "Unmarried", "Divorced", "Widowed");
    private static ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
    public ImageView imgBack;
    public ComboBox<String> civilStatus;
    public DatePicker dateOfBirth;
    public Text emailValidity;
    public Text usernameValidity;
    public TextField firstName;
    public TextField eMail;
    public ComboBox<String> gender;
    public TextField userName;
    public TextField lastName;
    public TextField idNumber;
    public Text numberValidator;
    public TextField contactNumber;
    public Text submitValidator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        set();
    }

    public void set() {
        imgBack.setImage(new Image("/Images/user-group-icon.png"));
        civilStatus.setItems(civilStatusList);
        gender.setItems(genderList);
        usernameValidity.setText("");
        emailValidity.setText("");
        numberValidator.setText("");
        userName.setText("");
        firstName.setText("");
        lastName.setText("");
        idNumber.setText("");
        contactNumber.setText("");
        eMail.setText("");
    }

    public void checkEmailValid() {
        Matcher match = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(eMail.getText());
        if (match.find()) {
            emailValidity.setText("Valid");
            emailValidity.setFill(Color.rgb(0, 255, 0));
        } else {
            emailValidity.setText("Invalid!");
            emailValidity.setFill(Color.rgb(255, 0, 0));
        }
    }

    public void checkContactNumberValid() {
        if (contactNumber.getText().length() == 10) {
            numberValidator.setText("Valid");
            numberValidator.setFill(Color.rgb(0, 255, 0));
        } else {
            numberValidator.setText("Invalid!");
            numberValidator.setFill(Color.rgb(255, 0, 0));
        }
    }

    public void checkUserNameValid() {
        if (userName.getText().length() < 6 || userName.getText().length() > 10) {
            usernameValidity.setText("Invalid! " + userName.getText().length() + " Character Entered");
            usernameValidity.setFill(Color.rgb(255, 0, 0));
        } else {
            if (userName.getText().matches("^[a-zA-Z0-9]*$") && !userNameset.contains(userName.getText())) {
                usernameValidity.setText("Valid");
                usernameValidity.setFill(Color.rgb(0, 255, 0));
            } else {
                usernameValidity.setText("Invalid!");
                usernameValidity.setFill(Color.rgb(255, 0, 0));
            }
        }
    }

    public void submit(ActionEvent actionEvent) throws IOException {
        if (!userNameset.contains(userName.getText()) && usernameValidity.getText().equals("Valid") && emailValidity.getText().equals("Valid") && dateOfBirth.getValue() != null && !idNumber.getText().isEmpty()) {
            userNameset.add(userName.getText());
            UserDetails user = new UserDetails(userName.getText(), firstName.getText(), lastName.getText(), civilStatus.getValue(), gender.getValue(), dateOfBirth.getValue().toString(), idNumber.getText(), contactNumber.getText(), eMail.getText());
            detailsList.add(user);
            submitValidator.setText("");
            Stage stage = (Stage) imgBack.getScene().getWindow();
            UpdateController.user = user;
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/UpdateForm.fxml"));
            stage.setScene(new Scene(root, 1200, 800));
        } else {
            submitValidator.setText("*ENTER REQUIRED DATA");
            submitValidator.setFill(Color.rgb(255, 0, 0));
        }
    }

    public void reset() {
        gender.setItems(null);
        civilStatus.setItems(null);
        dateOfBirth.setValue(null);
        set();
    }
}
