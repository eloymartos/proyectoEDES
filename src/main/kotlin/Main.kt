import clases.Ataque
import clases.Jugador
import clases.Pokemon
import clases.Tipo

fun main(args:Array<String>) {
    // Creación de los Pokemon
    var Pikachu = Pokemon("Pikachu", "Es amarillo y flama, lo oconoce hasta mi abuela", Tipo("electrico"), 125)
    var Charmander = Pokemon("Charmander", "Si lo tocas puedes quemarte", Tipo("fuego"), 110)
    var Squirtle = Pokemon("Squirtle", "Tiene mas agia que el mar", Tipo("agua"), 120)

    val pistolaAgua = Ataque("Pistola agua", Tipo("agua"), 10)
    val ascuas = Ataque("Ascuas", Tipo("fuego"), 10)
    val impactrueno = Ataque("Impactrueno", Tipo("electrico"), 10)
    val placaje = Ataque("Placaje", Tipo("normal"), 7)

    println("Qué pokemon quieres que tenga entrenador 1?")
    var opcion1 = readln()
    var entrenador1 = Jugador(if (opcion1 == "pikachu") Pikachu else if (opcion1 == "charmander") Charmander else Squirtle)

    println("Qué pokemon quieres que tenga entrenador 2?")
    var opcion2 = readln()
    var entrenador2 = Jugador(if (opcion2 == "pikachu") Pikachu else if (opcion2 == "charmander") Charmander else Squirtle)

    val mapamovimientos = mutableMapOf(Pikachu to impactrueno, Charmander to ascuas, Squirtle to pistolaAgua)

    println("Hora de pelear!")

    while (true){
        println("turno del jugador 1!")
        Thread.sleep(1000)

        println("${entrenador1.pokemon.nombre} usó ${mapamovimientos[entrenador1.pokemon]!!.nombre}")
        entrenador2.pokemon.recibir_ataque(mapamovimientos[entrenador1.pokemon]!!)
        Thread.sleep(500)

        if (entrenador2.pokemon.vida <=0) {
            println("el pokemon del entrenador 2 pierde !!!!!")
            break
        } else println("${entrenador2.pokemon.toString()}\n")
        Thread.sleep(2000)

        println("turno del jugador 2!")
        Thread.sleep(1000)

        println("${entrenador2.pokemon.nombre} usó ${mapamovimientos[entrenador2.pokemon]!!.nombre}")
        entrenador1.pokemon.recibir_ataque(mapamovimientos[entrenador2.pokemon]!!)
        Thread.sleep(500)

        if (entrenador1.pokemon.vida <=0) {
            println("el pokemon del entrenador 1 pierde !!!!!")
            break
        } else println("${entrenador1.pokemon.toString()}\n")
        Thread.sleep(2000)


    }
}