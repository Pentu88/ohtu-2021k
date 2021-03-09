
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String nationality;
    private String team;
    private int goals;
    private int assists;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Lisätään ominaisuuksia
    public void setNationality(String nationality){ this.nationality = nationality;}

    public String getNationality(){ return this.nationality;}

    public void setTeam(String team){ this.team = team;}

    public String getTeam(){ return this.team;}

    public void setGoals(int goals){ this.goals = goals;}

    public int getGoals(){ return this.goals;}

    public void setAssists(int assists){ this.assists = assists;}

    public int getAssists(){ return this.assists;}

    public  int getPoints() { return  this.goals + this.assists;}
    //

    @Override
    public String toString() {
        return this.name2s() + team + stats2s(goals) + "+" + stats2s(assists) + "=" + stats2s(this.getPoints());
    }

    // This is so ugly
    private String name2s() {
        int n = 25 - name.length();
        String output = name;

        for (int i = 0; i < n; i++) {
            output += " ";
        }
        return output;
    }

    // This is so ugly
    private String stats2s(int nro) {
        String output = " ";
        if (nro < 10) {
            output += " ";
        } /* else if(nro < 100){
            output += " ";
        } */

        return output + nro + " ";
    }

    public int compareTo(Player p) {
        return p.getPoints() - this.getPoints();
    }
}
