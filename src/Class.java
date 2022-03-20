import java.util.Scanner;

// Superclass, used for inheritance

class Class {
    // Default fields
    public String race; // "Human", "Dwarf", "Elf"
    protected Integer[] hp;  // First -> Current hp, Second -> Max hp
    protected String zone; // "Melee", "Ranged"
    protected Integer[] failure; // First -> Chance, Second -> Duration [-10,1] means -10% hit chance. For permanent, use -1 as last value.

    // Effects
    protected Boolean stunned;
    protected Integer shield;
    
    public Class(String race, Integer[] hp, String zone, Integer[] failure)
    {
        // initial
        this.race = race;
        this.hp = hp;
        this.zone = zone;
        this.failure = failure;
        this.stunned = false;
        this.shield = 0;
       
        // apply race
        if (race == "Dwarf")
        {
            this.hp[1] = this.hp[1] + 10; 
        }

    }

    // Get Setters
    public void setHP(Integer hp)
    {
        this.hp[0] = hp;
    }

    public Integer getHP()
    {
        return this.hp[0];
    }

    public Integer getMaxHp()
    {
        return this.hp[1];
    }

    public void setZone(String zone)
    {
        this.zone = zone;
    }

    public String getZone()
    {
        return this.zone;
    }

    public void setFailure(Integer[] failure)
    {
        // if race == "Elf"?
        this.failure = failure;
    }

    public Integer[] getFailure()
    {
        return this.failure;
    }

    public void setStunned(Boolean stunned) // stun duration?
    {
        this.stunned = stunned;
    }

    public boolean getStunned()
    {
        return this.stunned;
    }

    public void setShielded(Integer shielded)
    {
        this.shield = shielded;
    }

    public Integer getShielded()
    {
        return this.shield;
    }

    // Methods
    // Display all abilities, get to choose one
    public void chooseAbilities(Class target)
    {
        System.out.println("");
    }
}

// Casters subclass
class SpellSlinger extends Class{
    
    public SpellSlinger(String race)
    {
        // Subclass maxHP = 80; starts in "Ranged" stance
        super(race, new Integer[]{80, 80}, "Ranged", new Integer[]{0, 0});
    }

    @Override
    public void chooseAbilities(Class target)
    {
        System.out.println("[1] fireball");
        System.out.println("[2] thunderbolt");
        System.out.println("[3] freeze");

        // Get input
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.close();

        // Switch
        switch (choice)
        {
            case 1:
                fireball(target);
                System.out.println("You cast fireball!");
                break;
            case 2:
                thunderbolt(target);
                System.out.println("You cast thunderbolt!");
                break;
            case 3:
                freeze(target);
                System.out.println("You cast freeze!");
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
    }
    
    public void fireball(Class target)
    {
        // TODO: Finish this method according to design
        Utils.dmgMove(this, target, 4, 6, -40, 1);
    }

    public void thunderbolt(Class target)
    {
        // TODO: Finish this method according to design
        Utils.dmgMove(this, target, 2, 8, -10, 1);
    }

    public void freeze(Class target)
    {
        // TODO: Finish this method according to design
        Utils.dmgMove(this, target, 1, 12, -20, 1, true);
    }
}

class Healer extends Class{
    
    public Healer(String race)
    {
        // Subclass maxHP = 80; starts in "Ranged" stance
        super(race, new Integer[]{80, 80}, "Ranged", new Integer[]{0, 0});
    }

    public void healingSong(Class target)
    {
        // TODO: Finish this method according to design
        Utils.healMove(target, 2, 8, -10, 1);
    }

    public void rejuvenate(Class target)
    {
        // TODO: Finish this method according to design
        Utils.healMove(target, 4, 6, -40, 1);
    }

    public void massHeal(Class[] targets)
    {
        // TODO: Finish this method according to design
        for(Class target : targets)
        {
            Utils.healMove(target, 1, 6, -20, 1);
        }
        
    }
}

// Wielders subclass
class Swordsman extends Class{

    public Swordsman(String race)
    {
        // Subclass maxHP = 100; starts in "Melee" stance
        super(race, new Integer[]{100, 100}, "Melee", new Integer[]{0, 0});
    }

    public void slash(Class target)
    {
        // TODO: Finish this method according to design
        Utils.dmgMove(this, target, 1, 12, -10, 1);
    }

    public void thrust(Class target)
    {
        // TODO: Finish this method according to design
        Utils.dmgMove(this, target, 2, 8, -20, 1);
    }

    public void guard() // Should stay in "Melee" stance; can only guard itself; lasts for duration of opponents turn
    {
        // TODO: Finish this method according to design
        setShielded(1);
    }
}

class GunSlinger extends Class{
    
    public boolean charged;

    public GunSlinger(String race)
    {
        // Subclass maxHP = 100; starts in "Ranged" stance
        super(race, new Integer[]{100, 100}, "Ranged", new Integer[]{0, 0});
    }

    public void shoot(Class target)
    {
        // TODO: Finish this method according to design
        Utils.dmgMove(this, target, 1, 12, -20, 1);
    }

    public void blast(Class target) // check added field!
    {
        // TODO: Finish this method according to design
        if(charged == true)
        {
            Utils.dmgMove(this, target, 4, 6, -20, 1);
            charged = false;
        }
        else
        {
            System.out.println("You need to charge the gun first!");
        }
    }

    public void chargeUp() // check added field!
    {
        // TODO: Finish this method according to design
        if(charged == false)
        {
            charged = true;
        }
    }
}

// Shielders
class Basher extends Class{

    public Basher(String race)
    {
        // Subclass maxHP = 120; starts in "Melee" stance
        super(race, new Integer[]{120, 120}, "Melee", new Integer[]{0, 0});
    }

    public void shieldBash(Class target)
    {
        // TODO: Finish this method according to design
        Utils.dmgMove(this, target, 2, 8, -10, 1);
    }

    public void shieldShove(Class target)
    {
        // TODO: Finish this method according to design
        Utils.dmgMove(this, target, 1, 8, -30, 1, true);
    }

    public void mace(Class target)
    {
        // TODO: Finish this method according to design
        Utils.dmgMove(this, target, 1, 12, -20, 1);
    }
}

class Aider extends Class{

    public Aider(String race)
    {
        // Subclass maxHP = 120; starts in "Meelee" stance
        super(race, new Integer[]{120, 120}, "Meelee", new Integer[]{0, 0});
    }

    public void magicShield(Class[] targets) // Can apply shield to target, should be weaker than guard?
    {
        // TODO: Finish this method according to design
        for(Class target : targets)
        {
            Utils.nonDmgMove(target, -40, 1, false, true);
        }
    }

    public void bind(Class[] targets) 
    {
        // TODO: Finish this method according to design
        for(Class target : targets)
        {
            Utils.nonDmgMove(target, -20, 1, true, false);
        }        
    }

    public void lifeAid(Class target)
    {
        // TODO: Finish this method according to design
        Utils.healMove(target, 2, 8, -10, 1);
    }
}
