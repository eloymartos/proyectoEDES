package clases

class Entrenador {

    private val equipo: Array<Pokemon?> = arrayOfNulls(6)

    var pokemonEnCampo =0
        set(value) {
            if (value !in (1..6) || equipo[value] == null || value == pokemonEnCampo){
                println("error, intente dde nuevo")
                pokemonEnCampo = readln().toInt()
            } else field = value-1
        }

    fun agregarPokemon(pokemon: Pokemon) {
        for (i in equipo.indices) {
            if (equipo[i] == null) {
                equipo[i] = pokemon
                return
            }
        }
        println("No se puede agregar más Pokémon al equipo.")
    }

    fun removerPokemon(pokemon: Pokemon) {
        for (i in equipo.indices) {
            if (equipo[i] == pokemon) {
                equipo[i] = null
                return
            }
        }
        println("El Pokémon no se encuentra en el equipo.")
    }

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
