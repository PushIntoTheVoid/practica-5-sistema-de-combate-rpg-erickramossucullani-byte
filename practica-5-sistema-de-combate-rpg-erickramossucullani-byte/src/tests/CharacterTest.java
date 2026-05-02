package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import models.Character;

public class CharacterTest {

    private void assertPrivateField(Class<?> clazz, String fieldName, Class<?> type) throws Exception {
        Field field = clazz.getDeclaredField(fieldName);
        assertEquals(fieldName, field.getName());
        assertTrue(Modifier.isPrivate(field.getModifiers()), "The field " + fieldName + " should be private");
        assertEquals(type, field.getType());
    }

    private void assertMethodExists(Class<?> clazz, String methodName, Class<?>... params) throws Exception {
        Method method = clazz.getDeclaredMethod(methodName, params);
        assertNotNull(method, "The method " + methodName + " should exist in class " + clazz.getName());
    }

    @Test
    public void testNameField() throws Exception {
        assertPrivateField(Character.class, "name", String.class);
    }

    @Test
    public void testHealthField() throws Exception {
        assertPrivateField(Character.class, "health", int.class);
    }

    @Test
    public void testAttackPowerField() throws Exception {
        assertPrivateField(Character.class, "attackPower", int.class);
    }

    @Test
    public void testAttackMethodExists() throws Exception {
        assertMethodExists(Character.class, "attack");
    }

    @Test
    public void testGettersExist() throws Exception {
        assertMethodExists(Character.class, "getName");
        assertMethodExists(Character.class, "getHealth");
        assertMethodExists(Character.class, "getAttackPower");
    }

    @Test
    public void testConstructorAssignsValues() {
        Character c = new Character("Hero", 100, 50);
        assertEquals("Hero", c.getName());
        assertEquals(100, c.getHealth());
        assertEquals(50, c.getAttackPower());
    }

    @Test
    public void testValidatePositiveValueThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Character("Villain", -10, 20);
        });
        assertTrue(ex.getMessage().contains("Health"));

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> {
            new Character("Villain", 10, 0);
        });
        assertTrue(ex2.getMessage().contains("Attack power"));
    }
}
