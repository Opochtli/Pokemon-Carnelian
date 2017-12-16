import java.util.Random;
import java.util.*;

public class Move {

    protected String moveName;
    protected int moveAccuracy;
    protected int movePower;
    protected int movePP;
    protected int maxPP;
    protected Type type;

    public Move(String name, int Accuracy, int Power, int maxPP, int PP, Type moveType){
        this.moveName = name;
        this.moveAccuracy  =Accuracy;
        this.movePower = Power;
        this.maxPP = maxPP;
        this.movePP = PP;
        this.type = moveType;
    }

    //Get Name
    public String getMoveName(){ return this.moveName; }

    //Get and Set Accuracy
    public int getMoveAccuracy(){ return this.moveAccuracy; }
    public void setMoveAccuracy(int newAccuracy) { this.moveAccuracy = newAccuracy; }

    //Get and Set Power
    public int getMovePower() { return this.movePower; }
    public void setMovePower(int newPower){
        this.movePower = newPower;
    }

    //Get and Set Max PP
    public int getMaxPP() { return this.maxPP; }
    public void setMaxPP(int newMaxPP){
        this.maxPP = newMaxPP;
    }

    //Get and Set PP
    public int getMovePP() { return this.movePP; }
    public void setMovePP(int newPP){
        this.movePP = newPP;
    }

    //Get Move Type
    public Type getType() {return this.type;}

    //User Attack
    public static void userAttack(Pokemon userPokemon, Pokemon enemyPokemon, Move userPokemonMove) {
        int level = userPokemon.getLevel();
        int a = userPokemon.getAttack();
        int d = enemyPokemon.getDefense();
        int power = userPokemonMove.getMovePower();
        //int targets
        //int weather
        //int Badge
        //int Critical
        //int random
        double stab = Type.StabCheck(userPokemonMove, userPokemon);
        double effectivity = Type.EffectCheck(userPokemonMove, enemyPokemon);
        double modifier = (stab * effectivity);

        int damage = (int) (((((((((2 * level) / 5) + 2) * power) * (a / d))) / 50) + 2) * modifier);

        enemyPokemon.setHP(enemyPokemon.getHP() - damage);

        if (enemyPokemon.getHP() < 0){
            enemyPokemon.setHP(0);
        }
    }

    public static void enemyAttack(Pokemon userPokemon, Pokemon enemyPokemon, Move enemyPokemonMove) {
        int level = enemyPokemon.getLevel();
        int a = enemyPokemon.getAttack();
        int d = userPokemon.getDefense();
        int power = enemyPokemonMove.getMovePower();
        //int targets
        //int weather
        //int Badge
        //int Critical
        //int random
        double stab = Type.StabCheck(enemyPokemonMove, enemyPokemon);
        double effectivity = Type.EffectCheck(enemyPokemonMove, userPokemon);
        double modifier = (stab * effectivity);

        int damage = (int) (((((((((2 * level) / 5) + 2) * power) * (a / d))) / 50) + 2) * modifier);

        userPokemon.setHP(userPokemon.getHP() - damage);

        if (userPokemon.getHP() < 0){
            userPokemon.setHP(0);
        }
    }

}
