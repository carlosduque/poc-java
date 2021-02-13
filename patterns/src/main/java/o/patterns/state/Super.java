package o.patterns.state;

public class Super implements State {

    private Saiyajin ctx;

    public Super(Saiyajin context) {
        this.ctx = context;
    }

    @Override
    public void hit(int damage) {
        if (ctx.power() - damage > 30) {
            ctx.power(ctx.power() - damage);
            return;
        }
        ctx.power(ctx.power() + 2000);
        ctx.state(ctx.superTwo());
    }

    @Override
    public String toString() {
        return "Super";
    }
}
