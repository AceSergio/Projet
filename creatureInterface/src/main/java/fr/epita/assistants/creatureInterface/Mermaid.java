package fr.epita.assistants.creatureInterface;

import java.util.*;

public class Mermaid extends Creature implements Speaker, Swimmer, Magical {
    boolean swimmingstate = false;
    int mana;
    private Set<Spell> list = new HashSet<>();

    /**
     * Constructor for the Creature class.
     *
     * @param humanPart The name of the creature
     */
    public Mermaid(BaseHuman humanPart, Fish fishPart) {
        super(humanPart.getName().substring(0, 1).toUpperCase() + humanPart.getName().substring(1).toLowerCase() + fishPart.getName().toLowerCase());
        if (humanPart instanceof Mage) {
            for (Spell s : ((Mage) humanPart).getSpells()) {
                if (s.getSpellType() == SpellType.WATER || s.getSpellType() == SpellType.NEUTRAL) {
                    this.list.add(s);
                } else {
                    System.out.println(this.name + " forgot the spell " + s.name() + ".");
                }
            }
        }

    }


    @Override
    public void hello() {
        System.out.println("Hello, my name is " + getName() + " and I'm a Mermaid.");
    }



    @Override
    public void swim() {
        System.out.println("I'm a Mermaid and I'm swimming.");
        swimmingstate = true;
    }

    @Override
    public boolean getSwimmingState() {
        return swimmingstate;
    }

    public void greet(Speaker contact) {
        if (contact instanceof Mermaid) {
            System.out.println("Dear " + contact.getName() + ", welcome.");
        } else {
            Speaker.super.greet(contact);
        }
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
        if (spell.getSpellType() == SpellType.FIRE) {
            System.out.println("Mermaid cannot learn FIRE spells.");
        } else {
            list.add(spell);
        }
    }

    @Override
    public void castSpell(Spell spell) {
        if (list.contains(spell)) {
            if (mana >= spell.getManaCost()) {
                System.out.println(name + " cast " + spell.name() + ".");
                if (swimmingstate && spell.getSpellType() == SpellType.WATER) {
                    mana -= (int) (spell.getManaCost() * 0.6);
                } else {
                    mana -= spell.getManaCost();
                }
            } else {
                System.out.println(name + " does not have enough mana.");
            }
        } else {
            System.out.println(name + " does not know " + spell.name() + ".");
        }
    }

    public void regenMana(int mana) {
        if (swimmingstate) {
            this.mana += (int) (mana * 0.3);
        }
        this.mana += mana;
    }


}
