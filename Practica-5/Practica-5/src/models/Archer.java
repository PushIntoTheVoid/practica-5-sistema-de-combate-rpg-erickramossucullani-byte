package models;

public class Archer extends Character {
    public Archer(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " (Archer) attacks with a bow and arrow! Power: " + getAttackPower());
    }
    

}
