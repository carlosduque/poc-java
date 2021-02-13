package o.patterns.visitor;

public interface Visitor {
    String visit(StarShip s);
    String visit(Wizard a);
    String visit(Color c);
}
