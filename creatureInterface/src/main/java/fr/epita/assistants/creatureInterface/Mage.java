package fr.epita.assistants.creatureInterface;

import edu.emory.mathcs.backport.java.util.AbstractQueue;

import java.util.*;


public class Mage extends BaseHuman implements Magical, Speaker {
    boolean swimmingstate = false;
    int mana;
    private Set<Spell> list = new HashSet<>();

    /**
     * Constructor for the Creature class.
     *
     * @param name The name of the creature
     */
    public Mage(String name, int mana) {
        super(name);
        this.mana = mana;
    }

    @Override
    public void hello() {
        System.out.println("Hello, my name is " + getName() + " and I'm a Mage.");
    }

    @Override
    public void swim() {
        System.out.println("I'm a Mage and I'm swimming.");
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

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public Collection<Spell> getSpells() {
        return list;
    }

    @Override
    public void addSpell(Spell spell) {
        list.add(spell);
    }


    @Override
    public void castSpell(Spell spell) {
        if (list.contains(spell)) {
            if (mana >= spell.getManaCost()) {
                System.out.println(name + " casts " + spell.name()+".");
                mana -= spell.getManaCost();
            } else {
                System.out.println(name + " does not have enough mana.");
            }
        } else {
            System.out.println(name + " does not know " + spell.name()+".");
        }
    }

    @Override
    public void regenMana(int mana) {
        if (swimmingstate) {
            this.mana += (int) (mana * 0.9);
        }
        this.mana += mana;

    }

    public void greet(Speaker contact) {
        if (contact instanceof Mage) {
            System.out.println("I welcome you, " + contact.getName() + ".");
        } else if (contact instanceof Human) {
            System.out.println("Hello " + contact.getName() + ", how are you?");
        } else {
            super.greet(contact);
        }
    }
}



