package o.patterns.state;

public class Super2 implements State {

    private Saiyajin ctx;

    public Super2(Saiyajin context) {
        this.ctx = context;
    }

    @Override
    public void hit(int damage) {
        ctx.power(ctx.power() - damage);
        if (ctx.power() < 30) {
            ctx.power(3000);
            ctx.state(ctx.superThree());
        }
    }

    @Override
    public String toString() {
        return "Super2";
    }
}
