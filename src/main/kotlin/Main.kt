import clases.Ataque
import clases.Jugador
import clases.Pokemon
import clases.Tipo

fun main(args:Array<String>) {
    // Creación de los Pokemon
    var Pikachu = Pokemon("Pikachu", "Es amarillo y flama, lo oconoce hasta mi abuela", Tipo("electrico"), 125)
    var Charmander = Pokemon("Charmander", "Si lo tocas puedes quemarte", Tipo("fuego"), 110)
    var Squirtle = Pokemon("Squirtle", "Tiene mas agia que el mar", Tipo("agua"), 120)

    //Creación de los Ataques
    val pistolaAgua = Ataque("Pistola agua", Tipo("agua"), 10)
    val ascuas = Ataque("Ascuas", Tipo("fuego"), 10)
    val impactrueno = Ataque("Impactrueno", Tipo("electrico"), 10)
    val placaje = Ataque("Placaje", Tipo("normal"), 7)

    //Elección de Pokemon por los jugadores
    println("Qué pokemon quieres que tenga entrenador 1?")
    println("1. Pikachu\n2. Charmander\n3. Squirtle")
    print("Pokemon: ")
    var opcion = readln().toInt()
    var entrenador1 = Jugador(Squirtle)
    when (opcion){
        1 -> {entrenador1 = Jugador(Pikachu)}
        2 -> {entrenador1 = Jugador(Charmander)}
        3 -> {entrenador1 = Jugador(Squirtle)}
    }

    println("")
    println("Qué pokemon quieres que tenga entrenador 2?")
    println("1. Pikachu\n2. Charmander\n3. Squirtle")
    print("Pokemon: ")

    opcion = readln().toInt()
    var entrenador2 = Jugador(Squirtle)
    when (opcion){
        1 -> {entrenador2 = Jugador(Pikachu)}
        2 -> {entrenador2 = Jugador(Charmander)}
        3 -> {entrenador2 = Jugador(Squirtle)}
    }
    val mapamovimientos = mutableMapOf(Pikachu to impactrueno, Charmander to ascuas, Squirtle to pistolaAgua)

    println("")
    //Comienza el combate
    println("Hora de pelear!")

    //Simulación de combate
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