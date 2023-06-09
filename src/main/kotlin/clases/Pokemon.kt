package clases
/**
 *### Clase [Pokemon]
 *
 * @constructor (nombre: [String], lore: [String], tipo: [Tipo], vida: [Int])
 *
 * @param nombre [String] : Nombre del ataque en formato Cadena
 * @param lore [String] : Un breve resumen de la historia del Pokemon
 * @param tipo [Tipo] : Es el tipo del pokemon y es de formato Tipo que es otra clase del
 *                      proyecto la cual indica el tipo del pokemon en una cadena y comprueba que sea correcta.
 * @param vida [Int] : Es la vida o PS que tiene el pokemon, está se actualiza cada vez que un pokemon recibe un ataque.
 */
class Pokemon(nombre:String, lore:String, tipo:String, vida:Int):Tipo("") {

    var nombre : String
    private var lore : String
    var vida : Double
    private var ataques = mutableListOf<Ataque>()

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
    fun recibir_ataque(ataque: Ataque):String {
        vida -= (ataque.potencia * efectividad(ataque))
        return if (vida>0)"a $nombre le quedan $vida ps" else "$nombre ha muerto"
    }


    /**
     * ### Funcion [asignarAtaques]
     *
     * @return Asigna los 4 ataques a cada pokemon
     */
    fun asignarAtaques(listamovimientos : Array<Ataque>){
        var contador = 0
        while (true){
            var nuevo = listamovimientos.random()
            ataques.add(nuevo)
            contador++
            if (contador == 4) break
            }
        }

    /**
     * ### Funcion [mostrarAtaques]
     *
     * @return Imprime por pantalla los 4 ataques del pokemon
     */
    fun mostrarAtaques() :String{
        var cadena = ("Ataques de $nombre")
        for (i in ataques){
            cadena += "\n${i.nombre} tipo = ${i.tipo} potencia = ${i.potencia}"
        }
        return cadena
    }

    /**
     * Funcion [atacar]
     *
     * @return Funcion que se usa para lanzar un ataque
     */
    fun atacar():Ataque{
        val nombre = readln()
        for (i in ataques){
            if (nombre == i.nombre) return i
        }
        println("no se encuentra el ataque")
        return atacar()
    }

    /**
     * ### Funcion [ataqueIA]
     *
     * @return Funcion que usa la IA para atacar.
     */
    fun ataqueIA():Ataque{
        return ataques.random()
    }
}