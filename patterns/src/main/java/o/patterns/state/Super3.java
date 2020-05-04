package o.patterns.state;

public class Super3 implements State {

    private Saiyajin ctx;

    public Super3(Saiyajin context) {
        this.ctx = context;
    }

    @Override
    public void hit(int damage) {
        if (ctx.power() - damage > 30) {
            ctx.power(ctx.power() - damage);
            return;
        }
        ctx.power(ctx.power() + 5000);
        ctx.state(ctx.blue());
    }

    @Override
    public String toString() {
        return "Super3";
    }
}
