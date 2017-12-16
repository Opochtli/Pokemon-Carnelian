import java.util.Random;
import java.util.Scanner;

public class Battle {

    protected BattleType battleType;

    protected int pokemonCaptured = 0;

    public void Battle(PartyPokemon party, Pokemon wildPokemon, PC pc) {

        boolean wildBattle = true;
        battleType = BattleType.WILD;

        System.out.println("");
        while (wildBattle) {

            Random rand = new Random();

            //Determines which Pokemon will start the battle
            Pokemon userPokemon = party.getNextPokemon();
            if (userPokemon == null) {
                whitedOutText(party);
                break;
            } else {
                System.out.println("You sent out " + userPokemon.getSpecies());
            }

            Pokemon enemyPokemon = wildPokemon;

            while ((userPokemon.getHP() > 0) && (enemyPokemon.getHP() > 0)) {

                if (userPokemon.getSpeed() > enemyPokemon.getSpeed()) {
                    boolean turnCheck= userTurn(userPokemon, enemyPokemon, party, pc);
                    if (turnCheck == false){
                        pokemonCaptured = 1;
                        break;
                    }
                    enemyTurn(userPokemon, enemyPokemon);
                }

                else if (userPokemon.getSpeed() < enemyPokemon.getSpeed()) {
                    enemyTurn(userPokemon, enemyPokemon);
                    boolean turnCheck= userTurn(userPokemon, enemyPokemon, party, pc);
                    if (turnCheck == false){
                        pokemonCaptured = 1;
                        break;
                    }
                }

                else {
                    int equalSpeed = rand.nextInt(2) + 1;

                    if (equalSpeed == 1) {
                        boolean turnCheck= userTurn(userPokemon, enemyPokemon, party, pc);
                        if (turnCheck == true){
                            pokemonCaptured = 1;
                            break;
                        }
                        enemyTurn(userPokemon, enemyPokemon);
                    } else {
                        enemyTurn(userPokemon, enemyPokemon);
                        boolean turnCheck= userTurn(userPokemon, enemyPokemon, party, pc);
                        if (turnCheck == true){
                            pokemonCaptured = 1;
                            break;
                        }
                    }
                }
            }

            if (wildPokemon.getHP() <= 0) {
                System.out.println("");
                System.out.println(wildPokemon.getSpecies() + " has been defeated!");
                System.out.println(userPokemon.getSpecies() + " earned " + wildPokemon.giveExp(1.0,wildPokemon.getEarnedExp(), 1, wildPokemon.getLevel(), 1) + " exp!");
                userPokemon.setExp(userPokemon.getExp() + wildPokemon.giveExp(1.0,wildPokemon.getEarnedExp(), 1, wildPokemon.getLevel(), 1));
                System.out.println("");
                break;
            }

            else if (pokemonCaptured == 1){
                break;
            }

            else {
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " has been defeated!");
            }
        }

        if ((wildPokemon.getHP() <= 0) || (pokemonCaptured ==1)){
            return;
        }
        else{
            whitedOutText(party);
        }
    }

    public boolean userTurn(Pokemon userPokemon, Pokemon wildPokemon, PartyPokemon party, PC pc) {

        if ((userPokemon.getHP() <= 0) || (wildPokemon.getHP() <= 0)) {
            return false;
        }

        Random rand = new Random();
        Scanner scnr = new Scanner(System.in);

        //USER TURN
        System.out.println("User turn");
        System.out.println("");
        System.out.println("What will you do?");
        System.out.println("1. Fight");
        System.out.println("2. Bag");
        System.out.println("3. Run");

        int input = scnr.nextInt();

        if (input == 1) {
            System.out.println("");
            System.out.println("Choose an attack:");

            Move userMove1 = userPokemon.getMove1();
            Move userMove2 = userPokemon.getMove2();
            Move userMove3 = userPokemon.getMove3();
            Move userMove4 = userPokemon.getMove4();

            System.out.println("1. " + userMove1.getMoveName() + " PP: " + userMove1.getMovePP() + "/" + userMove1.getMaxPP());
            System.out.println("2. " + userMove2.getMoveName() + " PP: " + userMove2.getMovePP() + "/" + userMove2.getMaxPP());
            System.out.println("3. " + userMove3.getMoveName() + " PP: " + userMove3.getMovePP() + "/" + userMove3.getMaxPP());
            System.out.println("4. " + userMove4.getMoveName() + " PP: " + userMove4.getMovePP() + "/" + userMove4.getMaxPP());

            int selectedMove = scnr.nextInt();

            if (selectedMove == 1) {
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " used " + userPokemon.getMove1().getMoveName());
                Move userMove = userPokemon.getMove1();

                double effectivity = Type.EffectCheck(userMove, wildPokemon);
                if (effectivity >= 2) {
                    System.out.println("It is super effective!");
                }
                else if (effectivity <= 0.5) {
                    System.out.println("It is not very effective!");
                }

                Move.userAttack(userPokemon, wildPokemon, userMove);
                userMove1.setMovePP(userMove1.getMovePP() - 1);
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
                System.out.println(wildPokemon.getSpecies() + " Hp: " + wildPokemon.getHP() + "/" + wildPokemon.getMaxHP());
                System.out.println("");
            }

            else if (selectedMove == 2) {
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " used " + userPokemon.getMove2().getMoveName());
                Move userMove = userPokemon.getMove2();

                double effectivity = Type.EffectCheck(userMove, wildPokemon);
                if (effectivity >= 2) {
                    System.out.println("It is super effective!");
                }
                else if (effectivity <= 0.5) {
                    System.out.println("It is not very effective!");
                }

                Move.userAttack(userPokemon, wildPokemon, userMove);
                userMove2.setMovePP(userMove2.getMovePP() - 1);
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
                System.out.println(wildPokemon.getSpecies() + " Hp: " + wildPokemon.getHP() + "/" + wildPokemon.getMaxHP());
                System.out.println("");
            }

            else if (selectedMove == 3) {
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " used " + userPokemon.getMove3().getMoveName());
                Move userMove = userPokemon.getMove3();

                double effectivity = Type.EffectCheck(userMove, wildPokemon);
                if (effectivity >= 2) {
                    System.out.println("It is super effective!");
                }
                else if (effectivity <= 0.5) {
                    System.out.println("It is not very effective!");
                }

                Move.userAttack(userPokemon, wildPokemon, userMove);
                userMove3.setMovePP(userMove3.getMovePP() - 1);
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
                System.out.println(wildPokemon.getSpecies() + " Hp: " + wildPokemon.getHP() + "/" + wildPokemon.getMaxHP());
                System.out.println("");
            }

            else if (selectedMove == 4) {
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " used " + userPokemon.getMove4().getMoveName());
                Move userMove = userPokemon.getMove4();

                double effectivity = Type.EffectCheck(userMove, wildPokemon);
                if (effectivity >= 2) {
                    System.out.println("It is super effective!");
                }
                else if (effectivity <= 0.5) {
                    System.out.println("It is not very effective!");
                }

                Move.userAttack(userPokemon, wildPokemon, userMove);
                userMove4.setMovePP(userMove4.getMovePP() - 1);
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
                System.out.println(wildPokemon.getSpecies() + " Hp: " + wildPokemon.getHP() + "/" + wildPokemon.getMaxHP());
                System.out.println("");
            }

            else {
                System.out.println("Invalid move choice.");
            }
        }

        else if (input == 2) {
            PokeBalls pokeBall = new PokeBalls();
            boolean caught = pokeBall.throwPokeball(wildPokemon, party, pc, battleType);
            if (caught == true){
                return false;
            }
            else {
                return true;
            }
        }

        else if (input == 3) {

            System.out.println("This function does not yet exist.");
        }

        else {
            System.out.println("Not a valid choice.");
        }

        return true;
    }

    public static void enemyTurn(Pokemon userPokemon, Pokemon wildPokemon) {

        if ((userPokemon.getHP() <= 0) || (wildPokemon.getHP() <= 0)) {
            return;
        }

        Random rand = new Random();
        Scanner scnr = new Scanner(System.in);

        //ENEMY TURN
        System.out.println("Enemy turn");

        Move enemyMove1 = wildPokemon.getMove1();
        Move enemyMove2 = wildPokemon.getMove2();
        Move enemyMove3 = wildPokemon.getMove3();

        Move enemyMove4 = wildPokemon.getMove4();

        int enemyMoveChoice = rand.nextInt(4) + 1;

        if (enemyMoveChoice == 1) {
            System.out.println("");
            System.out.println(wildPokemon.getSpecies() + " used " + wildPokemon.getMove1().getMoveName());
            Move enemyMove = wildPokemon.getMove1();

            double effectivity = Type.EffectCheck(enemyMove, userPokemon);
            if (effectivity >= 2) {
                System.out.println("It is super effective!");
            }
            else if (effectivity <= 0.5) {
                System.out.println("It is not very effective!");
            }

            Move.enemyAttack(userPokemon, wildPokemon, enemyMove);
            enemyMove1.setMovePP(enemyMove1.getMovePP() - 1);
            System.out.println("");
            System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
            System.out.println(wildPokemon.getSpecies() + " Hp: " + wildPokemon.getHP() + "/" + wildPokemon.getMaxHP());
            System.out.println("");
        }

        else if (enemyMoveChoice == 2) {
            System.out.println("");
            System.out.println(wildPokemon.getSpecies() + " used " + wildPokemon.getMove2().getMoveName());
            Move enemyMove = userPokemon.getMove2();

            double effectivity = Type.EffectCheck(enemyMove, userPokemon);
            if (effectivity >= 2) {
                System.out.println("It is super effective!");
            }
            else if (effectivity <= 0.5) {
                System.out.println("It is not very effective!");
            }

            Move.enemyAttack(userPokemon, wildPokemon, enemyMove);
            enemyMove2.setMovePP(enemyMove2.getMovePP() - 1);
            System.out.println("");
            System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
            System.out.println(wildPokemon.getSpecies() + " Hp: " + wildPokemon.getHP() + "/" + wildPokemon.getMaxHP());
            System.out.println("");
        }

        else if (enemyMoveChoice == 3) {
            System.out.println("");
            System.out.println(wildPokemon.getSpecies() + " used " + wildPokemon.getMove3().getMoveName());
            Move enemyMove = userPokemon.getMove3();

            double effectivity = Type.EffectCheck(enemyMove, userPokemon);
            if (effectivity >= 2) {
                System.out.println("It is super effective!");
            }
            else if (effectivity <= 0.5) {
                System.out.println("It is not very effective!");
            }

            Move.enemyAttack(userPokemon, wildPokemon, enemyMove);
            enemyMove3.setMovePP(enemyMove3.getMovePP() - 1);
            System.out.println("");
            System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
            System.out.println(wildPokemon.getSpecies() + " Hp: " + wildPokemon.getHP() + "/" + wildPokemon.getMaxHP());
            System.out.println("");
        }

        else if (enemyMoveChoice == 4) {
            System.out.println("");
            System.out.println(wildPokemon.getSpecies() + " used " + wildPokemon.getMove4().getMoveName());
            Move enemyMove = userPokemon.getMove4();

            double effectivity = Type.EffectCheck(enemyMove, userPokemon);
            if (effectivity >= 2) {
                System.out.println("It is super effective!");
            }
            else if (effectivity <= 0.5) {
                System.out.println("It is not very effective!");
            }

            Move.enemyAttack(userPokemon, wildPokemon, enemyMove);
            enemyMove4.setMovePP(enemyMove4.getMovePP() - 1);
            System.out.println("");
            System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
            System.out.println(wildPokemon.getSpecies() + " Hp: " + wildPokemon.getHP() + "/" + wildPokemon.getMaxHP());
            System.out.println("");
        }
    }

    public static void whitedOut(PartyPokemon party) {

        int partySize = party.partyPokemon.size();

        for (int i = 0; i < partySize; ++i) {
            party.partyPokemon.get(i).setHP(party.partyPokemon.get(i).getMaxHP());
            party.partyPokemon.get(i).setStatusCondition(StatusCondition.NORMAL);
            party.partyPokemon.get(i).getMove1().setMovePP(party.partyPokemon.get(i).getMove1().getMaxPP());
            party.partyPokemon.get(i).getMove2().setMovePP(party.partyPokemon.get(i).getMove2().getMaxPP());
            party.partyPokemon.get(i).getMove3().setMovePP(party.partyPokemon.get(i).getMove3().getMaxPP());
            party.partyPokemon.get(i).getMove4().setMovePP(party.partyPokemon.get(i).getMove4().getMaxPP());
        }
    }

    public static void whitedOutText(PartyPokemon party){

        System.out.println("");
        System.out.println("You have no more usable Pokemon.");
        System.out.println("You have whited out...");
        System.out.println("");
        System.out.println("You scurried to the nearest Pokemon center...");
        System.out.println("protecting your injured Pokemon from further harm.");

        whitedOut(party);
    }
}

