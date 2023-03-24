package clases

class Pokemon(nombre:String, lore:String, tipo:Tipo, fuerza:Int, vida:Int) {

    var nombre : String
    var lore : String
    var tipo : Tipo
    var fuerza : Int
    var vida : Int

    init {
        this.nombre = nombre
        this.lore = lore
        this.tipo = tipo
        this.fuerza = fuerza
        this.vida = vida
    }



}