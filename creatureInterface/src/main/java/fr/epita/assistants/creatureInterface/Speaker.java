package fr.epita.assistants.creatureInterface;

import java.util.List;

/**
 * This interface provides communication methods for the objects of the class
 * that implements it. Classes adopting this interface instantiate objects
 * capable of communication.
 */
public interface Speaker {
    /**
     * Returns the name of the object that can speak
     */
    String getName();

    /**
     * Prints "Hello, my name is {creatureName} and I'm a {creatureClassName}."
     */
    void hello();

    /**
     * Greets the contact
     * The default implementation greets the contact based on its type
     *
     * @param contact the creature to greet
     */
    default void greet(Speaker contact) {
        if (contact instanceof Mage) {
            System.out.println("Salutations " + contact.getName() + ", keeper of Arcane secrets.");
        }
        if (contact instanceof Human) {
            System.out.println("Salutations " + contact.getName() + " the human.");
        }
        if (contact instanceof Mermaid)
        {
            System.out.println("Salutations " + contact.getName() + ", keeper of the Seas.");

        }

    }


    /**
     * Allows all speakers in the collection to say hello as explained in the hello() method
     *
     * @param speakers the list of creatures that can speak
     */
    static void helloAll(List<Speaker> speakers) {
        for (Speaker n : speakers) {
            n.hello();
        }
    }
}
