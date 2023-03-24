import clases.Ataque
import clases.Pokemon
import clases.Tipo

fun main(args:Array<String>) {
    // Creación de los Pokemon
    var Pikachu = Pokemon("Pikachu", "Es amarillo y flama, lo oconoce hasta mi abuela", Tipo("electrico"), 50, 125)
    var Charmander = Pokemon("Charmander", "Si lo tocas puedes quemarte", Tipo("fuego"), 65, 110)
    var Squirtle = Pokemon("Squirtle", "Tiene mas agia que el mar", Tipo("agua"), 52, 120)

    //Creación De los Ataques
    var Pistola_Agua = Ataque("Pistola Agua", Tipo("agua"), 25)

}