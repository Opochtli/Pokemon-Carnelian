import java.util.*;

public class TrainerBattle {

    String trainerName = "";
    String trainerTitle = "";

    protected BattleType battleType;

    public void Battle(PartyPokemon party, PartyPokemon TrainerPokemon) {

            boolean trainerBattle = true;
            battleType = BattleType.TRAINER;

            System.out.println("");
            while (trainerBattle) {

                Random rand = new Random();

                //Determines which Pokemon will start the battle
                Pokemon userPokemon = party.getNextPokemon();
                if (userPokemon == null){
                    break;
                }
                else {
                    System.out.println("You sent out " + userPokemon.getSpecies());
                }

                //Determines which Pokemon will start the battle
                Pokemon trainerPokemon = TrainerPokemon.getNextPokemon();
                if (trainerPokemon == null){
                    break;
                }
                else {
                    System.out.println(getTrainerTitle() + " " + getTrainerName() + " sent out " + trainerPokemon.getSpecies());
                    System.out.println("");
                }

                while ((userPokemon.getHP() > 0) && (trainerPokemon.getHP() > 0)) {

                    //Check that user Pokemon has not fainted
                    userPokemon = party.getNextPokemon();
                    if (userPokemon == null){
                        break;
                    }

                    //Check that trainer Pokemon has not fainted
                    trainerPokemon = TrainerPokemon.getNextPokemon();
                    if (trainerPokemon == null){
                        break;
                    }

                    if (userPokemon.getSpeed() > trainerPokemon.getSpeed()) {
                        userTurn(userPokemon, trainerPokemon);
                        trainerTurn(userPokemon, trainerPokemon);
                    } else if (userPokemon.getSpeed() < trainerPokemon.getSpeed()) {
                        trainerTurn(userPokemon, trainerPokemon);
                        userTurn(userPokemon, trainerPokemon);
                    } else {
                        int equalSpeed = rand.nextInt(2) + 1;

                        if (equalSpeed == 1) {
                            userTurn(userPokemon, trainerPokemon);
                            trainerTurn(userPokemon, trainerPokemon);
                        } else {
                            trainerTurn(userPokemon, trainerPokemon);
                            userTurn(userPokemon, trainerPokemon);
                        }
                    }
                }

                if (trainerPokemon.getHP() <= 0) {
                    System.out.println("");
                    System.out.println(trainerPokemon.getSpecies() + " has been defeated!");
                    System.out.println(userPokemon.getSpecies() + " earned " + trainerPokemon.giveExp(1.5,trainerPokemon.getEarnedExp(), 1, trainerPokemon.getLevel(), 1) + " exp!");
                    userPokemon.setExp(userPokemon.getExp() + trainerPokemon.giveExp(1.5,trainerPokemon.getEarnedExp(), 1, trainerPokemon.getLevel(), 1));
                    System.out.println("");
                }

                else {
                    System.out.println("");
                    System.out.println(userPokemon.getSpecies() + " has been defeated!");
                }
            }

            int partySize = party.partyPokemon.size();

            //Party Size of 1
            if (partySize == 1) {
                if (party.getPokemon1().getHP() <= 0){
                    whitedOutText(party);
                }
                else{
                    System.out.println("");
                    System.out.println(getTrainerTitle() + getTrainerName() + " has been defeated!");
                    System.out.println("");
                }
            }

            //Party size of 2
            else if (partySize == 2) {
                if (party.getPokemon2().getHP() <= 0){
                    whitedOutText(party);
                }
                else{
                    System.out.println("");
                    System.out.println(getTrainerTitle() + getTrainerName() + " has been defeated!");
                    System.out.println("");
                }
            }

            //Party size of 3
            else if (partySize == 3) {
                if (party.getPokemon2().getHP() <= 0){
                    whitedOutText(party);
                }
                else{
                    System.out.println("");
                    System.out.println(getTrainerTitle() + getTrainerName() + " has been defeated!");
                    System.out.println("");
                }
            }

            //Party size of 4
            else if (partySize == 4) {
                if (party.getPokemon2().getHP() <= 0){
                    whitedOutText(party);
                }
                else{
                    System.out.println("");
                    System.out.println(getTrainerTitle() + getTrainerName() + " has been defeated!");
                    System.out.println("");
                }
            }

            //Party size of 5
            else if (partySize == 5) {
                if (party.getPokemon2().getHP() <= 0){
                    whitedOutText(party);
                }
                else{
                    System.out.println("");
                    System.out.println(getTrainerTitle() + getTrainerName() + " has been defeated!");
                    System.out.println("");
                }
            }

            //Party size of 6
            else if (partySize == 6) {
                if (party.getPokemon2().getHP() <= 0){
                    whitedOutText(party);
                }
                else{
                    System.out.println("");
                    System.out.println(getTrainerTitle() + getTrainerName() + " has been defeated!");
                    System.out.println("");
                }
            }
        }


    public static void userTurn(Pokemon userPokemon, Pokemon trainerPokemon){

        if ((userPokemon.getHP() <= 0) || (trainerPokemon.getHP() <= 0)) {
            return;
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

                double effectivity = Type.EffectCheck(userMove, trainerPokemon);
                if (effectivity >= 2) {
                    System.out.println("It is super effective!");
                }
                else if (effectivity <= 0.5) {
                    System.out.println("It is not very effective!");
                }

                Move.userAttack(userPokemon, trainerPokemon, userMove);
                userMove1.setMovePP(userMove1.getMovePP() - 1);
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
                System.out.println(trainerPokemon.getSpecies() + " Hp: " + trainerPokemon.getHP() + "/" + trainerPokemon.getMaxHP());
                System.out.println("");
            }

            else if (selectedMove == 2) {
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " used " + userPokemon.getMove2().getMoveName());
                Move userMove = userPokemon.getMove2();

                double effectivity = Type.EffectCheck(userMove, trainerPokemon);
                if (effectivity >= 2) {
                    System.out.println("It is super effective!");
                }
                else if (effectivity <= 0.5) {
                    System.out.println("It is not very effective!");
                }

                Move.userAttack(userPokemon, trainerPokemon, userMove);
                userMove2.setMovePP(userMove2.getMovePP() - 1);
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
                System.out.println(trainerPokemon.getSpecies() + " Hp: " + trainerPokemon.getHP() + "/" + trainerPokemon.getMaxHP());
                System.out.println("");
            }

            else if (selectedMove == 3) {
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " used " + userPokemon.getMove3().getMoveName());
                Move userMove = userPokemon.getMove3();

                double effectivity = Type.EffectCheck(userMove, trainerPokemon);
                if (effectivity >= 2) {
                    System.out.println("It is super effective!");
                }
                else if (effectivity <= 0.5) {
                    System.out.println("It is not very effective!");
                }

                Move.userAttack(userPokemon, trainerPokemon, userMove);
                userMove3.setMovePP(userMove3.getMovePP() - 1);
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
                System.out.println(trainerPokemon.getSpecies() + " Hp: " + trainerPokemon.getHP() + "/" + trainerPokemon.getMaxHP());
                System.out.println("");
            }

            else if (selectedMove == 4) {
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " used " + userPokemon.getMove4().getMoveName());
                Move userMove = userPokemon.getMove4();

                double effectivity = Type.EffectCheck(userMove, trainerPokemon);
                if (effectivity >= 2) {
                    System.out.println("It is super effective!");
                }
                else if (effectivity <= 0.5) {
                    System.out.println("It is not very effective!");
                }

                Move.userAttack(userPokemon, trainerPokemon, userMove);
                userMove4.setMovePP(userMove4.getMovePP() - 1);
                System.out.println("");
                System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
                System.out.println(trainerPokemon.getSpecies() + " Hp: " + trainerPokemon.getHP() + "/" + trainerPokemon.getMaxHP());
                System.out.println("");
            }

            else {
                System.out.println("Invalid move choice.");
            }
        } else if (input == 2) {
            System.out.println("This function does not yet exist.");
        } else if (input == 3) {
            System.out.println("This function does not yet exist.");
        } else {
            System.out.println("Not a valid choice.");
        }
    }

    public static void trainerTurn (Pokemon userPokemon, Pokemon trainerPokemon) {

        if ((userPokemon.getHP() <= 0) || (trainerPokemon.getHP() <= 0)) {
            return;
        }

        Random rand = new Random();
        Scanner scnr = new Scanner(System.in);

        //ENEMY TURN
        System.out.println("Enemy turn");

        Move enemyMove1 = trainerPokemon.getMove1();
        Move enemyMove2 = trainerPokemon.getMove2();
        Move enemyMove3 = trainerPokemon.getMove3();
        Move enemyMove4 = trainerPokemon.getMove4();

        int enemyMoveChoice = rand.nextInt(4) + 1;

        if (enemyMoveChoice == 1) {
            System.out.println("");
            System.out.println(trainerPokemon.getSpecies() + " used " + trainerPokemon.getMove1().getMoveName());
            Move enemyMove = trainerPokemon.getMove1();

            double effectivity = Type.EffectCheck(enemyMove, userPokemon);
            if (effectivity >= 2) {
                System.out.println("It is super effective!");
            }
            else if (effectivity <= 0.5) {
                System.out.println("It is not very effective!");
            }

            Move.enemyAttack(userPokemon, trainerPokemon, enemyMove);
            enemyMove1.setMovePP(enemyMove1.getMovePP() - 1);
            System.out.println("");
            System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
            System.out.println(trainerPokemon.getSpecies() + " Hp: " + trainerPokemon.getHP() + "/" + trainerPokemon.getMaxHP());
            System.out.println("");
        }

        else if (enemyMoveChoice == 2) {
            System.out.println("");
            System.out.println(trainerPokemon.getSpecies() + " used " + trainerPokemon.getMove2().getMoveName());
            Move enemyMove = userPokemon.getMove2();

            double effectivity = Type.EffectCheck(enemyMove, userPokemon);
            if (effectivity >= 2) {
                System.out.println("It is super effective!");
            }
            else if (effectivity <= 0.5) {
                System.out.println("It is not very effective!");
            }

            Move.enemyAttack(userPokemon, trainerPokemon, enemyMove);
            enemyMove2.setMovePP(enemyMove2.getMovePP() - 1);
            System.out.println("");
            System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
            System.out.println(trainerPokemon.getSpecies() + " Hp: " + trainerPokemon.getHP() + "/" + trainerPokemon.getMaxHP());
            System.out.println("");
        }

        else if (enemyMoveChoice == 3) {
            System.out.println("");
            System.out.println(trainerPokemon.getSpecies() + " used " + trainerPokemon.getMove3().getMoveName());
            Move enemyMove = userPokemon.getMove3();

            double effectivity = Type.EffectCheck(enemyMove, userPokemon);
            if (effectivity >= 2) {
                System.out.println("It is super effective!");
            }
            else if (effectivity <= 0.5) {
                System.out.println("It is not very effective!");
            }

            Move.enemyAttack(userPokemon, trainerPokemon, enemyMove);
            enemyMove3.setMovePP(enemyMove3.getMovePP() - 1);
            System.out.println("");
            System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
            System.out.println(trainerPokemon.getSpecies() + " Hp: " + trainerPokemon.getHP() + "/" + trainerPokemon.getMaxHP());
            System.out.println("");
        }

        else if (enemyMoveChoice == 4) {
            System.out.println("");
            System.out.println(trainerPokemon.getSpecies() + " used " + trainerPokemon.getMove4().getMoveName());
            Move enemyMove = userPokemon.getMove4();

            double effectivity = Type.EffectCheck(enemyMove, userPokemon);
            if (effectivity >= 2) {
                System.out.println("It is super effective!");
            }
            else if (effectivity <= 0.5) {
                System.out.println("It is not very effective!");
            }

            Move.enemyAttack(userPokemon, trainerPokemon, enemyMove);
            enemyMove4.setMovePP(enemyMove4.getMovePP() - 1);
            System.out.println("");
            System.out.println(userPokemon.getSpecies() + " Hp: " + userPokemon.getHP() + "/" + userPokemon.getMaxHP());
            System.out.println(trainerPokemon.getSpecies() + " Hp: " + trainerPokemon.getHP() + "/" + trainerPokemon.getMaxHP());
            System.out.println("");
        }
    }

    public static void whitedOut(PartyPokemon party) {

        int partySize = party.partyPokemon.size();

        if (partySize == 1) {
            party.getPokemon1().setHP(party.getPokemon1().getMaxHP());
            party.getPokemon1().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon1().getMove1().setMovePP(party.getPokemon1().getMove1().getMaxPP());
            party.getPokemon1().getMove2().setMovePP(party.getPokemon1().getMove2().getMaxPP());
            party.getPokemon1().getMove3().setMovePP(party.getPokemon1().getMove3().getMaxPP());
            party.getPokemon1().getMove4().setMovePP(party.getPokemon1().getMove4().getMaxPP());

        }
        else if (partySize == 2) {
            party.getPokemon1().setHP(party.getPokemon1().getMaxHP());
            party.getPokemon1().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon1().getMove1().setMovePP(party.getPokemon1().getMove1().getMaxPP());
            party.getPokemon1().getMove2().setMovePP(party.getPokemon1().getMove2().getMaxPP());
            party.getPokemon1().getMove3().setMovePP(party.getPokemon1().getMove3().getMaxPP());
            party.getPokemon1().getMove4().setMovePP(party.getPokemon1().getMove4().getMaxPP());

            party.getPokemon2().setHP(party.getPokemon2().getMaxHP());
            party.getPokemon2().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon2().getMove1().setMovePP(party.getPokemon2().getMove1().getMaxPP());
            party.getPokemon2().getMove2().setMovePP(party.getPokemon2().getMove2().getMaxPP());
            party.getPokemon2().getMove3().setMovePP(party.getPokemon2().getMove3().getMaxPP());
            party.getPokemon2().getMove4().setMovePP(party.getPokemon2().getMove4().getMaxPP());
        }
        else if (partySize == 3) {
            party.getPokemon1().setHP(party.getPokemon1().getMaxHP());
            party.getPokemon1().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon1().getMove1().setMovePP(party.getPokemon1().getMove1().getMaxPP());
            party.getPokemon1().getMove2().setMovePP(party.getPokemon1().getMove2().getMaxPP());
            party.getPokemon1().getMove3().setMovePP(party.getPokemon1().getMove3().getMaxPP());
            party.getPokemon1().getMove4().setMovePP(party.getPokemon1().getMove4().getMaxPP());

            party.getPokemon2().setHP(party.getPokemon2().getMaxHP());
            party.getPokemon2().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon2().getMove1().setMovePP(party.getPokemon2().getMove1().getMaxPP());
            party.getPokemon2().getMove2().setMovePP(party.getPokemon2().getMove2().getMaxPP());
            party.getPokemon2().getMove3().setMovePP(party.getPokemon2().getMove3().getMaxPP());
            party.getPokemon2().getMove4().setMovePP(party.getPokemon2().getMove4().getMaxPP());

            party.getPokemon3().setHP(party.getPokemon3().getMaxHP());
            party.getPokemon3().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon3().getMove1().setMovePP(party.getPokemon3().getMove1().getMaxPP());
            party.getPokemon3().getMove2().setMovePP(party.getPokemon3().getMove2().getMaxPP());
            party.getPokemon3().getMove3().setMovePP(party.getPokemon3().getMove3().getMaxPP());
            party.getPokemon3().getMove4().setMovePP(party.getPokemon3().getMove4().getMaxPP());
        }
        else if (partySize == 4) {
            party.getPokemon1().setHP(party.getPokemon1().getMaxHP());
            party.getPokemon1().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon1().getMove1().setMovePP(party.getPokemon1().getMove1().getMaxPP());
            party.getPokemon1().getMove2().setMovePP(party.getPokemon1().getMove2().getMaxPP());
            party.getPokemon1().getMove3().setMovePP(party.getPokemon1().getMove3().getMaxPP());
            party.getPokemon1().getMove4().setMovePP(party.getPokemon1().getMove4().getMaxPP());

            party.getPokemon2().setHP(party.getPokemon2().getMaxHP());
            party.getPokemon2().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon2().getMove1().setMovePP(party.getPokemon2().getMove1().getMaxPP());
            party.getPokemon2().getMove2().setMovePP(party.getPokemon2().getMove2().getMaxPP());
            party.getPokemon2().getMove3().setMovePP(party.getPokemon2().getMove3().getMaxPP());
            party.getPokemon2().getMove4().setMovePP(party.getPokemon2().getMove4().getMaxPP());

            party.getPokemon3().setHP(party.getPokemon3().getMaxHP());
            party.getPokemon3().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon3().getMove1().setMovePP(party.getPokemon3().getMove1().getMaxPP());
            party.getPokemon3().getMove2().setMovePP(party.getPokemon3().getMove2().getMaxPP());
            party.getPokemon3().getMove3().setMovePP(party.getPokemon3().getMove3().getMaxPP());
            party.getPokemon3().getMove4().setMovePP(party.getPokemon3().getMove4().getMaxPP());

            party.getPokemon4().setHP(party.getPokemon4().getMaxHP());
            party.getPokemon4().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon4().getMove1().setMovePP(party.getPokemon4().getMove1().getMaxPP());
            party.getPokemon4().getMove2().setMovePP(party.getPokemon4().getMove2().getMaxPP());
            party.getPokemon4().getMove3().setMovePP(party.getPokemon4().getMove3().getMaxPP());
            party.getPokemon4().getMove4().setMovePP(party.getPokemon4().getMove4().getMaxPP());
        }
        else if (partySize == 5) {
            party.getPokemon1().setHP(party.getPokemon1().getMaxHP());
            party.getPokemon1().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon1().getMove1().setMovePP(party.getPokemon1().getMove1().getMaxPP());
            party.getPokemon1().getMove2().setMovePP(party.getPokemon1().getMove2().getMaxPP());
            party.getPokemon1().getMove3().setMovePP(party.getPokemon1().getMove3().getMaxPP());
            party.getPokemon1().getMove4().setMovePP(party.getPokemon1().getMove4().getMaxPP());

            party.getPokemon2().setHP(party.getPokemon2().getMaxHP());
            party.getPokemon2().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon2().getMove1().setMovePP(party.getPokemon2().getMove1().getMaxPP());
            party.getPokemon2().getMove2().setMovePP(party.getPokemon2().getMove2().getMaxPP());
            party.getPokemon2().getMove3().setMovePP(party.getPokemon2().getMove3().getMaxPP());
            party.getPokemon2().getMove4().setMovePP(party.getPokemon2().getMove4().getMaxPP());

            party.getPokemon3().setHP(party.getPokemon3().getMaxHP());
            party.getPokemon3().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon3().getMove1().setMovePP(party.getPokemon3().getMove1().getMaxPP());
            party.getPokemon3().getMove2().setMovePP(party.getPokemon3().getMove2().getMaxPP());
            party.getPokemon3().getMove3().setMovePP(party.getPokemon3().getMove3().getMaxPP());
            party.getPokemon3().getMove4().setMovePP(party.getPokemon3().getMove4().getMaxPP());

            party.getPokemon4().setHP(party.getPokemon4().getMaxHP());
            party.getPokemon4().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon4().getMove1().setMovePP(party.getPokemon4().getMove1().getMaxPP());
            party.getPokemon4().getMove2().setMovePP(party.getPokemon4().getMove2().getMaxPP());
            party.getPokemon4().getMove3().setMovePP(party.getPokemon4().getMove3().getMaxPP());
            party.getPokemon4().getMove4().setMovePP(party.getPokemon4().getMove4().getMaxPP());

            party.getPokemon5().setHP(party.getPokemon5().getMaxHP());
            party.getPokemon5().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon5().getMove1().setMovePP(party.getPokemon5().getMove1().getMaxPP());
            party.getPokemon5().getMove2().setMovePP(party.getPokemon5().getMove2().getMaxPP());
            party.getPokemon5().getMove3().setMovePP(party.getPokemon5().getMove3().getMaxPP());
            party.getPokemon5().getMove4().setMovePP(party.getPokemon5().getMove4().getMaxPP());
        }
        else if (partySize == 6) {
            party.getPokemon1().setHP(party.getPokemon1().getMaxHP());
            party.getPokemon1().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon1().getMove1().setMovePP(party.getPokemon1().getMove1().getMaxPP());
            party.getPokemon1().getMove2().setMovePP(party.getPokemon1().getMove2().getMaxPP());
            party.getPokemon1().getMove3().setMovePP(party.getPokemon1().getMove3().getMaxPP());
            party.getPokemon1().getMove4().setMovePP(party.getPokemon1().getMove4().getMaxPP());

            party.getPokemon2().setHP(party.getPokemon2().getMaxHP());
            party.getPokemon2().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon2().getMove1().setMovePP(party.getPokemon2().getMove1().getMaxPP());
            party.getPokemon2().getMove2().setMovePP(party.getPokemon2().getMove2().getMaxPP());
            party.getPokemon2().getMove3().setMovePP(party.getPokemon2().getMove3().getMaxPP());
            party.getPokemon2().getMove4().setMovePP(party.getPokemon2().getMove4().getMaxPP());

            party.getPokemon3().setHP(party.getPokemon3().getMaxHP());
            party.getPokemon3().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon3().getMove1().setMovePP(party.getPokemon3().getMove1().getMaxPP());
            party.getPokemon3().getMove2().setMovePP(party.getPokemon3().getMove2().getMaxPP());
            party.getPokemon3().getMove3().setMovePP(party.getPokemon3().getMove3().getMaxPP());
            party.getPokemon3().getMove4().setMovePP(party.getPokemon3().getMove4().getMaxPP());

            party.getPokemon4().setHP(party.getPokemon4().getMaxHP());
            party.getPokemon4().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon4().getMove1().setMovePP(party.getPokemon4().getMove1().getMaxPP());
            party.getPokemon4().getMove2().setMovePP(party.getPokemon4().getMove2().getMaxPP());
            party.getPokemon4().getMove3().setMovePP(party.getPokemon4().getMove3().getMaxPP());
            party.getPokemon4().getMove4().setMovePP(party.getPokemon4().getMove4().getMaxPP());

            party.getPokemon5().setHP(party.getPokemon5().getMaxHP());
            party.getPokemon5().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon5().getMove1().setMovePP(party.getPokemon5().getMove1().getMaxPP());
            party.getPokemon5().getMove2().setMovePP(party.getPokemon5().getMove2().getMaxPP());
            party.getPokemon5().getMove3().setMovePP(party.getPokemon5().getMove3().getMaxPP());
            party.getPokemon5().getMove4().setMovePP(party.getPokemon5().getMove4().getMaxPP());

            party.getPokemon6().setHP(party.getPokemon6().getMaxHP());
            party.getPokemon6().setStatusCondition(StatusCondition.NORMAL);
            party.getPokemon6().getMove1().setMovePP(party.getPokemon6().getMove1().getMaxPP());
            party.getPokemon6().getMove2().setMovePP(party.getPokemon6().getMove2().getMaxPP());
            party.getPokemon6().getMove3().setMovePP(party.getPokemon6().getMove3().getMaxPP());
            party.getPokemon6().getMove4().setMovePP(party.getPokemon6().getMove4().getMaxPP());
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

    public void victoryText(){

        System.out.println("");
        System.out.println(getTrainerTitle() + " " + getTrainerName() + " has been defeated!");
        System.out.println("");
    }

    public String getTrainerName() {return this.trainerName; }
    public void setTrainerName(String TrainerName) {this.trainerName = TrainerName;}

    public String getTrainerTitle() { return this.trainerTitle; }
    public void setTrainerTitle(String TrainerTitle) { this.trainerTitle = TrainerTitle; }

    public void trainerTimmyBattle(PartyPokemon party){

        //Establish Trainer Title
        String trainerTitle = "Trainer";
        setTrainerTitle(trainerTitle);

        //Establish Trainer Name
        String trainerName = "Timmy";
        setTrainerName(trainerName);

        //Establish Trainer Party
        PartyPokemon trainerParty = new PartyPokemon(3);

        //Establish Trainer Pokemon
        Pokemon Pokemon1 = new Pokemon(7,3);
        Pokemon Pokemon2 = new Pokemon (8, 4);
        Pokemon Pokemon3 = new Pokemon (3,3);

        //Add Trainer Pokemon To Party
        trainerParty.partyPokemon.add(Pokemon1);
        trainerParty.partyPokemon.add(Pokemon2);
        trainerParty.partyPokemon.add(Pokemon3);

        System.out.println("");
        System.out.println(trainerTitle + " " + trainerName + " would like to battle!");
        Battle(party,trainerParty);
    }

    public void beautyEmmaBattle(PartyPokemon party){

        //Establish Trainer Title
        String trainerTitle = "Beauty";
        setTrainerTitle(trainerTitle);

        //Establish Trainer Name
        String trainerName = "Emma";
        setTrainerName(trainerName);

        //Establish Trainer Party
        PartyPokemon trainerParty = new PartyPokemon(3);

        //Establish Trainer Pokemon
        Pokemon Pokemon1 = new Pokemon(1,1);
        Pokemon Pokemon2 = new Pokemon (2, 3);
        Pokemon Pokemon3 = new Pokemon (3,2);

        //Add Trainer Pokemon To Party
        trainerParty.partyPokemon.add(Pokemon1);
        trainerParty.partyPokemon.add(Pokemon2);
        trainerParty.partyPokemon.add(Pokemon3);

        System.out.println("");
        System.out.println(trainerTitle + " " + trainerName + " would like to battle!");
        Battle(party,trainerParty);
    }

    public void hikerLloydBattle(PartyPokemon party){

        //Establish Trainer Title
        String trainerTitle = "Hiker";
        setTrainerTitle(trainerTitle);

        //Establish Trainer Name
        String trainerName = "Lloyd";
        setTrainerName(trainerName);

        //Establish Trainer Party
        PartyPokemon trainerParty = new PartyPokemon(3);

        //Establish Trainer Pokemon
        Pokemon Pokemon1 = new Pokemon(4,2);
        Pokemon Pokemon2 = new Pokemon (5, 3);
        Pokemon Pokemon3 = new Pokemon (6,2);

        //Add Trainer Pokemon To Party
        trainerParty.partyPokemon.add(Pokemon1);
        trainerParty.partyPokemon.add(Pokemon2);
        trainerParty.partyPokemon.add(Pokemon3);

        System.out.println("");
        System.out.println(trainerTitle + " " + trainerName + " would like to battle!");
        Battle(party,trainerParty);
    }
}