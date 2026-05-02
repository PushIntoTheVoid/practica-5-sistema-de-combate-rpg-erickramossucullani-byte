package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testMainMethod() {
        try {
            Class.forName("App");
        } catch (ClassNotFoundException e) {
            fail("The App class does not exist");
        }
    }

    @Test
    public void testMainMethodExists() {
        try {
            Class<?> appClass = Class.forName("App");
            assertNotNull(appClass.getMethod("main", String[].class),
                    "The main method does not exist in the App class");
        } catch (Exception e) {
            fail("The main method threw an exception: " + e.getMessage());
        }
    }

    @Test
    public void testMainInstantiatesCharacters() {
        try {
            Class<?> appClass = Class.forName("App");
            appClass.getMethod("main", String[].class).invoke(null, (Object) new String[] {});
        } catch (Exception e) {
            fail("The main method threw an exception: " + e.getMessage());
        }
    }
}
