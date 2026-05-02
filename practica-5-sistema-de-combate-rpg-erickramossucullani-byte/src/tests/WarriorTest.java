package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import models.Warrior;
import models.Character;

public class WarriorTest {

    @Test
    public void testWarriorInheritsFromCharacter() {
        Class<?> warriorClass = Warrior.class;
        Class<?> superClass = warriorClass.getSuperclass();

        assertEquals(Character.class, superClass, "Warrior should inherit from Character");
    }

    @Test
    public void testClassExists() {
        try {
            Class.forName("models.Warrior");
        } catch (ClassNotFoundException e) {
            fail("The Warrior class does not exist");
        }
    }

    @Test
    public void testConstructor() {
        Warrior warrior = new Warrior("Aragorn", 100, 40);
        assertEquals("Aragorn", warrior.getName());
        assertEquals(100, warrior.getHealth());
        assertEquals(40, warrior.getAttackPower());
    }

    @Test
    public void testAttackMethodOverride() throws Exception {
        Method superAttack = Character.class.getDeclaredMethod("attack");
        Method warriorAttack = Warrior.class.getDeclaredMethod("attack");

        assertEquals(superAttack.getName(), warriorAttack.getName());
        assertArrayEquals(superAttack.getParameterTypes(), warriorAttack.getParameterTypes());

        assertNotEquals(superAttack, warriorAttack, "Warrior should override the attack method");
    }

    @Test
    public void testWarriorAttack() {
        Warrior warrior = new Warrior("Aragorn", 100, 40);
        warrior.attack();
    }
}
