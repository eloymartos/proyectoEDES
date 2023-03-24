import clases.Ataque
import clases.Jugador
import clases.Pokemon
import clases.Tipo

fun main(args:Array<String>) {
    // Creación de los Pokemon
    var Pikachu = Pokemon("Pikachu", "Es amarillo y flama, lo oconoce hasta mi abuela", Tipo("electrico"), 50, 125)
    var Charmander = Pokemon("Charmander", "Si lo tocas puedes quemarte", Tipo("fuego"), 65, 110)
    var Squirtle = Pokemon("Squirtle", "Tiene mas agia que el mar", Tipo("agua"), 52, 120)


    println("Qué pokemon quieres que tenga entrenador 1?")
    var opcion1 = readln()
    var entrenador1 = if (opcion1 == "pikachu") Pikachu else if (opcion1 == "charmander") Charmander else Squirtle

    println("Qué pokemon quieres que tenga entrenador 2?")
    var opcion2 = readln()
    var entrenador2 = if (opcion2 == "pikachu") Pikachu else if (opcion2 == "charmander") Charmander else Squirtle

}