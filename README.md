# Proyecto Final 2º Trimestre
---
 Eloy Martos y José Manuel Luque
---

![alt text](https://www.kissfm.es/wp-content/uploads/2022/06/pokemon.jpg)

---

**Perfil Github Eloy: <https://github.com/eloymartos> <br>**
**Perfil Github Josema: <https://github.com/JoseManuelLuque>**

Documento de refactorizacion = <a href="https://github.com/eloymartos/proyectoEDES/blob/cd8613e5be796fe723af45421d7682644e93d410/refactorizacion.pdf">enlace</a>

# Resumen del proyecto

### Clase Tipo
` Esta es la base de Pokemon y Ataque, contiene todos los posibles tipos y las efectividades de estos, aparte del tipo en concreto `
<hr>

` tiene la funcion efectividad que segun la efectividad de un movimiento respecto a nuestro tipo, devuelve un multiplicador `

### Clase Ataque
` Esta hereda de Tipo y aparte, contiene Nombre y Potencia `

### Clase Pokemon
` Esta hereda de Tipo y aparte, contiene Nombre, Lore, Vida y Ataques, siendo este ultimo una lista de ataques `
<hr>

`Tiene varias funciones :` <br>
`Recibir ataque, resta a la vida la potencia por efectividad de un ataque, segun el resultado da una cadena u otra, siendo la diferencia que la vida sea menor o igual que 0 ` <br>
`Asignar ataques, de forma aleatoria saca ataques de una lista y si son comparibles con nuestro tipo, los guardamos, hasta un maximo de 4` <br>
` Mostrar ataques, muestra los ataques con sus atributos ` <br>
`Atacar, que recibe el nombre del ataque a devolver ` <br>
`AtacarIA, que devuelve un ataque random para que use la IA ` 

### Clase Entrenador
`Esta es independiente, tiene un array de 3 pokemon y un valor que se llama pokemonencampo, representa la posicion en la lista del pokemon en campo` <hr>
`Tiene las funciones : ` <br>
`AgregarPokemon, que recibe un pokemon que añade a la primera posicion libre que vea en el equipo` <br>
`RemoverPokemon, que quita el pokemon que haya en campo` <br>
`MostrarEquipo, bastante descriptivo` <br>
`PokemonActual, devuelve el pokemon actual` <br>
`Pierde, si todo el equipo está vacío, devuelve True, si no, False`

### Clase Main
`Es la clase main del proyecto, en esta se crean una lista de pokemons, una de movimientos,asigna movimientos a todos los pokemons , te pide si vas a jugar 1vs1 o 1vsIA, y segun lo que escribas hace una cosa u otra` <hr>
`Tiene bastantes funciones, bastante grandes : ` <br>

`seleccionarPokemon, que va pidiendo de forma manual que pokemon quieres, si pones 0 y ya tienes 1 pokemon no te pide mas` <br>
`seleccionarPokemonIa, lo mismo pero automatico` <br>
`Turno, te pide qué hacer, segun lo que elijas hace lo necesario, cambiar de pokemon, atacar o rendirse` <br>
`TurnoIA, que hace un turno automatico, destinado a ser usado por la IA` <br>
`Combate1vs1, va avanzando el combate, pide pokemon a sacar de primeras a los dos y ejecuta turnos hasta que uno de los dos pierda` <br>
`CombatevsIA, lo mismo, pero a ti te pide tus opciones, a la ia usa sus funciones automatizadas`
