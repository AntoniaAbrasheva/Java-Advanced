package DefiningClasses.exercise.google;

public class Pokemon {
    private String pokemonName;
    private String pokemonType;

    public Pokemon(String pokemonName,String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }
    @Override
    public String toString() {
        return String.format("%s %s",this.pokemonName,this.pokemonType);
    }
}