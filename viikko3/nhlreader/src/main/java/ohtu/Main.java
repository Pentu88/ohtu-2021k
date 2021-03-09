package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;

import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        // System.out.println("json-muotoinen data:");
        // System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        Arrays.sort(players);
        System.out.println("Oliot:");
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                System.out.println(player);
            }
        }

        // System.out.print("(" + players[0].getNationality().getClass().getSimpleName() + ") " + players[0].getNationality() + " - " );
        // System.out.println(players[0].getNationality().equals("CAN"));
        // System.out.println("Pisin pelaajan nimi = " + maxName); // 25
    }

}
