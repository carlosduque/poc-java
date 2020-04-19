package o.patterns.visitor;

public class JsonVisitor implements Visitor {
    @Override
    public String visit(StarShip s) {
        return "{\"starship\": \"" + s.toString() + "\"}";
    }

    @Override
    public String visit(Wizard a) {
        return "{\"wizard\": {\"name\": \"" + a.toString() + "\"," +
                "\"guild\":\"" + a.getGuild() + "\"}}";
    }

    @Override
    public String visit(Color c) {
        return "{\"color\": \"" + c.toString() + "\"}";
    }
}
