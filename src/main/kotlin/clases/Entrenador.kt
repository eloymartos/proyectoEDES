package clases
/**
 * ###Clase [Entrenador]
 *
 * @constructor (equipo: [Array], pokemonEnCampo: [Int])
 *
 * @param equipa [Array] : Una lista que guarda los 6 Pokemons de un entrenador, empieza vacia pero se rellena en el main
 * @para pokemonEnCampo [Int] : Valor número que indica el pokemon del equipo que está en el campo de batalla
 */
class Entrenador {

    private val equipo: Array<Pokemon?> = arrayOfNulls(6)

    var pokemonEnCampo =0
        set(value) {
            if (value !in (1..7) || equipo[value] == null || value == pokemonEnCampo){
                println("error, intente dde nuevo")
                pokemonEnCampo = readln().toInt()
            } else field = value-1
        }

    /**
     * ### Funcion [agregarPokemon]
     *
     * @param Pokemon: Recibe un pokemon para añadirlo al equipo del entrenador
     *
     * @return Añade un pokemon al equipo
     */
    fun agregarPokemon(pokemon: Pokemon) {
        for (i in equipo.indices) {
            if (equipo[i] == null) {
                equipo[i] = pokemon
                return
            }
        }
        println("No se puede agregar más Pokémon al equipo.")
    }

    /**
     * ### Funcion [removerPokemon]
     *
     * @param Pokemon: Recibe un pokemon para retirarlo al equipo del entrenador
     *
     * @return Quita un pokemon al equipo, lo usaremos para los pokemons muertos
     */
    fun removerPokemon(pokemon: Pokemon) {
        for (i in equipo.indices) {
            if (equipo[i] == pokemon) {
                equipo[i] = null
                return
            }
        }
        println("El Pokémon no se encuentra en el equipo.")
    }

    /**
     * ### Funcion [mostrarEquipo]
     *
     * @return Imprime por pantalla el equipo de un entrenador
     */
    fun mostrarEquipo() {
        println("Equipo:")
        for (i in equipo.indices) {
            if (equipo[i] != null) {
                println("${i + 1}. ${equipo[i]?.nombre}")
            } else {
                println("${i + 1}. -")
            }
        }
    }
    fun sacarPokemon():Pokemon{
        return equipo[pokemonEnCampo]!!
    }
}
