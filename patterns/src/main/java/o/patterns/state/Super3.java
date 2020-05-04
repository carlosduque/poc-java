package o.patterns.state;

public class Super3 implements State {

    private Saiyajin ctx;

    public Super3(Saiyajin context) {
        this.ctx = context;
    }

    @Override
    public void hit(int damage) {
        ctx.power(ctx.power() - damage);
        if (ctx.power() < 30) {
            ctx.power(3000);
            ctx.state(ctx.blue());
        }
    }

    @Override
    public String toString() {
        return "Super3";
    }
}
