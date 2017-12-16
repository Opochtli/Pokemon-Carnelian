import java.util.ArrayList;
import java.util.Scanner;

public class PartyPokemon {

    ArrayList<Pokemon> partyPokemon;
    int size = 6;

    public PartyPokemon(int size) {
        partyPokemon = new ArrayList();
    }

    //Get Party Total
    public ArrayList<Pokemon> getList() { return partyPokemon; }

    //Get Party Pokemon (1st Pokemon in party with Hp > 0)
    public Pokemon getPokemon1() { return partyPokemon.get(0); }

    public Pokemon getPokemon2() { return partyPokemon.get(1); }

    public Pokemon getPokemon3() { return partyPokemon.get(2); }

    public Pokemon getPokemon4() { return partyPokemon.get(3); }

    public Pokemon getPokemon5() { return partyPokemon.get(4); }

    public Pokemon getPokemon6() { return partyPokemon.get(5); }

    public Pokemon getNextPokemon() {
        for(Pokemon thisPokemon : partyPokemon) {
            if(thisPokemon.getHP() > 0) {
                return thisPokemon;
            }
        }
        return null;
    }

    public void partyPokemonChecker(PartyPokemon party) {

        Scanner scnr = new Scanner(System.in);

        int partySize = party.partyPokemon.size();
        System.out.println("");
        System.out.println("Your Party:");
        System.out.println("");

        for (int i = 0; i < partySize; ++i){
            System.out.println((i + 1) + " " + party.partyPokemon.get(i).getSpecies() + " " + party.partyPokemon.get(i).getHP() + "/" + party.partyPokemon.get(i).getMaxHP());
        }

        System.out.println("");
        System.out.println("Which Pokemon would you like to inspect?");

        int checkStatsFor = (scnr.nextInt() -1);

        System.out.println("Your Pokemon is a " + party.partyPokemon.get(checkStatsFor).getSpecies());
        System.out.println( "Hp: " + party.partyPokemon.get(checkStatsFor).getHP() + "/" + party.partyPokemon.get(checkStatsFor).getMaxHP());

        System.out.println(party.partyPokemon.get(checkStatsFor).getMove1().getMoveName() + " " + party.partyPokemon.get(checkStatsFor).getMove1().getMovePP() + "/"
                + party.partyPokemon.get(checkStatsFor).getMove1().getMaxPP() + "      " + party.partyPokemon.get(checkStatsFor).getMove2().getMoveName() + " " +
                party.partyPokemon.get(checkStatsFor).getMove2().getMovePP() + "/"
                + party.partyPokemon.get(checkStatsFor).getMove2().getMaxPP());

        System.out.println(party.partyPokemon.get(checkStatsFor).getMove3().getMoveName() + " " + party.partyPokemon.get(checkStatsFor).getMove3().getMovePP() + "/"
                + party.partyPokemon.get(checkStatsFor).getMove3().getMaxPP() + "      " + party.partyPokemon.get(checkStatsFor).getMove4().getMoveName() + " " +
                party.partyPokemon.get(checkStatsFor).getMove4().getMovePP() + "/"
                + party.partyPokemon.get(checkStatsFor).getMove4().getMaxPP());

        System.out.println("Attack: " + party.partyPokemon.get(checkStatsFor).getAttack());
        System.out.println("Defense: " + party.partyPokemon.get(checkStatsFor).getDefense());
        System.out.println("Speed: " + party.partyPokemon.get(checkStatsFor).getSpeed());
        System.out.println("HP: " + party.partyPokemon.get(checkStatsFor).getHP());
        System.out.println("Level: " + party.partyPokemon.get(checkStatsFor).getLevel());
        System.out.println("Exp: " + party.partyPokemon.get(checkStatsFor).getExp());
    }
}
