import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class MovieNodesReader {
    @SuppressWarnings("unchecked")
    public static JSONArray Read() {

        JSONParser jsonParser = new JSONParser();

        JSONArray movie = null;

        try (FileReader reader = new FileReader("Booking.json")) {

            Object obj = jsonParser.parse(reader);

            movie = (JSONArray) obj;

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return movie;
    }
}

