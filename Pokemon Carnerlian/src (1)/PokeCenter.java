public class PokeCenter {

    public static void healPokemon(PartyPokemon party) {

        System.out.println("");
        System.out.println("Welcome to the Poke Center, where we restore your tired Pokemon to full health!");
        System.out.println("...");
        System.out.println("Your Pokemon have been restored to full health!");
        System.out.println("Have a great day!");
        System.out.println("");

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
}
