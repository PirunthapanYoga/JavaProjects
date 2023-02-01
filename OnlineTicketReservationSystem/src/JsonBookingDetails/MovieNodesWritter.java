package JsonBookingDetails;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class MovieNodesWritter {

    public static void write() {

        JSONObject movie1 = new JSONObject();
        movie1.put("Name", "Avengers Infinity War 2018");
        movie1.put("Trailer Path", "src/Media/InfinityWar.mp4");
        movie1.put("Image Path", "src/Images/InfinityWar.jpg");
        movie1.put("Text", "Avengers: Infinity War\n" +
                "\n" +
                "Avengers: Infinity War is a 2018 American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sequel to 2012's The Avengers and 2015's Avengers: Age of Ultron, and the nineteenth film in the Marvel Cinematic Universe (MCU). It was directed by Anthony and Joe Russo, written by Christopher Markus and Stephen McFeely, and features an ensemble cast including Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans, Scarlett Johansson, Benedict Cumberbatch, Don Cheadle, Tom Holland, Chadwick Boseman, Paul Bettany, Elizabeth Olsen, Anthony Mackie, Sebastian Stan, Danai Gurira, Letitia Wright, Dave Bautista, Zoe Saldana, Josh Brolin, and Chris Pratt. In the film, the Avengers and the Guardians of the Galaxy attempt to prevent Thanos from collecting the six all-powerful Infinity Stones as part of his quest to kill half of all life in the universe.\n" +
                "\n" +
                "The film was announced in October 2014 as Avengers: Infinity War – Part 1. The Russo brothers came on board to direct in April 2015, and a month later Markus and McFeely had signed on to write the script for the film, which draws inspiration from Jim Starlin's 1991 comic book The Infinity Gauntlet and Jonathan Hickman's 2013 comic book Infinity. In 2016, Marvel shortened the title to Avengers: Infinity War. Filming began in January 2017 at Pinewood Atlanta Studios in Fayette County, Georgia, with a large cast consisting mostly of actors reprising their roles from previous MCU films, including Brolin as Thanos. The production lasted until July 2017, shooting back-to-back with a direct sequel, Avengers: Endgame. Additional filming took place in Scotland, the Downtown Atlanta area, and New York City. With an estimated budget of $316–400 million, it is one of the most expensive films ever made.\n" +
                "\n" +
                "Avengers: Infinity War held its world premiere on April 23, 2018, in Los Angeles, and was released in the United States on April 27. Brolin's performance was praised, as was the emotional weight of the story, the visual effects, and action sequences, but the film was criticized for relying on previous MCU films for its story. It was the fourth film and the first superhero film to gross over $2 billion worldwide, breaking numerous box office records. It became the highest-grossing film of 2018 and the fourth-highest-grossing film of all time both worldwide and in the United States and Canada. The film's visual effects were nominated at the 91st Academy Awards, 24th Critics' Choice Awards, and 72nd British Academy Film Awards. The sequel, Avengers: Endgame, was released in April 2019.\n ");

        JSONObject movie2 = new JSONObject();
        movie2.put("Name", "Avengers End Game 2019");
        movie2.put("Trailer Path", "src/Media/EndGame.mp4");
        movie2.put("Image Path", "src/Images/EndGame.jpg");
        movie2.put("Text", "Avengers: Endgame\n" +
                "\n" +
                "Avengers: Endgame is a 2019 American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sequel to 2012's The Avengers, 2015's Avengers: Age of Ultron, and 2018's Avengers: Infinity War, and the twenty-second film in the Marvel Cinematic Universe (MCU). It was directed by Anthony and Joe Russo and written by Christopher Markus and Stephen McFeely, and features an ensemble cast including Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth, Scarlett Johansson, Jeremy Renner, Don Cheadle, Paul Rudd, Brie Larson, Karen Gillan, Danai Gurira, Benedict Wong, Jon Favreau, Bradley Cooper, Gwyneth Paltrow, and Josh Brolin. In the film, the surviving members of the Avengers and their allies attempt to reverse the damage caused by Thanos in Infinity War.\n" +
                "\n" +
                "The film was announced in October 2014 as Avengers: Infinity War – Part 2, but Marvel later removed this title. The Russo brothers joined as directors in April 2015, with Markus and McFeely signing on to write the script a month later. The film serves as a conclusion to the story of the MCU up to that point, ending the story arcs for several main characters. Filming began in August 2017 at Pinewood Atlanta Studios in Fayette County, Georgia, shooting back-to-back with Infinity War, and ended in January 2018. Additional filming took place in the Metro and Downtown Atlanta areas, New York, Scotland, and England. The story revisits several moments from earlier films, bringing back actors and settings from throughout the franchise as well as music from previous films. The official title was revealed in December 2018. With an estimated budget of $356 million, it is one of the most expensive films ever made.\n" +
                "\n" +
                "Avengers: Endgame was widely anticipated, and Disney backed the film with Marvel's largest marketing campaign. It premiered in Los Angeles on April 22, 2019, and was theatrically released in the United States on April 26. The film received praise for its direction, acting, musical score, action sequences, visual effects, and emotional weight, with critics lauding its culmination of the 22-film story. It grossed nearly $2.8 billion worldwide, surpassing Infinity War's entire theatrical run in just eleven days and breaking numerous box office records, including becoming the highest-grossing film of all time. The film received numerous awards and nominations, including three nominations at the 25th Critics' Choice Awards,[4] and a nomination for Special Visual Effects at the 73rd British Academy Film Awards.[5]\n");

        JSONObject movie3 = new JSONObject();
        movie3.put("Name", "Gemini Man");
        movie3.put("Trailer Path", "src/Media/GeminiMan.mp4");
        movie3.put("Image Path", "src/Images/GeminiMan.jpg");
        movie3.put("Text", "Gemini Man\n" +
                "\n" +
                "Gemini Man is a 2019 American action thriller film directed by Ang Lee and written by David Benioff, Billy Ray, and Darren Lemke. Starring Will Smith, Mary Elizabeth Winstead, Clive Owen, and Benedict Wong, the film follows a hitman who is targeted by a younger clone of himself while on the run from the government.\n" +
                "Originally conceived in 1997, the film went through development hell for nearly 20 years. Several directors, including Tony Scott, Curtis Hanson, and Joe Carnahan, were all attached at some point and numerous actors, including Harrison Ford, Mel Gibson, and Sean Connery, were set to star. In 2016, Skydance Media purchased the rights to the screenplay (which had been through several rewrites) from Disney and in October 2017, Ang Lee signed on to direct for Skydance with Paramount handling the distribution rights. Filming took place from February through May 2018.\n" +
                "Gemini Man premiered at the Zurich Film Festival on October 1, 2019 and was theatrically released in the United States by Paramount Pictures on October 11, 2019, in standard 2D, Dolby Cinema, and IMAX as well as in HFR (high frame rate) \"3D+\" on select screens (including 16 Dolby Cinema and 47 IMAX with Laser screens worldwide). Gemini Man received generally negative reviews from critics for its script and plot, although the performances were praised. The de-aging of Smith and the high frame-rate of 120 FPS also drew a mixed response, with some critics praising them as technical achievements, while others felt they were unconvincing. It has grossed $173 million against an estimated budget of $138 million with projected losses as high as $75 million.\n");


        JSONObject movie4 = new JSONObject();
        movie4.put("Name", "DoLittle");
        movie4.put("Trailer Path", "src/Media/DoLittle.mp4");
        movie4.put("Image Path", "src/Images/DoLittle.jpg");
        movie4.put("Text", "DoLittle\n" +
                "\n" +
                "Dolittle is an upcoming American fantasy adventure film directed by Stephen Gaghan, from a screenplay by Gaghan and a story by Thomas Shepherd. The film is based on the character Doctor Dolittle created by Hugh Lofting, and primarily based on The Voyages of Doctor Dolittle. Robert Downey Jr. stars as the title character, alongside Antonio Banderas and Michael Sheen in live action roles; the voice cast includes Emma Thompson, Rami Malek, John Cena, Kumail Nanjiani, Octavia Spencer, Tom Holland, Craig Robinson, Ralph Fiennes, Selena Gomez and Marion Cotillard.\n" +
                "\n" +
                "Dolittle is scheduled to be released in the United States on January 17, 2020.\n");

        JSONArray movieList = new JSONArray();
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        movieList.add(movie4);

        try (FileWriter file = new FileWriter("Booking.json")) {
            file.write(movieList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
