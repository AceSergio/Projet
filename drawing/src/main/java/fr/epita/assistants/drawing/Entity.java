package fr.epita.assistants.drawing;

public abstract class Entity implements Drawable {
    private static long SEQUENCE = 0;
    private final long id;

    protected Entity() {
        this.id = SEQUENCE++;
    }

    public long getId() {
        return id;
    }
}

