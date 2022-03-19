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
        if (race == "Human")
        {
            this.failure = new Integer[]{-10, -1};   
        }
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
        this.failure = failure;
    }

    public Integer[] getFailure()
    {
        return this.failure;
    }

    public void setStunned(Boolean stunned)
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
}

// Casters subclass
class SpellSlinger extends Class{
    
    public SpellSlinger(String race)
    {
        // Subclass maxHP = 80; starts in "Ranged" stance
        super(race, new Integer[]{80, 80}, "Ranged", new Integer[]{0, 0});
    }

    public void fireball(Class target)
    {
        // TODO: Finish this method according to design
    }

    public void thunderbolt(Class target)
    {
        // TODO: Finish this method according to design
    }

    public void freeze(Class target)
    {
        // TODO: Finish this method according to design
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
    }

    public void rejuvenate(Class target)
    {
        // TODO: Finish this method according to design
    }

    public void massHeal(Class[] targets)
    {
        // TODO: Finish this method according to design
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
    }

    public void thrust(Class target)
    {
        // TODO: Finish this method according to design
    }

    public void guard() // Should stay in "Melee" stance; can only guard itself; lasts for duration of opponents turn
    {
        // TODO: Finish this method according to design
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
    }

    public void blast(Class target) // check added field!
    {
        // TODO: Finish this method according to design
    }

    public void chargeUp() // check added field!
    {
        // TODO: Finish this method according to design
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
    }

    public void shieldShove(Class target)
    {
        // TODO: Finish this method according to design
    }

    public void mace(Class target)
    {
        // TODO: Finish this method according to design
    }
}

class Aider extends Class{

    public Aider(String race)
    {
        // Subclass maxHP = 120; starts in "Ranged" stance
        super(race, new Integer[]{120, 120}, "Ranged", new Integer[]{0, 0});
    }

    public void magicShield(Class target) // Can apply shield to target, should be weaker than guard
    {
        // TODO: Finish this method according to design
    }

    public void bind(Class target) 
    {
        // TODO: Finish this method according to design
    }

    public void lifeAid(Class target)
    {
        // TODO: Finish this method according to design
    }
}
