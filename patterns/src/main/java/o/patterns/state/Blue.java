package o.patterns.state;

public class Blue implements State {

    private Saiyajin ctx;

    public Blue(Saiyajin context) {
        this.ctx = context;
    }

    @Override
    public void hit(int damage) {
        if (ctx.power() - damage > 30) {
            ctx.power(ctx.power() - damage);
            return;
        }
        ctx.power(ctx.power() + 8000);
        ctx.state(ctx.ultraInstinct());
    }

    @Override
    public String toString() {
        return "Blue";
    }
}
