import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ControllerRes implements Initializable {
    public static Button[] seat;
    public static Set<Integer> reservation = new TreeSet<>();
    public static Set<Integer> totalBooked = new TreeSet<>();
    public static GridPane seatArrangement;
    public Pane seatPan;
    public Text seatsTotal;
    public Text seatSet1;
    public Text seatSet2;
    public Text subTotal;
    public Button checkOut;
    public Button reset;
    public Text time;
    public Text date;

    public static void againBook() {
        seatArrangement.setDisable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        seatArrangement = SeatArrangement.grid;
        seatPan.getChildren().add(seatArrangement);
        seat = SeatArrangement.seat;
        SeatArrangement.scene();
        time.setText(Controller.getSelectedTime());
        date.setText(Controller.getSelectedDate());

        IntStream.range(0, 100).forEach(i -> seat[i].setOnAction(l -> {
            seat[i].setStyle("-fx-min-width: 70px;" +
                    "-fx-min-height: 40px;" +
                    "-fx-font-size: 15;" +
                    "-fx-background-color: #00FF00;" +
                    "-fx-text-fill: #000000 ;");
            reservation.add(i);
        }));
    }

    public void finalBooking() throws IOException, SQLException {
        System.out.println(reservation);
        AtomicInteger odc = new AtomicInteger();
        AtomicInteger balcony = new AtomicInteger();
        seatsTotal.setText(String.valueOf(reservation.size()));
        reservation.forEach(i -> {
            seat[i].setDisable(true);
            seat[i].setStyle("-fx-min-width: 70px;" +
                    "-fx-min-height: 40px;" +
                    "-fx-font-size: 15;" +
                    "-fx-background-color: #FF0000;" +
                    "-fx-text-fill: #000000 ;");
            try {
                setSeat(i);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (i < 76) {
                odc.getAndIncrement();
            } else if (i > 76) {
                balcony.getAndIncrement();
            }
        });


        totalBooked.forEach(e -> seat[e].setDisable(true));

        seatSet1.setText(odc.toString());
        seatSet2.setText(balcony.toString());
        subTotal.setText(String.valueOf((odc.get() * 450) + balcony.get() * 750));
        checkOut.setDisable(true);
        reset.setDisable(true);
        seatArrangement.setDisable(true);
        popup();
    }

    public void setSeat(int seatNo) throws SQLException {
        String str = "UPDATE BOOKINGS\n" +
                "SET S_" + seatNo + " = 'B'\n" +
                "WHERE TAG_NO IN (SELECT TAG_NO\n" +
                "FROM MOVIE_DETAILS\n" +
                "WHERE MOVIE_NO=" + (Controller.counter + 1) + " AND TIME = '" + time.getText() + "' AND DATE = '" + date.getText() + "')  ";

        Statement st = SQL.getConnection().createStatement();
        st.executeUpdate(str);
    }

    public void reset() {
        reservation.forEach(i -> seat[i].setStyle("-fx-min-width: 70px;" +
                "-fx-min-height: 40px;" +
                "-fx-font-size: 15;" +
                "-fx-background-color: #F0F0F0;" +
                "-fx-text-fill: #000000 ;"));
        reservation.clear();
    }

    public void popup() throws IOException {
        Stage s = new Stage();
        Parent rootPopUp = FXMLLoader.load(getClass().getResource("FXML/CloseOnRequest.fxml"));
        s.setScene(new Scene(rootPopUp));
        s.show();
        s.centerOnScreen();
        CloseOnRequestController.reserve = checkOut;
    }
}
