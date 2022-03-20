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

    //to check if attack hits [non-dmg mov]
    public static boolean doesHit(Integer[] failure, Class own) {
        int hit = diceRoll(1, 100);
        if (own.race == "Human"){ // check own race
            failure[0] = failure[0] + 10;
        }

        if (hit <= failure[0]+100) {
            return true;
        }
        return false;
    }
    
    // to check if attack hits with target [dmg moves]
    public static boolean doesHit(Integer[] failure, Class own, Class target) {
        int hit = diceRoll(1, 100);
        if (target.race == "Human"){ // check own race
            failure[0] = failure[0] + 10;
        }

        if (target.race == "Elf"){ // check targets race
            failure[0] = failure[0] - 10;
        }

        if (hit <= failure[0]+100) {
            return true;
        }
        return false;
    }
    
    //// dmg move
    // main
    public static void dmgMove(Class own, Class target, int diceAmount, int diceType, int failChance, int duration) {
        target.setFailure(new Integer[] {failChance,duration});
        if(target.getShielded() > 0){
            if(doesHit(target.getFailure(), own, target))
            {
                target.setHP(target.getHP() - diceRoll(diceAmount, diceType));
            }
        }
        else{
            target.setShielded(target.getShielded() - 1);
        }
    }

    // +stun
    public static void dmgMove(Class own, Class target, int diceAmount, int diceType, int failChance, int duration, boolean stun) {
        target.setFailure(new Integer[] {failChance,duration});
        if(target.getShielded() > 0){
            if(doesHit(target.getFailure(), target))
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
        if(doesHit(target.getFailure(), target))
        {
            target.setHP(target.getHP() + diceRoll(diceAmount, diceType));
        }
    }

    // non-dmg move
    public static void nonDmgMove(Class target, int failChance, int duration, boolean stun, boolean shield) {
        target.setFailure(new Integer[] {failChance,duration});
        if(doesHit(target.getFailure(),target))
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
        System.out.println("Start game!");

        // player 1, chooses default characters
        Class[] player1 = new Class[3];
        player1[0] = new SpellSlinger("Dwarf");
        player1[1] = new Healer("Elf");
        player1[2] = new Swordsman("Human");

        // player 2, chooses default characters
        Class[] player2 = new Class[3];
        player2[0] = new Basher("Dwarf");
        player2[1] = new Aider("Elf");
        player2[2] = new GunSlinger("Human");

        Class target = player2[1];
        player1[0].chooseAbilities(target);
        System.out.print(target.getHP());
    }
}
