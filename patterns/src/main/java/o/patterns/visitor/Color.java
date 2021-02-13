package o.patterns.visitor;

import java.util.Objects;

public class Color implements Visitable {
    private final String hex;
    public Color(String hexCode) {
        this.hex = Objects.requireNonNull(hexCode);
    }

    @Override
    public String toString() {
        return "#" + hex;
    }

    @Override
    public String accept(Visitor v) {
        return v.visit(this);
    }
}
