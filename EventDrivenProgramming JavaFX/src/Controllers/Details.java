package Controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Details {

    private List<UserDetails> list;

    public Details(List<UserDetails> list) {
        this.list = list;
    }

    public void write() {

        JSONArray details = new JSONArray();

        list.forEach(e -> {
            JSONObject data = new JSONObject();
            data.put("User Name ", e.getUserName());
            data.put("First Name ", e.getFirstName());
            data.put("Last Name ", e.getLastName());
            data.put("Civil Status ", e.getCivilStatus());
            data.put("Gender ", e.getGender());
            data.put("Date OF Birth ", e.getDateOfBirth());
            data.put("ID Number ", e.getID());
            data.put("Contact Number", e.getContactNumber());
            data.put("Email", e.geteMail());
            details.add(data);
        });

        try (FileWriter file = new FileWriter("Booking.json")) {
            file.write(details.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
