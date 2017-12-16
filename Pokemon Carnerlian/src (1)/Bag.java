import java.util.ArrayList;
import static java.util.Arrays.sort;

public class Bag {

    ////////////////PokeBalls ////////////////
    ArrayList<Pokemon> PokeBalls;
    int size = 150;

    public Bag(int size) { PokeBalls = new ArrayList(); }

    //Get Party Total
    public ArrayList<Pokemon> getList() { return PokeBalls; }

    //Get Party Pokemon (1st Pokemon in party with Hp > 0)
    public Pokemon getPokemon1() { return PokeBalls.get(0); }

    public Pokemon getPokemon2() { return PokeBalls.get(1); }

    public Pokemon getPokemon3() { return PokeBalls.get(2); }

    public Pokemon getPokemon4() { return PokeBalls.get(3); }

    public Pokemon getPokemon5() { return PokeBalls.get(4); }

    public Pokemon getPokemon6() { return PokeBalls.get(5); }


    /*
    ////////////////Items ////////////////

    ArrayList<Pokemon> Items;

    public Bag(int size) { Items = new ArrayList(); }

    //Get Party Total
    public ArrayList<Pokemon> getList() { return Items; }

    //Get Party Pokemon (1st Pokemon in party with Hp > 0)
    public Pokemon getPokemon1() { return Items.get(0); }

    public Pokemon getPokemon2() { return Items.get(1); }

    public Pokemon getPokemon3() { return Items.get(2); }

    public Pokemon getPokemon4() { return Items.get(3); }

    public Pokemon getPokemon5() { return Items.get(4); }

    public Pokemon getPokemon6() { return Items.get(5); }

    */
}
