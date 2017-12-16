import javax.swing.*;
import java.awt.*;

import java.util.Scanner;
import java.util.Random;

public class Main {

    //Global Boolean Declarations (used to Quit game)
    static boolean playing = true;

    public static void main(String[] args) {

        // Establish new scanner for user input
        Scanner scnr = new Scanner(System.in);

        //Establish Class Objects for the New Game
        Pokedex thisPokedex = new Pokedex(150);
        PartyPokemon party = new PartyPokemon(6);
        PokeCenter pokeCenter = new PokeCenter();
        PC pc = new PC(250);
        Bag bag = new Bag(150);

        ////////////////////////JFRAMES TEST////////////////////////
        /*
        JFrame mainFrame = new JFrame("Pokemon Carnelian");
        mainFrame.setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);

        JLabel label1 = new JLabel("Main Menu");

        JButton button1 = new JButton();
        button1.setText("Choose Bulbasaur");
        button1.setLayout(null);
        button1.setBounds(400, 100, 100, 60);

        JButton button2 = new JButton();
        button2.setText("Choose Charmander");


        JButton button3 = new JButton();
        button3.setText("Choose Squirtle");

        panel1.add(label1);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);

        mainFrame.add(panel1);
        mainFrame.setSize(1200,800);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        ////////////////////////JFRAMES TEST////////////////////////
        */

        System.out.println("Welcome to the world of Pokemon!");
        System.out.println("");

        System.out.println("Please choose your starter Pokemon:");
        System.out.println("Press 1 to choose Bulbasaur");
        System.out.println("Press 2 to choose Charmander");
        System.out.println("Press 3 to choose Squirtle");

        //Declare starter, default Pokemon is a Bulbasaur until changed
        Pokemon starter = new Pokemon(1, 5);

        //Starter can be (1) Bulbasaur (2) Charmander or (3) Squirtle
        int chosenStarter = scnr.nextInt();

        if (chosenStarter == 1){
            starter = new Pokemon(1,5);
        }
        else if (chosenStarter == 2){
            starter = new Pokemon(4,5);
        }
        else if (chosenStarter == 3){
            starter = new Pokemon(7,5);
        }

        //Party Size will be used to determine if a new Pokemon is
        //added to the Party or sent to the PC
        int partySize = party.partyPokemon.size();

        //Add Starter to Party (party should always be empty until starter is added)
        if (partySize < 6){
            party.partyPokemon.add(starter);
        }
        else {
            pc.PC.add(starter);
            return;
        }

        //Starts the Main Menyu for the game
        menu(thisPokedex, party, bag, pokeCenter, pc);
    }

    ////////////////////////MAIN MENU METHOD////////////////////////
    public static void menu(Pokedex pokedex, PartyPokemon party, Bag bag, PokeCenter pokeCenter, PC pc) {

        // Establish new scanner for user input
        Scanner scnr = new Scanner(System.in);

        //Establish Random for use in Menu functions
        Random rand = new Random();

        //Other initial declarations
        int menuSelection = 0;
        boolean menu = true;
        playing = true;

        //Main Game Loop
        while (playing) {

            menu = true;

            //Main Menu Loop
            while (menu) {

                System.out.println();
                System.out.println("1. PC");
                System.out.println("2. Battle Wild Pokemon");
                System.out.println("3. Party");
                System.out.println("4. Battle a Trainer");
                System.out.println("5. Visit Poke Center");
                System.out.println("6. Exit");
                System.out.println();
                System.out.print("What would you like to do?");

                ////////////////////////////////////////////////////////////////////////
                //Try catch for invalid inputs
                try {
                    menuSelection = scnr.nextInt();
                    scnr.nextLine();
                }

                catch (Exception e) {
                    scnr.nextLine();
                }

                if (menuSelection < 7 && menuSelection > 0) {
                    menu = false;
                }

                else {
                    //Invalid input entered
                    System.out.println("That is not a valid choice. Try again.");
                    // Ask for input again
                }
                ////////////////////////////////////////////////////////////////////////

                int pokemonID = rand.nextInt(7)+1;

                if (menuSelection == 1) {
                    pc.checkPC(pc);
                }

                else if (menuSelection == 2) {
                    //Establish Enemy Pokemon
                    Pokemon wildPokemon = new Pokemon(pokemonID, rand.nextInt(5) + 1);
                    System.out.println("You have encountered a wild " + wildPokemon.getSpecies());
                    System.out.println("Level: " + wildPokemon.getLevel());
                    System.out.println("Attack: " + wildPokemon.getAttack());
                    System.out.println("Defense: " + wildPokemon.getDefense());
                    System.out.println("Speed: " + wildPokemon.getSpeed());
                    System.out.println("HP: " + wildPokemon.getHP());

                    Battle wildPokemonBattle = new Battle();
                    wildPokemonBattle.Battle(party, wildPokemon, pc);
                }

                else if (menuSelection == 3) {

                    party.partyPokemonChecker(party);
                }

                else if (menuSelection == 4) {

                    int trainer = rand.nextInt(2) +1;

                    if (trainer == 1) {
                        TrainerBattle battle = new TrainerBattle();
                        battle.trainerTimmyBattle(party);
                    }
                    else if (trainer == 2) {
                        TrainerBattle battle = new TrainerBattle();
                        battle.beautyEmmaBattle(party);
                    }
                    else{
                        TrainerBattle battle = new TrainerBattle();
                        battle.hikerLloydBattle(party);
                    }
                }

                else if (menuSelection == 5) {
                    pokeCenter.healPokemon(party);
                }

                else if (menuSelection == 6) {
                    quitGame();
                }

            }
        }
    }

    //////////// Quit Game Method ////////////
    public static void quitGame() {
        playing = false;
    }

}