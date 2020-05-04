package o.patterns.state;

public class Saiyajin {
    private State normal = new Normal(this);
    private State s1 = new Super(this);
    private State s2 = new Super2(this);
    private State s3 = new Super3(this);
    private State blue = new Blue(this);
    private State ultraInstinct = new UltraInstinct(this);

    private State state = normal;
    private final String name;
    private int power;

    public Saiyajin(String newName) {
        this.name = newName;
        this.power = 1000;
    }

    public String toString() {
        return name + "::" + state + "-> " + this.power;
    }

    public void hit(int damage) {
        System.out.println(this);
        this.state.hit(damage);
    }

    public int power() {
        return this.power;
    }

    public void power(int newPower) {
        this.power = newPower;
    }

    public void state(State newState) {
        this.state = newState;
    }

    public State normal() {
        return normal;
    }

    public State superOne() {
        return s1;
    }

    public State superTwo() {
        return s2;
    }

    public State superThree() {
        return s3;
    }

    public State blue() {
        return blue;
    }

    public State ultraInstinct() {
        return ultraInstinct;
    }
}
