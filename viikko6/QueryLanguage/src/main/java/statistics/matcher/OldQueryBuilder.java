package statistics.matcher;

import statistics.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class QueryBuilder {
    Matcher matcher;
    ArrayList<Matcher> matcherList;
    String preName = null;

    // TESTING
    private void createNew(Matcher m){
        this.matcher = m;
        this.matcherList.add(m);

    }

    private void createNewAnd(Matcher m) {
        this.matcher = new And(matcher, m);
        this.matcherList.add(m);
    }

    private void createNew(Matcher m, String preName) {
        if (preName.contains("all") || preName.contains("playsIn") || preName.contains("or")) {
            // System.out.print("---: ");
            createNew(m);
        } else {
            // System.out.print("And: ");
            createNewAnd(m);
        }

        // printThisMather(preName);
    }

    public QueryBuilder(){
        // this.matcher = new All();

        this.matcherList = new ArrayList<>();
        this.createNew(new All(), "all");
    }

    public Matcher build() {
        // DEBUG
        System.out.println("Build(" + matcherList.size() + ")");
        this.printNamesOfList(this.matcherList);

        Matcher paketoitu = packAnd();
        // Matcher[] paketoi = (Matcher[]) matcherList.toArray();
        // System.out.println(paketoi);
        // Matcher m = new And(paketoi);


        return paketoitu;
    }

    public QueryBuilder or(Matcher... matchers) {
        // this.matcher = new Or(matchers);
        this.createNew(new Or(matchers), "or");
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new And(matcher, new Or(matchers));
        return this;
    }

    public QueryBuilder playsIn(String team) {
        //this.matcher = new PlaysIn(team);
        this.createNew(new PlaysIn(team), "playsIn");
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        // this.matcher = new And(matcher, new HasAtLeast(value, category));
        this.createNew(new HasAtLeast(value, category), "hasAtLeast");
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        // this.matcher = new And(matcher, new HasFewerThan(value, category));
        // this.matcher = new And(matcher, new Not(new HasAtLeast(value, category)));
        this.createNew(new Not(new HasAtLeast(value, category)), "hasFewerThan");
        return this;
    }

    public QueryBuilder not() {
        // printThisMather("not");

        this.matcher = new And(matcher, new Not(matcher));
        return this;
    }

    // UGLY ?
    private Matcher packAnd() {
        Matcher[] matchers = new Matcher[this.matcherList.size() - 1];
        int index = 0;

        while (this.matcherList.size() > 1) {
            Matcher m = this.matcherList.remove(1);
            matchers[index++] = m;
        }

        return new And(matchers);
    }

    // DEBUG
    public void printThisMather(String curName) {
        System.out.println("In " + curName + ": " + preName); // .getClass().getSimpleName()
        this.preName = curName;
    }

    private void printNamesOfList(ArrayList<Matcher> arr) {
        for (Matcher m : arr) {
            System.out.println("    " + m.getClass().getSimpleName());
        }
    }
}
