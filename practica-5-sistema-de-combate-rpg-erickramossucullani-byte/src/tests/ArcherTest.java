package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import models.Archer;
import models.Character;

public class ArcherTest {

    @Test
    public void testArcherInheritsFromCharacter() {
        Class<?> archerClass = Archer.class;
        Class<?> superClass = archerClass.getSuperclass();

        assertEquals(Character.class, superClass, "Archer should inherit from Character");
    }

    @Test
    public void testClassExists() {
        try {
            Class.forName("models.Archer");
        } catch (ClassNotFoundException e) {
            fail("The Archer class does not exist");
        }
    }

    @Test
    public void testConstructor() {
        Archer archer = new Archer("Robin", 80, 30);
        assertEquals("Robin", archer.getName());
        assertEquals(80, archer.getHealth());
        assertEquals(30, archer.getAttackPower());
    }

    @Test
    public void testAttackMethodOverride() throws Exception {
        Method superAttack = Character.class.getDeclaredMethod("attack");
        Method archerAttack = Archer.class.getDeclaredMethod("attack");

        assertEquals(superAttack.getName(), archerAttack.getName());
        assertArrayEquals(superAttack.getParameterTypes(), archerAttack.getParameterTypes());

        assertNotEquals(superAttack, archerAttack, "Archer should override the attack method");
    }

    @Test
    public void testArcherAttack() {
        Archer archer = new Archer("Robin", 80, 30);
        archer.attack();
    }
}
