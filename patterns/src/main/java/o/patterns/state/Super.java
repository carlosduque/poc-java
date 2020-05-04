package o.patterns.state;

public class Super implements State {

    private Saiyajin ctx;

    public Super(Saiyajin context) {
        this.ctx = context;
    }

    @Override
    public void hit(int damage) {
        ctx.power(ctx.power() - damage);
        if (ctx.power() < 30) {
            ctx.power(2000);
            ctx.state(ctx.superTwo());
        }
    }

    @Override
    public String toString() {
        return "Super";
    }
}
