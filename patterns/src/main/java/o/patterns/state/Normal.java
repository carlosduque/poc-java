package o.patterns.state;

public class Normal implements State {

    final Saiyajin ctx;

    public Normal(Saiyajin context) {
        this.ctx = context;
    }

    @Override
    public void hit(int damage) {
        ctx.power(ctx.power() - damage);
        if (ctx.power() < 30) {
            ctx.power(1000);
            ctx.state(ctx.superOne());
        }
    }

    @Override
    public String toString() {
        return "Normal";
    }
}
