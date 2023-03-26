import clases.*

fun main(args:Array<String>) {
    // Creación de los Pokemon
    var Pikachu = Pokemon("Pikachu", "Es amarillo y flama, lo oconoce hasta mi abuela", Tipo("electrico"), 75)
    var Charmander = Pokemon("Charmander", "Si lo tocas puedes quemarte", Tipo("fuego"), 90)
    var Squirtle = Pokemon("Squirtle", "Tiene mas agia que el mar", Tipo("agua"), 70)
    var Geodude = Pokemon("Geodude", "Una piedra no tienes mas", Tipo("roca"), 85)
    var Pidgey = Pokemon("Pidgey", "Tiene alas y vuela", Tipo("volador"), 85)
    var Ratata = Pokemon("Ratata", "Una puta eata, Asqueroso", Tipo("normal"), 50)
    var Bulbasaur = Pokemon("Bulbasaur", "A este no lo queria nadie", Tipo("planta"), 49)
    var Eevee = Pokemon("Eevee", "Pequeño animal de aspecto adorable y evolución incierta.", Tipo("Normal"), 55)
    var Abra = Pokemon("Abra", "Pequeña criatura psíquica capaz de teletransportarse.", Tipo("psiquico"), 70)
    var Jigglypuff = Pokemon("Jigglypuff", "Criatura rosa con una canción hipnótica.", Tipo("normal"), 115)
    val Gastly = Pokemon("Gastly", "Criatura de humo venenoso que asusta a sus presas.", Tipo("fantasma"), 65)
    val Psyduck = Pokemon("Psyduck", "Pato amarillo confundido y de gran poder psíquico.", Tipo("agua"), 55)

    //Creación de los Ataques
    val pistolaAgua = Ataque("Pistola agua", Tipo("agua"), 10)
    val ascuas = Ataque("Ascuas", Tipo("fuego"), 10)
    val impactrueno = Ataque("Impactrueno", Tipo("electrico"), 10)
    val placaje = Ataque("Placaje", Tipo("normal"), 7)
    var llamarada = Ataque("Llamarada", Tipo("fuego"), 90)
    var hidroBomba = Ataque("Hidro Bomba", Tipo("agua"), 110)
    var rayoSolar = Ataque("Rayo Solar", Tipo("planta"), 120)
    var trueno = Ataque("Trueno", Tipo("electrico"), 110)
    var terremoto = Ataque("Terremoto", Tipo("tierra"), 100)
    var vuelo = Ataque("Vuelo", Tipo("volador"), 90)
    var puñoDinamico = Ataque("Puño Dinámico", Tipo("lucha"), 70)
    var rayoPsiquico = Ataque("Rayo Psíquico", Tipo("psiquico"), 90)
    var corte = Ataque("Corte", Tipo("normal"), 50)
    var pedrada = Ataque("Pedrada", Tipo("roca"), 75)

    //Elección de Pokemon por los jugadores
    println("Qué pokemon quieres que tenga entrenador 1?")
    println("1. Pikachu     7. Bulbasaur\n2. Charmander     8. Eevee\n3. Squirtle       9. Abra\n4. Geodude     10. Jigglypuff\n5. Pidgey       11. Gastly\n6. Ratata       12. Psyduck")
    var opcion = 0
    var contador = 1
    var entrenador1 = Entrenador()
    for (i in 0..5){
        print("Pokemon $contador: ")
        opcion = readln().toInt()
        when (opcion){
            1 -> {entrenador1.agregarPokemon(Pikachu)}
            2 -> {entrenador1.agregarPokemon(Charmander)}
            3 -> {entrenador1.agregarPokemon(Squirtle)}
            4 -> {entrenador1.agregarPokemon(Geodude)}
            5 -> {entrenador1.agregarPokemon(Pidgey)}
            6 -> {entrenador1.agregarPokemon(Ratata)}
            7 -> {entrenador1.agregarPokemon(Bulbasaur)}
            8 -> {entrenador1.agregarPokemon(Eevee)}
            9 -> {entrenador1.agregarPokemon(Abra)}
            10 -> {entrenador1.agregarPokemon(Jigglypuff)}
            11 -> {entrenador1.agregarPokemon(Gastly)}
            12 -> {entrenador1.agregarPokemon(Psyduck)}
        }
        contador += 1
    }
    entrenador1.mostrarEquipo()

    println(entrenador1)

    println("")
    println("Qué pokemon quieres que tenga entrenador 2?")
    println("1. Pikachu\n2. Charmander\n3. Squirtle\n4. Geodude\n5. Pidgey\n6. Ratata\n7. Bulbasaur\n8. Eevee\n9. Abra\n10. Jigglypuff\n11. Gastly\n12. Psyduck")
    print("Pokemon: ")

    opcion = readln().toInt()
    var Entrenador_Paco = Entrenador()
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

    while (true) {
        println("Turno Entrenador Paco, con que pokemoon quieres empezar:")
        Thread.sleep(1000)
        Entrenador_Paco.mostrarEquipo()
        var pokemon_elegido = readln().toInt() - 1

        //println("${Entrenador_Paco[1]}")

    }

    /*
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

    }*/
}