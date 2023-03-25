package clases

class Pokemon(nombre:String, lore:String, tipo:Tipo, fuerza:Int, vida:Int) {

    var nombre : String
    var lore : String
    var tipo : Tipo
    var fuerza : Int
    var vida : Double
    var ataques = Array<Ataque?>(4) { null }

    init {
        this.nombre = nombre
        this.lore = lore
        this.tipo = tipo
        this.fuerza = fuerza
        this.vida = vida.toDouble()
    }

    fun recibir_ataque(ataque: Ataque) {
        vida -= (ataque.potencia*tipo.efectividad(ataque.tipo))
    }

    override fun toString(): String {
        return "a $nombre le quedan ${vida.toInt()} ps"
    }
}