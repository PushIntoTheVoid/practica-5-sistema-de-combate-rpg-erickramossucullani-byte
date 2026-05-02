package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import models.Wizard;
import models.Character;

public class WizardTest {

    @Test
    public void testWizardInheritsFromCharacter() {
        Class<?> wizardClass = Wizard.class;
        Class<?> superClass = wizardClass.getSuperclass();

        assertEquals(Character.class, superClass, "Wizard should inherit from Character");
    }

    @Test
    public void testClassExists() {
        try {
            Class.forName("models.Wizard");
        } catch (ClassNotFoundException e) {
            fail("The Wizard class does not exist");
        }
    }

    @Test
    public void testConstructor() {
        Wizard wizard = new Wizard("Gandalf", 90, 50);
        assertEquals("Gandalf", wizard.getName());
        assertEquals(90, wizard.getHealth());
        assertEquals(50, wizard.getAttackPower());
    }

    @Test
    public void testAttackMethodOverride() throws Exception {
        Method superAttack = Character.class.getDeclaredMethod("attack");
        Method wizardAttack = Wizard.class.getDeclaredMethod("attack");

        assertEquals(superAttack.getName(), wizardAttack.getName());
        assertArrayEquals(superAttack.getParameterTypes(), wizardAttack.getParameterTypes());

        assertNotEquals(superAttack, wizardAttack, "Wizard should override the attack method");
    }

    @Test
    public void testWizardAttack() {
        Wizard wizard = new Wizard("Gandalf", 90, 50);
        wizard.attack();
    }
}
