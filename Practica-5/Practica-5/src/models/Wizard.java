package models;

public class Wizard extends Character {
    public Wizard(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " (Wizard) casts a spell! Power: " + getAttackPower());
    }

}
