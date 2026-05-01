package models;

public class Warrior extends Character {
    public Warrior(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " (Warrior) attacks with a sword! Power: " + getAttackPower());
    }
    

}
