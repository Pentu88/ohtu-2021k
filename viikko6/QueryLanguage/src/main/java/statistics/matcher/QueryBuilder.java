package statistics.matcher;

public class QueryBuilder {
    private Matcher matcher;
    String preName = null;

    public QueryBuilder(){
        this.matcher = new All();
        preName = "All";
    }

    public Matcher build() {
    	Matcher palautettava = matcher;
    	matcher = new All();
    	
        return palautettava;
    }

    public QueryBuilder or(Matcher... matchers) {
        printThisMather("or");
        // System.out.println("In Or: " + matcher.getClass().getSimpleName());

        this.matcher = new Or(matchers);
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new And(matcher, new Or(matchers));
        return this;
    }

    public QueryBuilder playsIn(String team) {
        // printThisMather("playsIn");

        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        // printThisMather("hasAtLeast");

        this.matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        // printThisMather("hasFewerThan");

        // this.matcher = new And(matcher, new HasFewerThan(value, category));
        this.matcher = new And(matcher, new Not(new HasAtLeast(value, category)));
        return this;
    }

    public QueryBuilder not() {
        // printThisMather("not");

        this.matcher = new And(matcher, new Not(matcher));
        return this;
    }

    // DEBUG
    public void printThisMather(String curName) {
        System.out.println("In " + curName + ": " + preName); // .getClass().getSimpleName()
        this.preName = curName;
    }
}
