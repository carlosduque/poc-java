package o.patterns.visitor;

public interface Visitable {
    String accept(Visitor visitor);
}
