// You dont need to import java files, just place them in the src folder!

//TODO:
// - Finish the methods in the "Class.java" file
// - Add a doesHit() method
// - Improvements to the way class works?

class Utils {
    public static int diceRoll(int amount, int type) {
        int total = 0;
        for (int i = 0; i < amount; i++) {
            total += (int) (Math.random() * type) + 1; // It is +1 because the dice rolls from 1 to type, this works! 
        }
        return total;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
