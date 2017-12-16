import java.util.Random;
import java.util.Scanner;

public class PokeBalls {

    protected String ballType;
    protected double multiplier;

    public void pokeBall(int ballID) {

        if (ballID == 1) {
            ballType = "Poke Ball";
            multiplier = 1;
        }

        else if (ballID == 2) {
            ballType = "Great Ball";
            multiplier = 1.5;
        }

        else if (ballID == 3) {
            ballType = "Ultra Ball";
            multiplier = 2.0;
        }

        else if (ballID == 4) {
            ballType = "Master Ball";
            multiplier = 255.0;
        }

        /*

        else if (ballID == 5) {
            ballType = "Timer Ball";
            if (turnCounter > 10 && turnCounter < 20) {
                multiplier = 2.0;
            }
            else if (turnCounter > 20 && turnCounter < 30) {
                multiplier = 3.0;
            }
            else if (turnCounter > 30) {
                multiplier = 4.0;
            }
            else{
                multiplier = 1;
            }
        }

        else if (ballID == 6){
            ballType = "Nest Ball";
            if (wildPokemon.getLevel() <= 9) {
                multiplier = 4.0;
            }
            else if (wildPokemon.getLevel() <= 19) {
                multiplier = 3.0;
            }
            else if (wildPokemon.getLevel() <= 29) {
                multiplier = 2.0;
            }
            else{
                multiplier = 1;
            }
        }

        */
    }

    //Get Ball Type
    public String getBallType() {return this.ballType;}

    //Get Ball Multipler
    public double getBallMultiplier() {return this.multiplier; }

    public boolean catchPokemon(Pokemon wildPokemon, PokeBalls ball, int ballID) {

        Random rand = new Random();
        if (ballID == 1) {
            ball.pokeBall(1);
        }
        else if (ballID ==2) {
            ball.pokeBall(2);
        }
        else if (ballID ==3) {
            ball.pokeBall(3);
        }
        else if (ballID ==4) {
            ball.pokeBall(4);
        }

        // Modified Catch Rate
        double a;
        int rate = wildPokemon.getCatchRate();
        double bonusBall = ball.getBallMultiplier();
        StatusCondition status = wildPokemon.getStatusCondition();
        double bonusStat;

        if (status.equals(StatusCondition.NORMAL)) {
            bonusStat = 1.0;
        }
        else if (status.equals(StatusCondition.BURNED)) {
            bonusStat = 1.5;
        }
        else if (status.equals(StatusCondition.POISONED)) {
            bonusStat = 1.5;
        }
        else if (status.equals(StatusCondition.BADLY_POISONED)) {
            bonusStat = 1.5;
        }
        else if (status.equals(StatusCondition.PARALYZED)) {
            bonusStat = 1.5;
        }
        else if (status.equals(StatusCondition.SLEEPING)) {
            bonusStat = 2.0;
        }
        else if (status.equals(StatusCondition.FROZEN)) {
            bonusStat = 2.0;
        }
        else{
            bonusStat = 1.0;
        }

        a = (((((3 * wildPokemon.getMaxHP()) - (2 * wildPokemon.getHP())) * rate * bonusBall) / (3 * wildPokemon.getMaxHP())) * bonusStat);

        double b;

        b = 1048560 / Math.sqrt(Math.sqrt(16711680/a));

        int shakeChecker1 = rand.nextInt(65535);
        int shakeChecker2 = rand.nextInt(65535);
        int shakeChecker3 = rand.nextInt(65535);
        int shakeChecker4 = rand.nextInt(65535);

        System.out.println(a); //REMOVE LATER
        System.out.println(b); //REMOVE LATER
        System.out.println(shakeChecker1); //REMOVE LATER
        System.out.println(shakeChecker2); //REMOVE LATER
        System.out.println(shakeChecker3); //REMOVE LATER
        System.out.println(shakeChecker4); //REMOVE LATER

        if ((b > shakeChecker1) && (b > shakeChecker2) && (b > shakeChecker3) && (b > shakeChecker4)) {
            return true;
        }
        return false;
    }

    public boolean throwPokeball(Pokemon wildPokemon, PartyPokemon party, PC pc, BattleType battleType) {

        if (battleType.equals(BattleType.WILD)) {

            Scanner scnr = new Scanner(System.in);

            System.out.println("");
            System.out.println("Select a PokeBall");
            System.out.println("1. Poke Ball");
            System.out.println("2. Great Ball");
            System.out.println("3. Ultra Ball");
            System.out.println("4. Master Ball");

            int selectedBall = scnr.nextInt();

            if (selectedBall == 1) {
                PokeBalls balls = new PokeBalls();
                boolean caught = catchPokemon(wildPokemon, balls, 1);

                if (caught == true) {

                    System.out.println(wildPokemon.getSpecies() + " was captured!");

                    int partySize = party.partyPokemon.size();
                    if (partySize < 6) {
                        party.partyPokemon.add(wildPokemon);
                        System.out.println(wildPokemon.getSpecies() + " was added to your party!");
                        return true;
                    }

                    else {
                        pc.PC.add(wildPokemon);
                        System.out.println("Your party is full " + wildPokemon.getSpecies() + " was transferrred to your pc!");
                        return true;
                    }
                }
                else {
                    System.out.println("The Pokemon escaped!");
                    return false;
                }
            }

            else if (selectedBall == 2) {
                PokeBalls balls = new PokeBalls();
                boolean caught = catchPokemon(wildPokemon, balls, 2);

                if (caught == true) {

                    System.out.println(wildPokemon.getSpecies() + " was captured!");

                    int partySize = party.partyPokemon.size();
                    if (partySize < 6) {
                        party.partyPokemon.add(wildPokemon);
                        System.out.println(wildPokemon.getSpecies() + " was added to your party!");
                        return true;
                    }

                    else {
                        pc.PC.add(wildPokemon);
                        System.out.println("Your party is full " + wildPokemon.getSpecies() + " was transferrred to your pc!");
                        return true;
                    }
                }
                else {
                    System.out.println("The Pokemon escaped!");
                    return false;
                }
            }

            else if (selectedBall == 3) {
                PokeBalls balls = new PokeBalls();
                boolean caught = catchPokemon(wildPokemon, balls, 3);

                if (caught == true) {

                    System.out.println(wildPokemon.getSpecies() + " was captured!");

                    int partySize = party.partyPokemon.size();
                    if (partySize < 6) {
                        party.partyPokemon.add(wildPokemon);
                        System.out.println(wildPokemon.getSpecies() + " was added to your party!");
                        return true;
                    } else {
                        pc.PC.add(wildPokemon);
                        System.out.println("Your party is full " + wildPokemon.getSpecies() + " was transferrred to your pc!");
                        return true;
                    }
                }
                else {
                    System.out.println("The Pokemon escaped!");
                    return false;
                }
            }

            else if (selectedBall == 4) {
                PokeBalls balls = new PokeBalls();
                boolean caught = catchPokemon(wildPokemon, balls, 4);

                if (caught == true) {

                    System.out.println(wildPokemon.getSpecies() + " was captured!");

                    int partySize = party.partyPokemon.size();
                    if (partySize < 6) {
                        party.partyPokemon.add(wildPokemon);
                        System.out.println(wildPokemon.getSpecies() + " was added to your party!");
                        return true;
                    }

                    else {
                        pc.PC.add(wildPokemon);
                        System.out.println("Your party is full " + wildPokemon.getSpecies() + " was transferrred to your pc!");
                        return true;
                    }
                }

                else {
                    System.out.println("The Pokemon escaped!");
                }
            }

            else {
                System.out.println("Not a valid choice!");
            }
        }

        else {
            System.out.println("You cannot catch a trainer Pokemon!");
        }

        return false;
    }
}