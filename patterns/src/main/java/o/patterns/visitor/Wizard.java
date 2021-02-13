package o.patterns.visitor;

import java.util.Objects;

public class Wizard implements Visitable {
    public enum Guild {
        EARTH,
        FIRE,
        WIND,
        WATER;
    }

    private final String name;
    private final Guild guild;
    public Wizard(String name, Guild guild) {
        this.name = Objects.requireNonNull(name);
        this.guild = guild;
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }

    public Guild getGuild() {
        return this.guild;
    }

    @Override
    public String accept(Visitor v) {
        return v.visit(this);
    }
}
