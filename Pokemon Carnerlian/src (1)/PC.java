import java.util.ArrayList;
import static java.util.Arrays.sort;

public class PC {

        ////////////////
        ArrayList<Pokemon> PC;
        int size = 150;

        public PC(int size) { PC = new ArrayList(); }

        //Get PC Total
        public ArrayList<Pokemon> getList() { return PC; }

        //Get PC Pokemon
        public Pokemon getPokemon1() { return PC.get(0); }

        public Pokemon getPokemon2() { return PC.get(1); }

        public Pokemon getPokemon3() { return PC.get(2); }

        public Pokemon getPokemon4() { return PC.get(3); }

        public Pokemon getPokemon5() { return PC.get(4); }

        public Pokemon getPokemon6() { return PC.get(5); }

        public void checkPC(PC pc) {
                int pcSize = pc.PC.size();
                System.out.println("");
                System.out.println("Your PC");
                for (int i = 0; i < pcSize; ++i){
                        System.out.println(pc.PC.get(i).getSpecies());
                }
        }
}
