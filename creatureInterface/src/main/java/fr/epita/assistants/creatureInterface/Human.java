package fr.epita.assistants.creatureInterface;

public class Human extends BaseHuman {

    boolean swimmingstate = false;

    /**
     * Constructor for the Creature class.
     *
     * @param name The name of the creature
     */
    public Human(String name) {
        super(name);
    }

    @Override
    public void hello() {
        System.out.println("Hello, my name is " + getName() + " and I'm a Human.");
    }

    @Override
    public void swim() {
        System.out.println("I'm a Human and I'm swimming.");
        swimmingstate = true;
    }

    @Override
    public boolean getSwimmingState() {
        return swimmingstate;
    }

    @Override
    public void emerge() {
        swimmingstate = false;
    }

    public void greet(Speaker contact) {
        if (contact instanceof Human) {
            System.out.println("Hello " + contact.getName() + ", how are you?");
        } else {
            super.greet(contact);
        }
    }
}
