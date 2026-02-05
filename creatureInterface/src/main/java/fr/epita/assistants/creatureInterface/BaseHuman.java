package fr.epita.assistants.creatureInterface;

public abstract class BaseHuman extends Creature implements Speaker, Swimmer{


    public BaseHuman(String name) {
        super(name);
    }

    public void greet(Speaker contact)
    {
        if(contact instanceof Human) {
            System.out.println("Hello " + contact.getName() + ", how are you?");
        }
        else
        {
            Speaker.super.greet(contact);
        }
    }


}
