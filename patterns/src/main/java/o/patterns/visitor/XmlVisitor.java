package o.patterns.visitor;

public class XmlVisitor implements Visitor {
    @Override
    public String visit(StarShip s) {
        return "<starship>" + s.toString() + "</starship>";
    }

    @Override
    public String visit(Wizard a) {
        return "<wizard>" + "<name>" + a.toString() + "</name>" +
        "<guild>" + a.getGuild() + "</guild>" + "</wizard>";
    }

    @Override
    public String visit(Color c) {
        return "<color>" + c.toString() + "</color>";
    }
}
