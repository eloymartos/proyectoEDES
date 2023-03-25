package clases
/**
 * ### Clase [Jugador]
 *
 * @constructor (pokemon: [Pokemon])
 *
 * @param pokemon [Pokemon] : Cada Jugador tiene un pokemon de la clase [Pokemon]
 */
class Jugador(pokemon : Pokemon) {

    var pokemon:Pokemon

    init {
        this.pokemon = pokemon
    }

}