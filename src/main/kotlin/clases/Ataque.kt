package clases
/**
 *### Clase [Ataque]
 *
 * @constructor (nombre: [Strinf], tipo: [Tipo], danio[Int])
 *
 * @param nombre [String] : Nombre del ataque en formato Cadena
 * @param tipo [Tipo] : Es el tipo del ataque y es de formato Tipo que es otra clase del
 *                      proyecto la cual indica el tipo del pokemon en una cadena y comprueba que sea correcta.
 * @param potencia [Int] : Es el daño que hace cada ataque independientemente de la efectividad y está en formato de número entero
 */
class Ataque(nombre: String, tipo:String, danio:Int):Tipo("") {

    var nombre : String
    var potencia : Int

    init {
        this.nombre = nombre
        this.tipo = tipo
        this.potencia = danio
    }

}