package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateController implements Initializable {
    public static UserDetails user;
    public static UserDetails updatedUser;
    public static int userIndex;
    public static ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
    private static ObservableList<String> civilStatusList = FXCollections.observableArrayList("Married", "Unmarried", "Divorced", "Widowed");
    public TextField dateOfBirth;
    public ComboBox<String> gender;
    public ImageView imgBack;
    public ComboBox<String> civilStatus;
    public Text emailValidity;
    public Text usernameValidity;
    public TextField contactNumber;
    public TextField eMail;
    public TextField firstName;
    public TextField userName;
    public TextField lastName;
    public TextField idNumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imgBack.setImage(new Image("/Images/user-group-icon.png"));
        setVal();
        gender.setItems(genderList);
        civilStatus.setItems(civilStatusList);
    }

    public void setVal() {
        userName.setText(user.getUserName());
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        civilStatus.setValue(user.getCivilStatus());
        gender.setValue(user.getGender());
        dateOfBirth.setText(user.getDateOfBirth());
        idNumber.setText(user.getID());
        contactNumber.setText(user.getContactNumber());
        eMail.setText(user.geteMail());
        updatedUser = user;
    }

    public void update() {
        updatedUser.setFirstName(firstName.getText());
        updatedUser.setLastName(lastName.getText());
        updatedUser.setGender(gender.getValue());
        updatedUser.setCivilStatus(civilStatus.getValue());
        updatedUser.setContactNumber(contactNumber.getText());
        RegistrationPageController.detailsList.remove(user);
        RegistrationPageController.detailsList.add(updatedUser);
        user = updatedUser;
        setVal();
    }
}
