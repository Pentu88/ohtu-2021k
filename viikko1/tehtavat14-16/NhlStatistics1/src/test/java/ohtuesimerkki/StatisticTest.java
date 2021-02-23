package ohtuesimerkki;

import  static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatisticTest {
    Statistics stats;

    @Before
    public void setUp() {
        Player player1 = new Player("Patrik Laine", "CBJ", 6, 4);
        Player player2 = new Player("Connor McDavid", "EDM", 12, 25);
        Player player3 = new Player("Leon Draisaitl", "EDM", 10, 20);
        Player player4 = new Player("Mitchell Marner", "TOR", 9, 21);

        Reader reader = new PlayerReaderStub(player1, player2, player3, player4);

        stats = new Statistics(reader);
    }

    @Test
    public void hakuPalauttaaOikeanPelaajan(){
        assertEquals(stats.search("Patrik Laine").getName(), "Patrik Laine");
    }

    @Test
    public void hakuPalauttaaNullKunPelaajaaEiOle(){
        assertEquals(stats.search("Jaska Jokunen"), null);
    }

    @Test
    public void teamPalauttaaListanPelaajista(){
        assertEquals(stats.team("EDM").size(), 2);
    }

    @Test
    public void teamPalauttaaTyhjanListan(){
        assertEquals(stats.team("FLA").size(), 0);
    }

    @Test
    public void topScorerPalauttaaParhaan(){
        assertEquals(stats.topScorers(1).size(), 1);
    }
}

class PlayerReaderStub implements Reader{
    Player[] players;
    int mones;
    ArrayList<Player> outputs;

    public PlayerReaderStub(Player... players){
        this.players = players;
    }

    @Override
    public List<Player> getPlayers() {
        return new ArrayList<Player>(Arrays.asList(players));
    }

    public Player nextInt() {
        return players[mones++];
    }
}