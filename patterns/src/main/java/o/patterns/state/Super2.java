package o.patterns.state;

public class Super2 implements State {

    private Saiyajin ctx;

    public Super2(Saiyajin context) {
        this.ctx = context;
    }

    @Override
    public void hit(int damage) {
        if (ctx.power() - damage > 30) {
            ctx.power(ctx.power() - damage);
            return;
        }
        ctx.power(ctx.power() + 3000);
        ctx.state(ctx.superThree());
    }

    @Override
    public String toString() {
        return "Super2";
    }
}
