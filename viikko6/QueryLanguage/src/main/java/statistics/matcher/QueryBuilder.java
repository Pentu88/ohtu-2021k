package statistics.matcher;

public class QueryBuilder {
    private Matcher matcher;

    public QueryBuilder(){
        this.matcher = new All();
    }

    public Matcher build() {
    	Matcher palautettava = matcher;
    	matcher = new All();
    	
        return palautettava;
        //return this.matcher;
    }

    public QueryBuilder or(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new And(matcher, new Or(matchers));
        return this;
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        // this.matcher = new And(matcher, new HasFewerThan(value, category));
        this.matcher = new And(matcher, new Not(new HasAtLeast(value, category)));
        return this;
    }

    public QueryBuilder not() {
        this.matcher = new And(matcher, new Not(matcher));
        return this;
    }
}
