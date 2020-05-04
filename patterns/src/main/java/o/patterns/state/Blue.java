package o.patterns.state;

public class Blue implements State {

    private Saiyajin ctx;

    public Blue(Saiyajin context) {
        this.ctx = context;
    }

    @Override
    public void hit(int damage) {
        ctx.power(ctx.power() - damage);
        if (ctx.power() < 30) {
            ctx.power(5000);
            ctx.state(ctx.ultraInstinct());
        }
    }

    @Override
    public String toString() {
        return "Blue";
    }
}
