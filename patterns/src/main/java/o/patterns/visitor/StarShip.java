package o.patterns.visitor;

import java.util.Objects;

public class StarShip implements Visitable {
    private final String model;

    public StarShip(String model) {
        this.model = Objects.requireNonNull(model);
    }

    @Override
    public String toString() {
        return model;
    }

    @Override
    public String accept(Visitor v) {
        return v.visit(this);
    }
}
