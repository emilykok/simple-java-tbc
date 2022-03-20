// You dont need to import java files, just place them in the src folder!

//TODO:
// - Finish the methods in the "Class.java" file
// - Improvements to the way class works?

class Utils {
    // rolls amount of dice with n sides
    public static Integer diceRoll(Integer amount, Integer type) {
        Integer total = 0;
        for (int i = 0; i < amount; i++) {
            total += (int) (Math.random() * type) + 1; // It is +1 because the dice rolls from 1 to type, this works! 
        }
        return total;
    }

    //to check if attack hits
    public static boolean doesHit(Integer[] failure) {
        int hit = diceRoll(1, 100);
        if (hit <= failure[0]+100) {
            return true;
        }
        return false;
    }
    
    // dmg move - main
    public static void dmgMove(Class target, int diceAmount, int diceType, int failChance, int duration) {
        target.setFailure(new Integer[] {failChance,duration});
        if(target.getShielded() > 0){
            if(doesHit(target.getFailure()))
            {
                target.setHP(target.getHP() - diceRoll(diceAmount, diceType));
            }
        }
        else{
            target.setShielded(target.getShielded() - 1);
        }
    }

    // dmg move - stun
    public static void dmgMove(Class target, int diceAmount, int diceType, int failChance, int duration, boolean stun) {
        target.setFailure(new Integer[] {failChance,duration});
        if(target.getShielded() > 0){
            if(doesHit(target.getFailure()))
            {
                target.setHP(target.getHP() - diceRoll(diceAmount, diceType));
            }
        }
        if (stun == true && target.getStunned() == false) {
            target.setStunned(true);
        }
        else{
            target.setShielded(target.getShielded() - 1);
        }
    }


    
    // heal move
    public static void healMove(Class target, int diceAmount, int diceType, int failChance, int duration){
        target.setFailure(new Integer[] {failChance,duration});
        if(doesHit(target.getFailure()))
        {
            target.setHP(target.getHP() + diceRoll(diceAmount, diceType));
        }
    }

    // non-dmg move
    public static void nonDmgMove(Class target, int failChance, int duration, boolean stun, boolean shield) {
        target.setFailure(new Integer[] {failChance,duration});
        if(doesHit(target.getFailure()))
        {
            if(stun == true && target.getStunned() == false) {
                target.setStunned(true);
            }
            else{
                target.setShielded(target.getShielded() + 1);
            }
        }
    }

            
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
