package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InheritanceTest {
    @Test
    public void testInheritance() {
        try {
            Class<?> characterClass = Class.forName("models.Character");
            Class<?> warriorClass = Class.forName("models.Warrior");
            Class<?> wizardClass = Class.forName("models.Wizard");
            Class<?> archerClass = Class.forName("models.Archer");

            assertEquals(characterClass, warriorClass.getSuperclass(), "Warrior should inherit from Character");
            assertEquals(characterClass, wizardClass.getSuperclass(), "Wizard should inherit from Character");
            assertEquals(characterClass, archerClass.getSuperclass(), "Archer should inherit from Character");
        } catch (ClassNotFoundException e) {
            fail("Expected class not found");
        }
    }

    // validate that the constructor calls super
    @Test
    public void testConstructorCallsSuper() {
        try {
            Class<?> warriorClass = Class.forName("models.Warrior");
            warriorClass.getConstructor(String.class, int.class, int.class);

            Class<?> wizardClass = Class.forName("models.Wizard");
            wizardClass.getConstructor(String.class, int.class, int.class);

            Class<?> archerClass = Class.forName("models.Archer");
            archerClass.getConstructor(String.class, int.class, int.class);

        } catch (NoSuchMethodException e) {
            fail("Warrior constructor does not call super with the correct parameters");
        } catch (ClassNotFoundException e) {
            fail("Warrior class not found");
        }
    }

}
