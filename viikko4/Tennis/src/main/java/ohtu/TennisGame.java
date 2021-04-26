package ohtu;

public class TennisGame {
    private String[] point2String;
    private Player[] playerss;

    public TennisGame(String player1Name, String player2Name) {
        this.point2String = new String[]{"Love", "Fifteen", "Thirty", "Forty", ""};
        this.playerss = new Player[]{new Player(player1Name), new Player(player2Name)};
    }

    public void wonPoint(String playerName) {
        if (playerss[0].getName().contains(playerName)) {
            playerss[0].addScore();
        } else {
            playerss[1].addScore();
        }
    }

    public String getScore() {
        int m_score1 = playerss[0].getScore();
        int m_score2 = playerss[1].getScore();

        if (m_score1>=4 || m_score2>=4) {
            return m_score1 == m_score2 ? "Deuce" : ((Math.abs(m_score1 - m_score2) == 1? "Advantage " : "Win for ") + (m_score1 > m_score2 ? "player1" : "player2"));
        }

        return this.point2String[m_score1] + "-" + (m_score1 == m_score2 ? "All" : this.point2String[m_score2]);
    }
}