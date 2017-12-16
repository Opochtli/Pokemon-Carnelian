import java.util.ArrayList;
import java.util.Random;
import static java.util.Arrays.sort;


public class Pokedex {

    Random rand = new Random();

    ArrayList<Pokemon> pokedex;
    int size;
    public Pokedex(int pokedexSize) {
        pokedex = new ArrayList();
        size = pokedexSize;
    }

    public String[] listPokemon() {

        int listLength = pokedex.size();
        String[] listPokemon = new String[listLength];
        for (int i = 0; i < listLength; i++) {
            listPokemon[i] = pokedex.get(i).getSpecies();
        }
        return listPokemon;
    }

    public boolean addPokemon(String species) {
        String[] duplicateTest = listPokemon();
        for (int i =0; i < duplicateTest.length; i++) {
            if(species.toLowerCase().equals(duplicateTest[i].toLowerCase())){
                System.out.println("Duplicate");
                return false;
            }
        }
        if (pokedex.size() < size) {
            Pokemon newPokemon = new Pokemon(3,5);
            pokedex.add(newPokemon);
            return true;
        }
        else{
            System.out.println("Max");
            return false;
        }
    }

    public int[] checkStats(String species){
        int[] stats = new int[5];

        for (Pokemon x: pokedex) {
            if (x.getSpecies().equals(species)) {
                stats[0] = x.getAttack();
                stats[1] = x.getDefense();
                stats[2] = x.getSpeed();
                stats[3] = x.getHP();

                return stats;
            }
        }
        stats[0] = -1;
        return stats;
    }

    public void sortPokedex() {
        String[] list = listPokemon();
        ArrayList<Pokemon> newPokedex = new ArrayList();
        sort(list);

        for(int i = 0; i < list.length; i++) {
            String name = list[i];
            for(int j = 0; j < list.length; j++)
            {
                if(name.equals(pokedex.get(j).getSpecies())) {
                    newPokedex.add(pokedex.get(j));
                }
            }
        }
        pokedex = newPokedex;
    }
}
