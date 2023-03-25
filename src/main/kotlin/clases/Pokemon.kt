package clases
/**
 *### Clase [Pokemon]
 *
 * @constructor (nombre: [Strinf], lore: [String], tipo: [Tipe], vida: [Int])
 *
 * @param nombre [String] : Nombre del ataque en formato Cadena
 * @param lore [String] : Un breve resumen de la historia del Pokemon
 * @param tipo [Tipo] : Es el tipo del pokemon y es de formato Tipo que es otra clase del
 *                      proyecto la cual indica el tipo del pokemon en una cadena y comprueba que sea correcta.
 * @param vida [Int] : Es la vida o PS que tiene el pokemon, está se actualiza cada vez que un pokemon recibe un ataque.
 */
class Pokemon(nombre:String, lore:String, tipo:Tipo, vida:Int) {

    var nombre : String
    var lore : String
    var tipo : Tipo
    var vida : Double
    var ataques = Array<Ataque?>(4) { null }

    init {
        this.nombre = nombre
        this.lore = lore
        this.tipo = tipo
        this.vida = vida.toDouble()
    }

    /**
     * ### Funcion Recibir Ataque
     *
     * @param ataque: [Ataque] : Recibe un Ataque que hace un pokemon y de el sacamos la potencia base y el tipo para analizar la efectiidad del mismo
     * @return Actualiza la vida del pokemon que tecibe el ataque
     */
    fun recibir_ataque(ataque: Ataque) {
        vida -= (ataque.potencia * tipo.efectividad(ataque))
    }

    /**
     * ### Funcion [toString]
     *
     * @return Devuelve una cadena con el nombre y la vida restante del Pokemon
     */

    override fun toString(): String {
        return "a $nombre le quedan ${vida.toInt()} ps"
    }
}