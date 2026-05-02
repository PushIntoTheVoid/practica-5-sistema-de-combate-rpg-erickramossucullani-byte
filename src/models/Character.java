package models;

public class Character {
    private String name;
    private int health;
    private int attackPower;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        validatePositiveValue(health, "Health");
        this.health = health;
        validatePositiveValue(attackPower, "Attack power");
        this.attackPower = attackPower;
    }

    
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getAttackPower() {
        return attackPower;
    }

    
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        validatePositiveValue(health, "Health");
        this.health = health;
    }
    public void setAttackPower(int attackPower) {
        validatePositiveValue(attackPower, "Attack power");
        this.attackPower = attackPower;
    }

    public void attack() {
        System.out.println(name + " attacks with power " + attackPower + "!");
    }
    private void validatePositiveValue(int value, String fieldName) {
        if (value <= 0) {
            throw new IllegalArgumentException(fieldName + " must be a positive value.");
        }
    }

    @Override
    public String toString() {
        return "Character{name='" + name + "', health=" + health + ", attackPower=" + attackPower + "}";
    }

    
}
