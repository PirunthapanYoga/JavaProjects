import org.json.simple.JSONObject;

public class MovieLoader {
    String name;
    String imagPath;
    String mediaPath;
    String text;

    public void parseMovieObject(JSONObject movie) {
        this.name = (String) movie.get("Name");
        this.imagPath = (String) movie.get("Image Path");
        this.mediaPath = (String) movie.get("Trailer Path");
        this.text = (String) movie.get("Text");
    }
}
