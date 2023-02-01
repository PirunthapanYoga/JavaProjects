import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.Set;
import java.util.TreeSet;

public class SeatArrangement {
    public static GridPane grid = new GridPane();
    public static Button[] seat = new Button[100];
    public static Set<Integer> booked = new TreeSet<>();
    static Button[] alphabet = new Button[11];
    static Button[] alphabet2 = new Button[11];

    public static void scene() {
        setGridProperty();
        setConstrains();
    }

    static void setGridProperty() {
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(15, 0, 0, 10));
        grid.setHgap(10);
        grid.setVgap(15);
    }

    static void setConstrains() {
        for (int i = 0; i < 100; i++) {
            seat[i] = new Button(String.valueOf(i + 1));
            seat[i].setStyle("-fx-min-width: 70px;" +
                    "-fx-min-height: 40px;" +
                    "-fx-font-size: 15;" +
                    "-fx-background-color: #E3E3E3;" +
                    "-fx-text-fill: #000000 ;");
        }

        for (int i = 0; i < 11; i++) {
            alphabet[i] = new Button();
            alphabet[i].setDisable(true);
            alphabet[i].setStyle("-fx-min-width: 70px;\n" +
                    "-fx-min-height: 40px;\n" +
                    "-fx-font-size: 15;\n" +
                    "-fx-text-fill: #000000;");
        }

        for (int i = 0; i < 11; i++) {
            alphabet2[i] = new Button();
            alphabet2[i].setDisable(true);
            alphabet2[i].setStyle("-fx-min-width: 70px;\n" +
                    "-fx-min-height: 40px;\n" +
                    "-fx-font-size: 15;\n" +
                    "-fx-text-fill: #000000;");
        }

        int i = 0;
        int a = 65;
        for (int row = 0; row < 13; row++) {
            int j = 1;
            if (!(row == 3 || row == 9)) {
                for (int column = 0; column < 13; column++) {
                    if (column != 6 && column != 0 && column != 12) {
                        int x = (12 * row) + column;
                        if (!(x == 5 || x == 7 || x == 49 || x == 59 || x == 121 || x == 122 || x == 130 || x == 131 || x == 133 || x == 143)) {
                            seat[i].setText(String.valueOf(j));
                            GridPane.setConstraints(seat[i], column, row);
                            grid.getChildren().add(seat[i]);
                            i++;
                            j++;
                        }
                    } else if (column == 0) {
                        alphabet[a - 65].setText(String.valueOf((char) a));
                        GridPane.setConstraints(alphabet[a - 65], 0, row);
                        grid.getChildren().add(alphabet[a - 65]);
                        alphabet2[a - 65].setText(String.valueOf((char) a));
                        GridPane.setConstraints(alphabet2[a - 65], 12, row);
                        grid.getChildren().add(alphabet2[a - 65]);
                        a++;
                    }
                }
            }
        }

        for (Integer l : booked) {
            seat[l].setStyle("-fx-min-width: 70px;" +
                    "-fx-min-height: 40px;" +
                    "-fx-font-size: 15;" +
                    "-fx-background-color: #BF0F0F;" +
                    "-fx-text-fill: #000000 ;");
            seat[l].setDisable(true);
        }
    }
}
