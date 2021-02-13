package o.patterns.state;

public class UltraInstinct implements State {

    private Saiyajin ctx;

    public UltraInstinct(Saiyajin context) {
        this.ctx = context;
    }

    @Override
    public void hit(int damage) {
        if (ctx.power() - damage > 30) {
            ctx.power(ctx.power() - damage);
            return;
        }
        ctx.power(1);
        ctx.state(ctx.normal());
    }

    @Override
    public String toString() {
        return "UltraInstinct";
    }
}
