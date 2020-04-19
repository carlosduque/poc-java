package o.patterns.visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorPattern {
    public static void main(String[] args) {
        List<Visitable> vs = new ArrayList<Visitable>(3);
        Color color = new Color("7FD9A5");
        StarShip starship = new StarShip("NSS9876");
        Wizard wizard = new Wizard("Tigg", Wizard.Guild.EARTH);

        vs.add(color);
        vs.add(starship);
        vs.add(wizard);

        System.out.println("========== XML");
        Visitor visitor = new XmlVisitor();
        for (Visitable v : vs)
            System.out.println(v.accept(visitor));

        System.out.println("========== JSON");
        visitor = new JsonVisitor();
        for (Visitable v : vs)
            System.out.println(v.accept(visitor));
    }
}
