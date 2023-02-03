package Controllers;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class DetailsLoader {

    public static JSONArray Read() {

        JSONParser jsonParser = new JSONParser();

        JSONArray details = null;

        try (FileReader reader = new FileReader("Booking.json")) {

            Object obj = jsonParser.parse(reader);

            details = (JSONArray) obj;

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return details;
    }

}
