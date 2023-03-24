package clases

class Ataque(nombre: String, tipo:Tipo, danio:Int) {

    var nombre : String
    var tipo : Tipo
    var danio : Int

    init {
        this.nombre = nombre
        this.tipo = tipo
        this.danio = danio
    }

}