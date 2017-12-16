import java.util.Random;

public class EnemyPokemon {

        Random rand = new Random();

         //In Battle Boolean\
        protected boolean inBattle = false;

        //Stats
        protected int exp = 0;
        protected int level = 1;

        protected int hp;
        protected int attack;
        protected int defense;
        protected int speed;
        protected String species;

        protected int hpBase = 0;
        protected int attackBase = 0;
        protected int defenseBase = 0;
        protected int speedBase = 0;


        // IV Stats (Innate Strengths)
        protected int hpIV;
        protected int attackIV;
        protected int defenseIV;
        protected int speedIV;

        //EV Stats
        protected int hpEV;
        protected int attackEV;
        protected int defenseEV;
        protected int speedEV;

        //Damage done
        protected int power;
        protected int damage;
        protected int userDefense;

        //Pokemon Object Creation
    public EnemyPokemon(int PokemonID, int enemyLevel){

        Random rand = new Random();

        hpIV = rand.nextInt(31) +1;
        attackIV = rand.nextInt(31) +1;
        defenseIV = rand.nextInt(31) +1;
        speedIV = rand.nextInt(31) +1;

        hpEV = 0;
        attackEV = 0;
        defenseEV = 0;
        speedEV = 0;

        exp = 0;

        level = enemyLevel;

        //Base Stats for each existing species
        if (PokemonID == 1) {
            species = "Bulbasuar";
            hpBase = 45;
            attackBase = 49;
            defenseBase = 49;
            speedBase = 45;
        }
        else if (PokemonID == 2) {
            species = "Ivysaur";
            hpBase = 60;
            attackBase = 62;
            defenseBase = 63;
            speedBase = 60;
        }
        else if (PokemonID == 3) {
            String species = "Venusaur";
            hpBase = 80;
            attackBase = 82;
            defenseBase = 83;
            speedBase = 80;
        }
        else {
            species = "Pikachu";
            hpBase = 35;
            attackBase = 55;
            defenseBase = 30;
            speedBase = 90;

        }
        hp = (int) (((((hpBase + hpIV)*2 + ((Math.sqrt(hpEV))/4))*level)/100) + level + 10);
        attack = (int) (((((attackBase + attackIV)*2 + ((Math.sqrt(attackEV))/4))*level)/100) +5);
        defense = (int) (((((defenseBase + defenseIV)*2 + ((Math.sqrt(defenseEV))/4))*level)/100) +5);
        speed  = (int) (((((speedBase + speedIV)*2 + ((Math.sqrt(speedEV))/4))*level)/100) +5);
        this.species = species;

        damage = ((((level * 2)/5) +2) * power * (attack/userDefense)/50) +2;

        int move1 = 0;
        int move2 = 0;
        int move3 = 0;
        int move4 = 0;

    }

        //Get and Set HP
    public int getHP() {return this.hp; }
    public void setHP(int newHP) { this.hp = newHP; }

    //Get and Set Attack
    public int getAttack(){
        return this.attack;
    }
    public void setAttack(int newAttack){
        this.attack = newAttack;
    }

    //Get and Set Defense
    public int getDefense(){
        return this.defense;
    }
    public void setDefense(int newDefense){
        this.defense = newDefense;
    }

    //Get and Set Speed
    public int getSpeed(){
        return this.speed;
    }
    public void setSpeed(int newSpeed){
        this.speed = newSpeed;
    }

    //Get and Set Species
    public String getSpecies(){
        return this.species;
    }
    public void setSpecies(String newSpecies){
        this.species = newSpecies;
    }

    //Set EVs Earned
    public void setHpEV(int earnedHpEV) { this.attackEV = attackEV  + earnedHpEV; }
    public void setAttackEV(int earnedAttackEV) { this.attackEV = attackEV  + earnedAttackEV; }
    public void setDefenseEV(int earnedDefenseEV) { this.attackEV = attackEV  + earnedDefenseEV; }
    public void setSpeedEV(int earnedSpeedEV) { this.attackEV = attackEV  + earnedSpeedEV; }

    //Get Damage
    public int getDamage() { return this.damage;}

    //Set inBattle
    public void setInBattle(boolean inBattle) {this.inBattle = true;}

    public void evolve(){

        setHP(hp + 20);
        setAttack(attack + 30);
        setDefense(defense + 30);
        setSpeed(speed + 20);

    }
}

