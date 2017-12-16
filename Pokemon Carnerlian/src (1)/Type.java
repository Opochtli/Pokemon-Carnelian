public enum Type {
    NORMAL,
    FIGHT,
    FLYING,
    POISON,
    GROUND,
    ROCK,
    BUG,
    GHOST,
    STEEL,
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    PSYCHIC,
    ICE,
    DRAGON,
    DARK,
    FAIRY;

    public static double StabCheck(Move move, Pokemon pokemon){
        if (move.getType() == pokemon.getType()){
            return 1.5;
        }
        else {
            return 1.0;
        }
    }

    public static double EffectCheck(Move move, Pokemon pokemon) {
        Type moveType = move.getType();
        Type pokemonType = pokemon.getType();

        if (moveType.equals(NORMAL) && (pokemonType.equals(ROCK) || pokemonType.equals(STEEL))) {
            return 0.5;
        }

        else if (moveType.equals(NORMAL) && (pokemonType.equals(GHOST))) {
            return 0.0;
        }


        else if (moveType.equals(FIGHT)
                && (pokemonType.equals(NORMAL) || pokemonType.equals(ROCK) || pokemonType.equals(STEEL) || pokemonType.equals(ICE) || pokemonType.equals(DARK))) {
            return 2.0;
        }

        else if (moveType.equals(FIGHT)
                && (pokemonType.equals(FLYING) || pokemonType.equals(POISON) || pokemonType.equals(BUG) || pokemonType.equals(PSYCHIC) || pokemonType.equals(FAIRY))) {
            return 0.5;
        }

        else if (moveType.equals(FIGHT) && (pokemonType.equals(GHOST))) {
            return 0.0;
        }

        else if (moveType.equals(FLYING) && (pokemonType.equals(FIGHT) || pokemonType.equals(BUG) || pokemonType.equals(GRASS))) {
            return 2.0;
        }

        else if (moveType.equals(FLYING) && (pokemonType.equals(ROCK) || pokemonType.equals(STEEL) || pokemonType.equals(ELECTRIC))) {
            return 0.5;
        }

        else if (moveType.equals(POISON) && (pokemonType.equals(GRASS) || pokemonType.equals(FAIRY))) {
            return 2.0;
        }

        else if (moveType.equals(POISON)
                && (pokemonType.equals(POISON) || pokemonType.equals(GROUND) || pokemonType.equals(ROCK) || pokemonType.equals(GHOST))) {
            return 0.5;
        }

        else if (moveType.equals(POISON) && (pokemonType.equals(STEEL))) {
            return 0.0;
        }

        else if (moveType.equals(GROUND)
                && (pokemonType.equals(POISON) || pokemonType.equals(ROCK) || pokemonType.equals(STEEL) || pokemonType.equals(STEEL)
                || pokemonType.equals(FIRE) || pokemonType.equals(ELECTRIC))) {
            return 2.0;
        }

        else if (moveType.equals(GROUND) && (pokemonType.equals(BUG) || pokemonType.equals(GRASS))) {
            return 0.5;
        }

        else if (moveType.equals(GROUND) && (pokemonType.equals(FLYING))) {
            return 0.0;

        } else if (moveType.equals(ROCK)
                && (pokemonType.equals(FLYING) || pokemonType.equals(BUG) || pokemonType.equals(FIRE) || pokemonType.equals(ICE))) {
            return 2.0;
        }

        else if (moveType.equals(ROCK) && (pokemonType.equals(FIGHT) || pokemonType.equals(GROUND) || pokemonType.equals(STEEL))) {
            return 0.5;
        }

        else if (moveType.equals(BUG) && (pokemonType.equals(GRASS) || pokemonType.equals(PSYCHIC) || pokemonType.equals(DARK))) {
            return 2.0;
        }

        else if (moveType.equals(BUG)
                && (pokemonType.equals(FIGHT) || pokemonType.equals(FLYING) || pokemonType.equals(POISON) || pokemonType.equals(GHOST)
                || pokemonType.equals(STEEL) || pokemonType.equals(FIRE) || pokemonType.equals(FAIRY))) {
            return 0.5;
        }

        else if (moveType.equals(GHOST) && (pokemonType.equals(GHOST) || pokemonType.equals(PSYCHIC))) {
            return 2.0;
        }

        else if (moveType.equals(GHOST) && (pokemonType.equals(DARK))) {
            return 0.5;
        }

        else if (moveType.equals(GHOST) && (pokemonType.equals(NORMAL))) {
            return 0.0;
        }

        else if (moveType.equals(STEEL) && (pokemonType.equals(ROCK) || pokemonType.equals(ICE) || pokemonType.equals(FAIRY))) {
            return 2.0;
        }

        else if (moveType.equals(FIRE)
                && (pokemonType.equals(BUG) || pokemonType.equals(STEEL) || pokemonType.equals(GRASS) || pokemonType.equals(ICE))) {
            return 2.0;
        }

        else if (moveType.equals(FIRE)
                && (pokemonType.equals(ROCK) || pokemonType.equals(FIRE) || pokemonType.equals(WATER) || pokemonType.equals(DRAGON))) {
            return 0.5;
        }

        else if (moveType.equals(WATER) && (pokemonType.equals(GROUND) || pokemonType.equals(ROCK) || pokemonType.equals(FIRE))) {
            return 2.0;
        }

        else if (moveType.equals(WATER) && (pokemonType.equals(WATER) || pokemonType.equals(GRASS) || pokemonType.equals(DRAGON))) {
            return 0.5;
        }

        else if (moveType.equals(GRASS) && (pokemonType.equals(GROUND) || pokemonType.equals(ROCK) || pokemonType.equals(WATER))) {
            return 2.0;
        }

        else if (moveType.equals(GRASS)
                && (pokemonType.equals(FLYING) || pokemonType.equals(POISON) || pokemonType.equals(BUG) || pokemonType.equals(STEEL)
                || pokemonType.equals(FIRE) || pokemonType.equals(GRASS) || pokemonType.equals(DRAGON))) {
            return 0.5;
        }

        else if (moveType.equals(ELECTRIC) && (pokemonType.equals(FLYING) || pokemonType.equals(WATER))) {
            return 2.0;
        }

        else if (moveType.equals(ELECTRIC) && (pokemonType.equals(GRASS) || pokemonType.equals(ELECTRIC) || pokemonType.equals(DRAGON))) {
            return 0.5;
        }

        else if (moveType.equals(ELECTRIC) && (pokemonType.equals(GROUND))) {
            return 0.0;
        }

        else if (moveType.equals(PSYCHIC) && (pokemonType.equals(FIGHT) || pokemonType.equals(POISON))) {
            return 2.0;
        }

        else if (moveType.equals(PSYCHIC) && (pokemonType.equals(DARK))) {
            return 0.0;
        }

        else if (moveType.equals(ICE)
                && (pokemonType.equals(FLYING) || pokemonType.equals(GROUND) || pokemonType.equals(GRASS) || pokemonType.equals(DRAGON))) {
            return 2.0;
        }

        else if (moveType.equals(ICE)
                && (pokemonType.equals(STEEL) || pokemonType.equals(FIRE) || pokemonType.equals(WATER) || pokemonType.equals(ICE))) {
            return 0.5;
        }

        else if (moveType.equals(DRAGON) && (pokemonType.equals(DRAGON))) {
            return 2.0;
        }

        else if (moveType.equals(DRAGON) && (pokemonType.equals(STEEL))) {
            return 0.5;
        }

        else if (moveType.equals(DRAGON) && (pokemonType.equals(FAIRY))) {
            return 0.0;
        }

        else if (moveType.equals(DARK) && (pokemonType.equals(GHOST) || pokemonType.equals(PSYCHIC))) {
            return 2.0;
        }

        else if (moveType.equals(DARK) && (pokemonType.equals(FIGHT) || pokemonType.equals(DARK) || pokemonType.equals(FAIRY))) {
            return 0.5;
        }

        else if (moveType.equals(FAIRY) && (pokemonType.equals(FIGHT) || pokemonType.equals(DRAGON) || pokemonType.equals(DARK))) {
            return 2.0;
        }

        else if (moveType.equals(FAIRY) && (pokemonType.equals(POISON) || pokemonType.equals(STEEL) || pokemonType.equals(FIRE))) {
            return 0.5;
        }

        else {
            return 1;
        }

    }

}

