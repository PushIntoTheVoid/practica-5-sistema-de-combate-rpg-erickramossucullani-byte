import models.*;

public class App {
    public static void main(String[] args) {
        System.out.println("=== FASE 1: CLASES INDEPENDIENTES ===");
        
        models.Warrior w1 = new models.Warrior("Thor", 100, 20);
        models.Wizard wz1 = new models.Wizard("Merlin", 80, 25);
        models.Archer a1 = new models.Archer("Legolas", 90, 18);

        w1.attack();
        wz1.attack();
        a1.attack();

        
        System.out.println("=== FASE 2 : HERENCIA  ===");

        Warrior warrior = new Warrior("Thor", 100, 20);
        Wizard wizard   = new Wizard("Merlin", 80, 25);
        Archer archer   = new Archer("Legolas", 90, 18);

        warrior.attack();
        wizard.attack();
        archer.attack();

        
        System.out.println("=== FASE 3: POLIMORFISMO ===");

        
        models.Character c = new Warrior("Ares", 120, 30);
        c.attack(); 
              
    }
}