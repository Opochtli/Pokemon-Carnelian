import java.util.Random;
import java.util.*;

public class Pokemon {

    Random rand = new Random();


    protected int exp = 0;

    protected int earnedExp ;

    protected int level = 0;

    //Stats
    protected int hp;
    protected int maxhp;
    protected int attack;
    protected int defense;
    protected int speed;
    protected String species;

    protected int catchRate;

    //Base Stats
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

    //Moves
    Move move1;
    Move move2;
    Move move3;
    Move move4;

    //Enums
    protected Type type;
    protected StatusCondition statusCondition;
    //protected Enums.item item;
    //protected Enums.statusCondition statusCondition;

    //Pokemon Object Creation
    public Pokemon(int PokemonID, int pokemonInitialLevel){

        Random rand = new Random();

        statusCondition = StatusCondition.NORMAL;

        hpIV = rand.nextInt(31) +1;
        attackIV = rand.nextInt(31) +1;
        defenseIV = rand.nextInt(31) +1;
        speedIV = rand.nextInt(31) +1;

        hpEV = 0;
        attackEV = 0;
        defenseEV = 0;
        speedEV = 0;

        exp = 0;

        level = pokemonInitialLevel;
        //level =((6/5)*(exp ^ 3)) - ((15)*(exp ^ 2)) + ((100)*(exp)) -140;

        move1 = new Move("Tackle", 90,25,25,25, Type.NORMAL);
        move2 = new Move("Bite",100,30,25,25,Type.DARK);
        move3 = new Move("Fire Blast",100,150,5,5,Type.FIRE);
        move4 = new Move("Splash",100,0,25,25,Type.WATER);

        List<Move> moveSet = new ArrayList<Move>(4);

        moveSet.add(0,move1);
        moveSet.add(1,move2);
        moveSet.add(2,move3);
        moveSet.add(3,move4);

        //Base Stats for each existing species (Move to own class later)
        if (PokemonID == 1) {
            species = "Bulbasuar";
            hpBase = 45;
            attackBase = 49;
            defenseBase = 49;
            speedBase = 45;
            earnedExp = 64;
            type = Type.GRASS;
            catchRate = 45;
            }

        else if (PokemonID == 2) {
            species = "Ivysaur";
            hpBase = 60;
            attackBase = 62;
            defenseBase = 63;
            speedBase = 60;
            earnedExp = 141;
            type = Type.GRASS;
            catchRate = 45;
        }

        else if (PokemonID == 3) {
            species = "Venusaur";
            hpBase = 80;
            attackBase = 82;
            defenseBase = 83;
            speedBase = 80;
            earnedExp = 208;
            type = Type.GRASS;
            catchRate = 45;
        }

        else if (PokemonID == 4) {
            species = "Charmander";
            hpBase = 39;
            attackBase = 52;
            defenseBase = 43;
            speedBase = 65;
            earnedExp = 65;
            type = Type.FIRE;
            catchRate = 45;
        }

        else if (PokemonID == 5) {
            species = "Charmeleon";
            hpBase = 58;
            attackBase = 64;
            defenseBase = 58;
            speedBase = 80;
            earnedExp = 142;
            type = Type.FIRE;
            catchRate = 45;
        }

        else if (PokemonID == 6) {
            species = "Charizard";
            hpBase = 78;
            attackBase = 84;
            defenseBase = 78;
            speedBase = 100;
            earnedExp = 209;
            type = Type.FIRE;
            catchRate = 45;
        }

        else if (PokemonID == 7) {
            species = "Squirtle";
            hpBase = 44;
            attackBase = 48;
            defenseBase = 65;
            speedBase = 43;
            earnedExp = 66;
            type = Type.WATER;
            catchRate = 45;
        }

        else {
            species = "Pikachu";
            hpBase = 35;
            attackBase = 55;
            defenseBase = 30;
            speedBase = 90;
            earnedExp = 82;
            type = Type.ELECTRIC;
            catchRate = 190;
        }

        hp = (int) (((((hpBase + hpIV)*2 + ((Math.sqrt(hpEV))/4))*level)/100) + level + 10);
        maxhp = (int) (((((hpBase + hpIV)*2 + ((Math.sqrt(hpEV))/4))*level)/100) + level + 10);
        attack = (int) (((((attackBase + attackIV)*2 + ((Math.sqrt(attackEV))/4))*level)/100) +5);
        defense = (int) (((((defenseBase + defenseIV)*2 + ((Math.sqrt(defenseEV))/4))*level)/100) +5);
        speed  = (int) (((((speedBase + speedIV)*2 + ((Math.sqrt(speedEV))/4))*level)/100) +5);

    }

    //Get and Set Exp
    public int getExp() {return this.exp; }
    public void setExp(int newExp) { this.exp = newExp; }

    //Get Earned Exp
    public int getEarnedExp() {return this.earnedExp; }

    //Get Type (enum)
    public Type getType() {return this.type; }

    //Give Exp for defeat
    public int giveExp(double wild, int baseEXPYield, double luckyEgg, int trainerPokemonLevel, int numPokemon){
        int exp =  (int) (wild * baseEXPYield * luckyEgg * trainerPokemonLevel) / (7 * numPokemon);
        return exp;
    }

    //Get Level
    public int getLevel() {return this.level; }

    //Get and Set HP
    public int getHP() {return this.hp; }
    public void setHP(int newHP) { this.hp = newHP; }

    //Get Max HP
    public int getMaxHP() {return this.maxhp; }

    //Get and Set Attack
    public int getAttack(){
        return this.attack;
    }
    public void setAttack(int newAttack){
        this.attack = newAttack;
    }

    //Get and Set Defense
    public int getDefense(){ return this.defense; }
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

    //Get and Set Moves
    public Move getMove1() { return this.move1; }
    //public void setMove1() {this.move1 = Move()} //Need help here
    public Move getMove2() { return this.move2; }
    //public void setMove1(Move()) {this.move1 = Move)()} //NEED HELP HERE
    public Move getMove3() { return this.move3; }
    //public void setMove1(Move()) {this.move1 = Move)()} //NEED HELP HERE
    public Move getMove4() { return this.move4; }
    //public void setMove1(Move()) {this.move1 = Move)()} //NEED HELP HERE

    //Get Catch Rate
    public int getCatchRate() {return this.catchRate; }

    //Get and Set Status Condition
    public StatusCondition getStatusCondition() {return this.statusCondition; }
    public void setStatusCondition(StatusCondition status) {this.statusCondition = status;}

}