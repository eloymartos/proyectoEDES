import clases.*
import kotlin.system.exitProcess

/**
 * ### Main
 *
 * Crea a todsos los pokemon y los ataques y hace que empiece el juego
 */
fun main() {
    // Creación de los Pokemon
    val listapokemons = arrayOf(
        Pokemon("Pikachu", "Es amarillo y flama, lo conoce hasta mi abuela", Tipo("electrico"), 75),
        Pokemon("Charmander", "Si lo tocas puedes quemarte", Tipo("fuego"), 90),
        Pokemon("Squirtle", "Tiene mas agua que el mar", Tipo("agua"), 70),
        Pokemon("Geodude", "Una piedra no tienes mas", Tipo("roca"), 85),
        Pokemon("Pidgey", "Tiene alas y vuela", Tipo("volador"), 85),
        Pokemon("Ratata", "Una puta rata, Asqueroso", Tipo("normal"), 50),
        Pokemon("Bulbasaur", "A este no lo queria nadie", Tipo("planta"), 49),
        Pokemon("Eevee", "Pequeño animal de aspecto adorable y evolución incierta.", Tipo("Normal"), 55),
        Pokemon("Abra", "Pequeña criatura psíquica capaz de teletransportarse.", Tipo("psiquico"), 70),
        Pokemon("Jigglypuff", "Criatura rosa con una canción hipnótica.", Tipo("normal"), 115),
        Pokemon("Gastly", "Criatura de humo venenoso que asusta a sus presas.", Tipo("fantasma"), 65),
        Pokemon("Psyduck", "Pato amarillo confundido y de gran poder psíquico.", Tipo("agua"), 55)
    )
    val listamovimientos = arrayOf(
        Ataque("Pistola agua", Tipo("agua"), 10),
        Ataque("Ascuas", Tipo("fuego"), 10),
        Ataque("Impactrueno", Tipo("electrico"), 10),
        Ataque("Placaje", Tipo("normal"), 7),
        Ataque("Llamarada", Tipo("fuego"), 90),
        Ataque("Hidro Bomba", Tipo("agua"), 110),
        Ataque("Rayo Solar", Tipo("planta"), 120),
        Ataque("Trueno", Tipo("electrico"), 110),
        Ataque("Terremoto", Tipo("tierra"), 100),
        Ataque("Vuelo", Tipo("volador"), 90),
        Ataque("Puño Dinámico", Tipo("lucha"), 70),
        Ataque("Rayo Psíquico", Tipo("psiquico"), 90),
        Ataque("Corte", Tipo("normal"), 50),
        Ataque("Pedrada", Tipo("roca"), 75)
    )
    for (i in listapokemons){
        i.asignarAtaques(listamovimientos)
    }
    //Elección de Pokemon por los jugadores

    val entrenador1 = Entrenador()
    seleccionarPokemon(listapokemons, entrenador1, 1)



    val entrenador2 = Entrenador()
    seleccionarPokemonAutomatico(listapokemons, entrenador2, 2)

    println("")
    //Comienza el combate
    println("Hora de pelear!")

    println("Entrenador 1, con que pokemon quieres empezar:")
    entrenador1.mostrarEquipo()
    entrenador1.pokemonEnCampo = readln().toInt()
    Thread.sleep(1000)

    println("Entrenador 2, con que pokemon quieres empezar:")
    entrenador2.mostrarEquipo()
    entrenador2.pokemonEnCampo = readln().toInt()
    Thread.sleep(1000)

    while (true) {

        turno(entrenador1, 1, entrenador2)

        turno(entrenador2, 2, entrenador1)


    }
}

/**
 * ### Funcion [turno]
 *
 * @return Funcion que simula cada turno con 3 opciones, cambiar el pokemon en el campo, atcar o rendirse, tambien hace la comprobacion de si han muerto tods los pokemon del jugador
 */
fun turno(entrenador: Entrenador, numero: Int, rival:Entrenador){
    println("turno del jugador $numero!")
    Thread.sleep(1000)
    println("Qué quieres hacer ?\ncambiar = 1\natacar = 2\nrendirse = 3")
    var pierde = false
    when(readln().toInt()){
        1->{
            entrenador.mostrarEquipo()
            Thread.sleep(1000)

            println("elige pokemon")
            entrenador.pokemonEnCampo = readln().toInt()
            println("el entrenador $numero sacó a ${entrenador.sacarPokemon().nombre}")
        }
        2->{
            println("__________________________________\n${ entrenador.sacarPokemon().mostrarAtaques() }\n__________________________________")
            println("${rival.sacarPokemon().recibir_ataque(entrenador.sacarPokemon().atacar())} \n")
            Thread.sleep(1000)
        }
        3->{
            pierde = true
        }
        else-> turno(entrenador, numero, rival)
    }
    if (entrenador.pierde()) {
        println("Te has rendido")
        exitProcess(1)
    }
    if (rival.sacarPokemon().vida<=0){
        rival.removerPokemon()
        rival.mostrarEquipo()
        if (rival.pierde()) {
            println("El rival ha perdido")
            exitProcess(1)
        }
        println("jugador rival, elige pokemon a sacar")
        rival.pokemonEnCampo = readln().toInt()
    }

}

fun turno_automatico(entrenador: Entrenador, numero: Int, rival:Entrenador){
    println("turno del jugador $numero!")
    Thread.sleep(1000)
    println("Qué quieres hacer ?\ncambiar = 1\natacar = 2\nrendirse = 3")
    var pierde = false
    when((1..2).random()){
        1->{
            entrenador.mostrarEquipo()
            Thread.sleep(1000)

            println("elige pokemon")
            entrenador.pokemonEnCampo = (1..6).random()
            println("el entrenador $numero sacó a ${entrenador.sacarPokemon().nombre}")
        }
        2->{
            println("__________________________________\n${ entrenador.sacarPokemon().mostrarAtaques() }\n__________________________________")
            println("${rival.sacarPokemon().recibir_ataque(entrenador.sacarPokemon().atacar())} \n")
            Thread.sleep(1000)
        }
        3->{
            pierde = true
        }
        else-> turno(entrenador, numero, rival)
    }
    if (rival.sacarPokemon().vida<=0){
        rival.removerPokemon()
        rival.mostrarEquipo()
        if (pierde || rival.pierde()) {
            println("El rival ha perdido")
            exitProcess(1)
        }
        println("jugador rival, elige pokemon a sacar")
        rival.pokemonEnCampo = (1..6).random()
    }

}

/**
 * ### Funcion [seleccionarPokemon]
 *
 * @return Muestra un menu con los pokemon disonibles y pide al jugador que seleccione 6 o menos ya que si pones 0 en algun momento se completa el equipo con los pokemons que hayas seleccionado, por ultimo muestra el equipo creado
 */
fun seleccionarPokemon(lista : Array<Pokemon>, entrenador: Entrenador, numero : Int){
    println("Qué pokemon quieres que tenga entrenador $numero?")
    println("1. Pikachu     7. Bulbasaur\n2. Charmander     8. Eevee\n3. Squirtle       9. Abra\n4. Geodude     10. Jigglypuff\n5. Pidgey       11. Gastly\n6. Ratata       12. Psyduck\n0. Suficiente")
    var opcion :Int
    var contador = 1
    for (i in 0..5){
        print("Pokemon $contador: ")
        opcion = readln().toInt()
        when (opcion){
            1 -> {entrenador.agregarPokemon(lista[0])}
            2 -> {entrenador.agregarPokemon(lista[1])}
            3 -> {entrenador.agregarPokemon(lista[2])}
            4 -> {entrenador.agregarPokemon(lista[3])}
            5 -> {entrenador.agregarPokemon(lista[4])}
            6 -> {entrenador.agregarPokemon(lista[5])}
            7 -> {entrenador.agregarPokemon(lista[6])}
            8 -> {entrenador.agregarPokemon(lista[7])}
            9 -> {entrenador.agregarPokemon(lista[8])}
            10 -> {entrenador.agregarPokemon(lista[9])}
            11 -> {entrenador.agregarPokemon(lista[10])}
            12 -> {entrenador.agregarPokemon(lista[11])}
            0-> {
                if (entrenador.pierde()) {
                    println("error, equipo vacio")
                    seleccionarPokemon(lista, entrenador, numero)
                }
                break
            }
            else ->{
                if (entrenador.pierde()) {
                    println("error")
                    seleccionarPokemon(lista, entrenador, numero)
                }
            }
        }
        contador += 1
    }
    entrenador.mostrarEquipo()

}

fun seleccionarPokemonAutomatico(lista : Array<Pokemon>, entrenador: Entrenador, numero : Int){
    println("RIVAL")
    var opcion :Int
    for (i in 0..5){
        opcion = (1..12).random()
        when (opcion){
            1 -> {entrenador.agregarPokemon(lista[0])}
            2 -> {entrenador.agregarPokemon(lista[1])}
            3 -> {entrenador.agregarPokemon(lista[2])}
            4 -> {entrenador.agregarPokemon(lista[3])}
            5 -> {entrenador.agregarPokemon(lista[4])}
            6 -> {entrenador.agregarPokemon(lista[5])}
            7 -> {entrenador.agregarPokemon(lista[6])}
            8 -> {entrenador.agregarPokemon(lista[7])}
            9 -> {entrenador.agregarPokemon(lista[8])}
            10 -> {entrenador.agregarPokemon(lista[9])}
            11 -> {entrenador.agregarPokemon(lista[10])}
            12 -> {entrenador.agregarPokemon(lista[11])}
            0-> {
                if (entrenador.pierde()) {
                    println("error, equipo vacio")
                    seleccionarPokemon(lista, entrenador, numero)
                }
                break
            }
            else ->{
                if (entrenador.pierde()) {
                    println("error")
                    seleccionarPokemon(lista, entrenador, numero)
                }
            }
        }
    }
    entrenador.mostrarEquipo()

}