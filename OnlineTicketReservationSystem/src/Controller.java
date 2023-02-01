import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public static JSONArray movieDetailsArray;
    public static MediaPlayer player;
    public static int counter = 0;
    private static String selectedDate;
    private static String selectedTime;
    public TextArea textScroll;
    public ImageView imageField;
    public MediaView mediaView;
    public Pane imagePane;
    public AnchorPane backPane;
    public String mediaPath;
    public String imagePath;
    public MovieLoader movie;
    public Pane play;
    public Pane pause;
    public Polygon prev;
    public Polygon next;
    public Text time;
    public Button time2;
    public Button tomorrow;
    public Button time1;
    public Button dayAfterTomorrow;
    public Button today;
    public Button reserveBtn;

    public static String getSelectedDate() {
        return selectedDate;
    }

    public static String getSelectedTime() {
        return selectedTime;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setConstrains();
        stop();

    }

    public void setConstrains() {
        movie = new MovieLoader();
        movieDetailsArray = MovieNodesReader.Read();
        movie.parseMovieObject((JSONObject) movieDetailsArray.get(counter));

        mediaPath = new File(movie.mediaPath).getAbsolutePath();
        player = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
        mediaView.setMediaPlayer(player);

        imagePath = new File(movie.imagPath).getAbsolutePath();
        imageField.setImage(new Image(new File(imagePath).toURI().toString()));

        textScroll.setText(movie.text);
        textScroll.autosize();

        next.setOpacity(0.4);
        prev.setOpacity(0.4);
        today.setText(LocalDate.now().toString());
        tomorrow.setText(LocalDate.now().plusDays(1).toString());
        dayAfterTomorrow.setText(LocalDate.now().plusDays(2).toString());

        time1.setDisable(true);
        time2.setDisable(true);
        resetDate(today);
        resetDate(tomorrow);
        resetDate(dayAfterTomorrow);
        resetDate(time1);
        resetDate(time2);

        today.setOnAction(e -> {
            selectedDate = today.getText();
            selectDate(today);
            tomorrowIsDisable();
            dayAfterTomorrowIsDisable();
        });

        tomorrow.setOnAction(e -> {
            selectedDate = tomorrow.getText();
            selectDate(tomorrow);
            todayIsDisable();
            dayAfterTomorrowIsDisable();
        });

        dayAfterTomorrow.setOnAction(e -> {
            selectedDate = dayAfterTomorrow.getText();
            selectDate(dayAfterTomorrow);
            todayIsDisable();
            tomorrowIsDisable();
        });

        time1.setOnAction(e -> {
            selectTime(time1);
            selectedTime = time1.getText();
        });

        time2.setOnAction(e -> {
            selectTime(time2);
            selectedTime = time2.getText();
        });
    }

    private void selectDate(Button e) {
        if (e.getBackground().equals(new Background(new BackgroundFill(Color.rgb(255, 0, 0, 1), CornerRadii.EMPTY, Insets.EMPTY)))) {
            e.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 1), CornerRadii.EMPTY, Insets.EMPTY)));
            resetTime();
        } else {
            e.setBackground(new Background(new BackgroundFill(Color.rgb(255, 0, 0, 1), CornerRadii.EMPTY, Insets.EMPTY)));
            try {
                getQueryTime();
            } catch (SQLException ignored) {
                System.out.println("Sql Exception");
            }
        }
    }

    private void selectTime(Button e) {
        if (e.getBackground().equals(new Background(new BackgroundFill(Color.rgb(255, 0, 0, 1), CornerRadii.EMPTY, Insets.EMPTY)))) {
            e.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 1), CornerRadii.EMPTY, Insets.EMPTY)));
            reserveBtn.setDisable(true);
        } else {
            e.setBackground(new Background(new BackgroundFill(Color.rgb(255, 0, 0, 1), CornerRadii.EMPTY, Insets.EMPTY)));
            reserveBtn.setDisable(false);
        }
        if (e.getId().equals("time1")) {
            time2IsDisable();
        } else {
            time1IsDisable();
        }
    }

    private void resetDate(Button e) {
        e.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 1), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private void resetTime() {

        time1.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 1), CornerRadii.EMPTY, Insets.EMPTY)));
        time2.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 1), CornerRadii.EMPTY, Insets.EMPTY)));
        time1.setDisable(true);
        time2.setDisable(true);
        reserveBtn.setDisable(true);

    }

    private void getQueryTime() throws SQLException {
        String query = String.format("SELECT TIME\nFROM MOVIE_DETAILS\nWHERE DATE = '%s' AND  MOVIE_NO IN     ( SELECT MOVIE_NO\nFROM MOVIES\nWHERE MOVIE_NAME='%s') ; ", selectedDate, movie.name);

        Statement st = SQL.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);

        int count = 0;
        while (rs.next()) {
            if (count == 0) {
                time1.setText(rs.getString(1).substring(0, 5));
                time1IsDisable();
                count++;
            } else if (count == 1) {
                time2.setText(rs.getString(1).substring(0, 5));
                time2IsDisable();
                count = 0;
            }

        }

    }

    private void time1IsDisable() {
        if (time1.isDisable()) {
            time1.setDisable(false);
        } else {
            time1.setDisable(true);
        }
    }

    private void time2IsDisable() {
        if (time2.isDisable()) {
            time2.setDisable(false);
        } else {
            time2.setDisable(true);
        }
    }

    public void todayIsDisable() {
        if (today.isDisable()) {
            today.setDisable(false);
        } else {
            today.setDisable(true);
        }
    }

    //  playback

    public void tomorrowIsDisable() {
        if (tomorrow.isDisable()) {
            tomorrow.setDisable(false);
        } else {
            tomorrow.setDisable(true);
        }
    }

    public void dayAfterTomorrowIsDisable() {
        if (dayAfterTomorrow.isDisable()) {
            dayAfterTomorrow.setDisable(false);
        } else {
            dayAfterTomorrow.setDisable(true);
        }
    }

    public void NextMovie() {
        if (counter < 3) {
            counter++;
        } else {
            counter = 0;
        }

        player.stop();
        stop();
        setConstrains();
        timeTextReset();
    }

    public void previousMovie() {
        if (counter != 0) {
            counter--;
        } else {
            counter = 3;
        }

        player.stop();
        stop();
        setConstrains();
        timeTextReset();
    }

    public void timeTextReset() {
        time1.setText("");
        time2.setText("");
    }

    public void stop() {
        reserveBtn.setDisable(true);
        play.setDisable(false);
        pause.setDisable(true);
        play.setOpacity(0);
        pause.setOpacity(0);
    }

    public void playTrailer() {
        player.play();
        play.setOpacity(0);
        pause.setDisable(false);
        play.setDisable(true);
        pause.setOpacity(0.5);
    }

    public void pauseTrailer() {
        player.pause();
        pause.setOpacity(0);
        play.setDisable(false);
        pause.setDisable(true);
        play.setOpacity(0.5);
    }

    public void playOpacityIncr() {
        play.setOpacity(1);
    }

    public void playOpacityDecr() {
        play.setOpacity(0);
    }

    public void pauseOpacityIncr() {
        pause.setOpacity(1);
    }

    public void pauseOpacityDecr() {
        pause.setOpacity(0);
    }

    public void prevOpaIncr() {
        prev.setOpacity(1);
    }

    public void prevOpaDecr() {
        prev.setOpacity(0.4);
    }

    //Reserve Scene

    public void nextOpaIncr() {
        next.setOpacity(1);
    }

    public void nextOpaDecr() {
        next.setOpacity(0.4);
    }

    public void reserve() throws IOException, SQLException {
        String str = String.format("SELECT *\nFROM BOOKINGS\nWHERE TAG_NO IN (  SELECT TAG_NO\nFROM MOVIE_DETAILS\nWHERE MOVIE_NO=%d AND TIME = '%s' AND DATE = '%s') ", counter + 1, selectedTime, selectedDate);

        Statement st = SQL.getConnection().createStatement();
        ResultSet rs = st.executeQuery(str);
        int col = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            for (int i = 2; i < col; i++) {
                if (!(rs.getString(i) == null)) {
                    SeatArrangement.booked.add(Integer.parseInt(rs.getMetaData().getColumnName(i).split("_")[1]));
                }
            }
        }

        Parent resRoot = FXMLLoader.load(Main.class.getResource("FXML/ResUI.fxml"));
        Stage s = (Stage) imageField.getScene().getWindow();
        s.close();
        Stage s2 = new Stage();
        s2.setTitle("Movie Name : " + movie.name);
        s2.setScene(new Scene(resRoot, 1200, 800));
        s2.show();
    }

}
